"use strict";
exports.__esModule = true;
exports.BrowserslistPlugin = void 0;
var utils_1 = require("./utils");
//var browserslist = require('browserslist');
// Your CSS/JS build tool code
// function process(source, opts) {
//     const browsers = browserslist(opts.overrideBrowserslist, {
//         stats: opts.stats,
//         path: opts.file,
//         env: opts.env
//     })
// }
// From ts
// export let GetErrors: string = "GetErrors";
// export let FixErrors: string = "FixErrors";
var BrowserslistCommands;
(function (BrowserslistCommands) {
    BrowserslistCommands.GetCoverage = 'GetCoverage';
    BrowserslistCommands.GetBrowsers = 'GetBrowsers';
})(BrowserslistCommands || (BrowserslistCommands = {}));
var Response = /** @class */ (function () {
    function Response() {
    }
    return Response;
}());
var BrowserslistPlugin = /** @class */ (function () {
    function BrowserslistPlugin(state) {
        // this.browserslistApi = resolveBrowserslist(state.pluginPath)
        // this.additionalRulesDirectory = state.additionalRootDirectory
    }
    BrowserslistPlugin.prototype.process = function (parsedObject) {
        switch (parsedObject.command) {
            case BrowserslistCommands.GetBrowsers: {
                return { output: "Hello world" };
                return null;
                // return this.getBrowsers(parsedObject.arguments)
            }
            case BrowserslistCommands.GetCoverage: {
                return this.getCoverage(parsedObject.arguments);
            }
        }
        return null;
    };
    BrowserslistPlugin.prototype.onMessage = function (p, writer) {
        var request = JSON.parse(p);
        // here we use object -> JSON.stringify, because we need to escape possible error's text symbols
        // and we do not want to duplicate this code
        writer.write(JSON.stringify({ output: "test" }));
        var response = new Response();
        response.version = 1; // this.browserslistApi.version.raw
        response.command = request.command;
        response.request_seq = request.seq;
        var result;
        try {
            result = this.process(request);
        }
        catch (e) {
            response.error = e.toString() + '\n\n' + e.stack;
            writer.write(JSON.stringify(response));
            return;
        }
        if (result) {
            response.body = result.output;
        }
        writer.write(JSON.stringify(response));
    };
    BrowserslistPlugin.prototype.getBrowsers = function (toProcess) {
        return undefined;
        // return this.processLinting(toProcess, this.getOptions(false))
    };
    BrowserslistPlugin.prototype.getCoverage = function (toProcess) {
        var percent = this.browserslistApi.browserslist.coverage(toProcess);
        return { output: percent };
    };
    BrowserslistPlugin.prototype.getOptions = function (fix) {
        return {
            formatter: 'json',
            fix: fix,
            rulesDirectory: this.additionalRulesDirectory
        };
    };
    return BrowserslistPlugin;
}());
exports.BrowserslistPlugin = BrowserslistPlugin;
function resolveBrowserslist(packagePath) {
    var browserslist = require(packagePath);
    var version = (0, utils_1.getVersion)(browserslist);
    return { browserslist: browserslist, version: version };
}
