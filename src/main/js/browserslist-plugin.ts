import {getVersion, Version} from './utils'

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
namespace BrowserslistCommands {
    export let GetCoverage: string = 'GetCoverage'
    export let GetBrowsers: string = 'GetBrowsers'
}

type BrowserslistApi = {
    browserslist: typeof browserslist;
    version: Version
}

class Response {
    version?: string
    command: string
    request_seq: number
    body: string | null
    error: string | null
}

export class BrowserslistPlugin implements LanguagePlugin {

    private readonly browserslistApi: BrowserslistApi
    private readonly additionalRulesDirectory?: string

    constructor(state: PluginState) {
        this.browserslistApi = resolveBrowserslist(state.packagePath, state.packageJsonPath)
        // this.additionalRulesDirectory = state.additionalRootDirectory
    }

    private process(parsedObject: ServiceRequest<any>): { output: string } | null {
        switch (parsedObject.command) {
            case BrowserslistCommands.GetBrowsers: {
                return { output: "Hello world" }
                return null
                // return this.getBrowsers(parsedObject.arguments)
            }
            case BrowserslistCommands.GetCoverage: {
                return this.getCoverage(parsedObject.arguments)
            }
        }

        return null
    }

    onMessage(p: string, writer: MessageWriter): void {
        const request: ServiceRequest<any> = JSON.parse(p)
        // here we use object -> JSON.stringify, because we need to escape possible error's text symbols
        // and we do not want to duplicate this code
        let response: Response = new Response()
        response.version = "1" // this.browserslistApi.version.raw
        response.command = request.command
        response.request_seq = request.seq

        let result
        try {
            result = this.process(request)
        } catch (e) {
            response.error = e.toString() + '\n\n' + e.stack
            response.a = 43
            response.b = this.browserslistApi.browserslist
            writer.write(JSON.stringify(response))
            return
        }
        if (result) {
            response.body = result.output
        }
        writer.write(JSON.stringify(response))
    }

    private getBrowsers(toProcess: any): unknown {
        return undefined
        // return this.processLinting(toProcess, this.getOptions(false))
    }

    private getCoverage(toProcess: any): { output: number } {
        const percent = this.browserslistApi.browserslist.coverage(this.browserslistApi.browserslist(toProcess.queries))
        return { output: {percent, queries: toProcess.queries } }
    }

    private getOptions(fix: boolean) {
        return {
            formatter: 'json',
            fix: fix,
            rulesDirectory: this.additionalRulesDirectory
        }
    }

    // private processLinting(args: CommandArguments & { content: string }, options: ILinterOptions): LintResult {
    //     let linter = this.browserslistApi.linter
    //     let major = this.browserslistApi.version.major || 0
    //
    //     let configuration = this.getConfiguration(args.filePath, args.configPath)
    //     if (major >= 4) {
    //         let tslint = new linter(options)
    //         tslint.lint(args.filePath, args.content, configuration)
    //         return tslint.getResult()
    //     }
    //     (<any>options).configuration = configuration
    //     let tslint = new (<any>linter)(args.filePath, args.content, options)
    //     return tslint.lint()
    // }
    //
    // private getConfiguration(fileName: string, configFileName: string): IConfigurationFile {
    //     let majorVersion = this.browserslistApi.version.major
    //     let configurationResult = this.browserslistApi.linter.findConfiguration(configFileName, fileName)
    //     if (majorVersion && majorVersion >= 4) {
    //         if (!configurationResult || !configurationResult.results) {
    //             throw new Error('Cannot find configuration ' + configFileName)
    //         }
    //         return configurationResult.results
    //     }
    //     return (<IConfigurationFile>configurationResult)
    // }
}

function resolveBrowserslist(packagePath: string, packageJsonPath: string): BrowserslistApi {
    const browserslist: any = requireInContext(packagePath, packageJsonPath);
    const version = 1 // getVersion(browserslist)
    return { browserslist, version }
}

function requireInContext(modulePathToRequire: string, contextPath?: string): any {
  const contextRequire = getContextRequire(contextPath);
  return contextRequire(modulePathToRequire);
}

function getContextRequire(contextPath?: string): NodeRequire {
  if (contextPath != null) {
    const module = require('module')
    if (typeof module.createRequire === 'function') {
      // https://nodejs.org/api/module.html#module_module_createrequire_filename
      // Implemented in Yarn PnP: https://next.yarnpkg.com/advanced/pnpapi/#requiremodule
      return module.createRequire(contextPath);
    }
    // noinspection JSDeprecatedSymbols
    if (typeof module.createRequireFromPath === 'function') {
      // Use createRequireFromPath (a deprecated version of createRequire) to support Node.js 10.x
      // noinspection JSDeprecatedSymbols
      return module.createRequireFromPath(contextPath);
    }
    throw Error('Function module.createRequire is unavailable in Node.js ' + process.version +
      ', Node.js >= 12.2.0 is required')
  }
  return require;
}