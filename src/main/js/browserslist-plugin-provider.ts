import {BrowserslistPlugin} from './browserslist-plugin'

class BrowserslistPluginFactory implements LanguagePluginFactory {
    create(state: PluginState): { languagePlugin: LanguagePlugin } {
        return { languagePlugin: new BrowserslistPlugin(state) }
    }
}

export const factory = new BrowserslistPluginFactory()
