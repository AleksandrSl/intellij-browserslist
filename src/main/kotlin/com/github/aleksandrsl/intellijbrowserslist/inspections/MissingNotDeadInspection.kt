package com.github.aleksandrsl.intellijbrowserslist.inspections

import com.github.aleksandrsl.intellijbrowserslist.BrowserslistBundle
import com.github.aleksandrsl.intellijbrowserslist.BrowserslistLanguage
import com.github.aleksandrsl.intellijbrowserslist.psi.*
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.codeInspection.util.IntentionFamilyName
import com.intellij.lang.injection.InjectedLanguageManager
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.findParentOfType

class BrowserslistMissingNotDeadInspection : BrowserslistInspectionBase() {
    private val addNotDeadQuickFix = AddNotDeadQueryQuickFix()
    private val moveNotDeadQuickFix = MoveNotDeadQueryQuickFix()

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {
            override fun visitElement(element: PsiElement) {
                super.visitElement(element)
                if (element is BrowserslistSection) {
                    // Not likely but we may have a bunch of last query
                    val lastQuery =
                        PsiTreeUtil.findChildrenOfType(element, BrowserslistLastQuery::class.java).lastOrNull()
                            ?: return

                    // Check if any query to the right is "not dead"
                    val hasNotDeadAfter = collectQueriesToTheRight(lastQuery).any { query ->
                        query is BrowserslistDeadQuery && query.parent?.parent is BrowserslistNotExpression
                    }

                    if (!hasNotDeadAfter) {
                        // If there is more than one already, it's a different kind of decease and needs another quick fix. We can just add one more instead of moving the last one for now.
                        val quickFix = if (findNotDeadExpressions(element).size == 1) {
                            moveNotDeadQuickFix
                        } else {
                            addNotDeadQuickFix
                        }

                        holder.registerProblem(
                            lastQuery,
                            BrowserslistBundle.message("browserslist.inspection.missed.not.dead.problem.descriptor"),
                            quickFix
                        )
                    }
                }
            }
        }
    }
}

private fun collectQueriesToTheRight(lastQuery: BrowserslistLastQuery): List<BrowserslistQuery> {
    val result = mutableListOf<BrowserslistQuery>()
    var current: PsiElement = lastQuery.parent // Start from the expression containing lastQuery
    var lastAncestorOfQuery: PsiElement = lastQuery

    // Walk up the tree
    while (current !is BrowserslistSection && current.parent != null) {
        // If we're in a binary expression, check the right side
        if (current is BrowserslistBinaryExpression) {
            val left = current.left
            val right = current.right

            if (left == lastAncestorOfQuery && right != null) {
                // lastQuery is on the left, so collect all queries from the right
                result.addAll(PsiTreeUtil.findChildrenOfType(right, BrowserslistQuery::class.java))
            }
            // If right == lastAncestorOfQuery, lastQuery is on the right, continue walking up
        }
        lastAncestorOfQuery = current
        current = current.parent
    }

    // Now collect queries from following expressions in the same section
    if (current is BrowserslistSection) {
        val currentExpression = PsiTreeUtil.findFirstParent(lastQuery) {
            it.parent is BrowserslistSection
        } as? BrowserslistQueryExpression

        if (currentExpression != null) {
            val expressions = current.queryExpressionList
            val currentIndex = expressions.indexOf(currentExpression)

            // Add all queries from following expressions
            for (i in (currentIndex + 1) until expressions.size) {
                result.addAll(PsiTreeUtil.findChildrenOfType(expressions[i], BrowserslistQuery::class.java))
            }
        }
    }
    return result
}

class AddNotDeadQueryQuickFix : LocalQuickFix {
    override fun getFamilyName(): @IntentionFamilyName String {
        return BrowserslistBundle.message("browserslist.inspection.missed.not.dead.add.use.quickfix")
    }

    override fun applyFix(
        project: Project, descriptor: ProblemDescriptor
    ) {
        val element = descriptor.psiElement as BrowserslistLastQuery
        addNotDeadQuery(project, element)
    }
}

class MoveNotDeadQueryQuickFix : LocalQuickFix {
    override fun getFamilyName(): @IntentionFamilyName String {
        return BrowserslistBundle.message("browserslist.inspection.missed.not.dead.move.use.quickfix")
    }

    override fun applyFix(
        project: Project, descriptor: ProblemDescriptor
    ) {
        val element = descriptor.psiElement as BrowserslistLastQuery
        val section = element.findParentOfType<BrowserslistSection>() ?: return


        val existingNotDeadExpressions = findNotDeadExpressions(section)
        // We should not suggest this fix in such cases
        if (existingNotDeadExpressions.size != 1) return
        removeNotDeadFromSection(project, existingNotDeadExpressions.first())
        addNotDeadQuery(project, element)
    }
}

private fun removeNotDeadFromSection(
    project: Project,
    notDeadExpression: BrowserslistQueryExpression
): Boolean {
    val closestBinaryExpression: BrowserslistBinaryExpression? =
        notDeadExpression.parent as? BrowserslistBinaryExpression

    if (closestBinaryExpression != null) {
        // Step 1 & 2: Found a binary expression - determine which side "not dead" is on
        // and get the other side
        val left = closestBinaryExpression.left
        val right = closestBinaryExpression.right

        val otherSide: BrowserslistQueryExpression? = when {
            PsiTreeUtil.isAncestor(left, notDeadExpression, false) -> right
            right != null && PsiTreeUtil.isAncestor(right, notDeadExpression, false) -> left
            else -> null
        }

        if (otherSide == null) return false

        // Step 3: Replace the binary expression with the other side
        // We need to recreate the PSI from text
        val otherSideText = otherSide.text
        val newExpression = createQueryExpression(project, otherSideText)

        closestBinaryExpression.replace(newExpression)

        return true
    } else {
        // No binary expression found - remove the entire expression and EOL
        val nextSibling = notDeadExpression.nextSibling
        notDeadExpression.delete()

        // Remove EOL after it
        if (nextSibling != null && nextSibling.node.elementType == BrowserslistTypes.EOL) {
            nextSibling.delete()
        }

        return true
    }
}

private fun addNotDeadQuery(project: Project, element: BrowserslistQuery) {
    val parentExpression = element.parent
    val isSingleQuery = isSingleQueryInLine(element)

    val section = element.findParentOfType<BrowserslistSection>() ?: return
    val queryExpressionList = section.queryExpressionList

    if (isSingleQuery && queryExpressionList.size > 1 && !isInjected(project, element)) {
        // Single query in line but there are more in the file - add on the next line
        val notDeadExpression = createQueryExpression(project, "not dead")
        val eol = createEol(project)

        // Add EOL after current expression, then add the new expression
        parentExpression.parent.addAfter(notDeadExpression, parentExpression)
        parentExpression.parent.addAfter(eol, parentExpression)
    } else {
        // Either not a single query in line, or it's the only query in the whole file - add to the same line
        // To avoid recreating the correct tree correctly it's easier to recreate the whole expression
        val topMostParentExpression =
            PsiTreeUtil.findFirstParent(element) { it is BrowserslistQueryExpression && it.parent is BrowserslistSection }
                ?: return
        topMostParentExpression.replace(
            createQueryExpression(
                project, topMostParentExpression.text.replace(element.text, "${element.text}, not dead")
            )
        )
    }
}


private fun isInjected(project: Project, element: PsiElement): Boolean {
    val injectedManager = InjectedLanguageManager.getInstance(project)
    val containingFile = element.containingFile

    return injectedManager.isInjectedFragment(containingFile)
}

private fun findNotDeadExpressions(section: BrowserslistSection): List<BrowserslistQueryExpression> {
    // Could be optimized to check the queries to the left only
    return PsiTreeUtil.findChildrenOfType(section, BrowserslistNotExpression::class.java).filter {
        it.simpleExpression?.firstChild is BrowserslistDeadQuery
    }
}


private fun isSingleQueryInLine(element: BrowserslistQuery): Boolean {
    // Direct parent would be expression, and if there are no more, then the section will be the next
    return element.parent?.parent is BrowserslistSection
}

private fun createFile(project: Project, content: String): BrowserslistFile {
    val name = "dummy.browserslist"
    return PsiFileFactory.getInstance(project)
        .createFileFromText(name, BrowserslistLanguage.INSTANCE, content) as BrowserslistFile
}

private fun createEol(project: Project): PsiElement {
    val file = createFile(project, "\n")
    return file.firstChild
}


private fun createQueryExpression(project: Project, query: String): BrowserslistQueryExpression {
    val file = createFile(project, query)
    return PsiTreeUtil.findChildOfType(file, BrowserslistQueryExpression::class.java)!!
}
