import com.intellij.notification.NotificationType

import com.intellij.notification.NotificationDisplayType

import com.intellij.notification.NotificationGroup
import com.intellij.openapi.project.Project


// After 2020.3 as minimal version update to XML configuration
object BrowserslistNotifier {
    private val NOTIFICATION_GROUP =
        NotificationGroup("Custom Notification Group", NotificationDisplayType.BALLOON, true)

    fun notifyError(project: Project?, content: String?) {
        NOTIFICATION_GROUP.createNotification(content!!, NotificationType.ERROR)
            .notify(project)
    }
}