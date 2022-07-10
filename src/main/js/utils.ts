export type Version = {
    raw?: string | undefined,
    major: number | undefined,
    minor?: number
    patch?: number
}

export function getVersion(browserslist: any): Version {
    // TODO: Linter
    const version = browserslist.VERSION || (browserslist.Linter && browserslist.Linter.VERSION);
    if (version == null) {
        return {major: 3};
    }

    const numbers = (<string>version).split(".").map(value => Number(value));

    return {
        raw: version,
        major: numbers.length > 0 ? numbers[0] : undefined,
        minor: numbers.length > 1 ? numbers[1] : undefined,
        patch: numbers.length > 2 ? numbers[2] : undefined
    };
}
