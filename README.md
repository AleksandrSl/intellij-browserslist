# intellij-browserslist

![Build](https://github.com/AleksandrSl/intellij-browserslist/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [ ] [Publish a plugin manually](https://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/publishing_plugin.html) for the first time.
- [ ] Set the Plugin ID in the above README badges.
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
Adds support for [browserslist](https://github.com/browserslist/browserslist) config

Features:
- Syntax highlighting
- Autocompletion for browsers
- Section folding
- Live templates for some queries
 
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "intellij-browserslist"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/AleksandrSl/intellij-browserslist/releases/latest) and install it manually using
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template

# TODO
- [ ] Recommendations to install plugin
- [ ] Check can-i-use db actuality
- [ ] Check for multiple configs in project
- [ ] Check that configuration could be replaced to "defaults"
- [ ] List of supported browsers facet? or via documentation
- [ ] Support for templates/completion in package.json
- [ ] Migration to Java 11 https://blog.jetbrains.com/platform/2020/09/intellij-project-migrates-to-java-11/


## Notes

Gradle must use 11 java or higher due to grammar-kit-plugin. See [issue](https://github.com/JetBrains/gradle-grammar-kit-plugin/issues/32).
Don't use version of grammarKit from plugin README it doesn't work for obscure reasons, maybe IDEA compatibility.

### Questions to browserslist

Why 
> Obviously you can not start with a not combiner, since there is no left-hand side query to combine it with. The left-hand is always resolved as and combiner even if or is used (this is an API implementation specificity).

We can add not to every query as it's said further. First query IS every.

----

Why these to
```
> .5% and not last 2 versions
> .5% or not last 2 versions
```
give the same result


---

Why precedence differ from usual logic, and has not greater precedence?
```
last 1 version or chrome > 75 and > 1% will select (browser last version or Chrome since 76) and more than 1% marketshare.
```