import { user } from './user';


export class Ticket {
    id_ticket: number;
    titre: string;
    description: string;
    user: user;
    statut: string;
    idProcess: String;
    assigner: string;
    actionafaire: string
    actionFaite: string
    labelid: number
    labelname: string



    constructor(titre: string, description: string, labelid: number, labelname: string, user: user) {
        this.description = description;
        this.titre = titre;
        this.labelid = labelid;
        this.user = user;
        this.labelname = labelname

    }

}
