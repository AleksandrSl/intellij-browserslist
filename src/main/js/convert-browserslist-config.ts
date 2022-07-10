// import * as tslintModule from "tslint";
// import {IOptions} from "tslint";
// import {getVersion} from "./utils";
//
// type TslintModuleType = typeof tslintModule;
//
// const modulePath = process.argv[2];
// const configFilePath = process.argv[3];
// const tslint: TslintModuleType = require(modulePath);
// const version = getVersion(tslint);
// let configFile = version.major && version.major >= 4
//     ? tslint.Configuration.loadConfigurationFromPath(configFilePath)
//     : (<any>tslint).loadConfigurationFromPath(configFilePath);
// let configObject = version.major && version.major >= 5
//     ? {
//         rules: mapToObject(configFile.rules, mapOptions),
//         jsRules: mapToObject(configFile.jsRules, mapOptions)
//     } : configFile;
// console.log(JSON.stringify(configObject))
//
// function mapToObject(map: any, mapper: (p: any) => any) {
//     const rules: any = {};
//     for (let [key, value] of map) {
//         rules[key] = mapper(value)
//     }
//     return rules;
// }
//
// function mapOptions(options: IOptions) {
//     return {
//         severity: options.ruleSeverity.toString(),
//         options: options.ruleArguments
//     }
// }
