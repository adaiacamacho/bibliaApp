export interface CapituloCompleto {
    data: Data;
}

export interface Data {
    id:         string;
    number:     string;
    reference:  string;
    verseCount: number;
    content:    string;
    next:       Next;
    previous:   Previous;
}

export interface Next {
    id:     string;
    number: string;
}

export interface Previous {
    id:     string;
    number: string;
}