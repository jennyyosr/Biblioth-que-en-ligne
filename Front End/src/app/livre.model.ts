export interface ILivre {
    id?: number;
    titre?: string;
    auteur?: string;
    description?: string;
	  image?: string;
    prix?: number;
    genre?: string;
}

export class Livre implements ILivre {
    constructor(public id?: number, public titre?: string, public auteur?: string, public description?: string,public image?: string, public prix?: number, public genre?:string) {}
}
