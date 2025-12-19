<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Browserslist Changelog

## [Unreleased]
### Added
- Inspection: missing not dead query to avoid support for browsers without security updates
- browserslist section in `package.json` is now also recognized as browserslist config
- Code vision for config coverage and with a link to https://browsersl.ist
- 
### Changed
- The minimal supported version changed to 2024.1
- Parsing was reworked. Scope selections work more reasonable, section names can be any other identifier now. Almost all of the language keywords are considered soft and not reserved.
- Improved error recovery and error messages

### Fixed
- Error parsing baseline queries, like `baseline widely available`
- Error parsing `partially/fully support`


## [1.0.2]
### Fixed
- Remove upper IDE version bound

## [1.0.1]
### Fixed
- Fix browsers lexer. Add forgotten and_qq

## [1.0.0]
### Changed
- Compatible IDEs are changed. I'll need JavaScript plugin later, so only paid IDEs that has it are targeted
- All tokens are case-insensitive now. `LaSt 8 ChRoMe vERsions` for the world

## [1.0.0-eap-2]
### Added
- Lowercase browser names in completion

### Fixed
- Fix supported ides' version range

## [1.0.0-eap-1]
### Fixed
- Fixed parsing of compare queries, when there are directly followed by numbers

## [1.0.0-eap]
### Added
- Syntax highlighting
- Autocompletion for browsers
- Section folding
- Live templates for some queries
