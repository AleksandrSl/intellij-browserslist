"use strict";
exports.__esModule = true;
exports.factory = void 0;
var browserslist_plugin_1 = require("./browserslist-plugin");
var BrowserslistPluginFactory = /** @class */ (function () {
    function BrowserslistPluginFactory() {
    }
    BrowserslistPluginFactory.prototype.create = function (state) {
        return { languagePlugin: new browserslist_plugin_1.BrowserslistPlugin(state) };
    };
    return BrowserslistPluginFactory;
}());
exports.factory = new BrowserslistPluginFactory();
