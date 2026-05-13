export interface Buscar {
    data: Data;
}

export interface Data {
    query:  string;
    limit:  number;
    offset: number;
    total: number;
    verses: Verse[];
}

export interface Verse {
    id:        string;
    reference: string;
    text:      string;
}

