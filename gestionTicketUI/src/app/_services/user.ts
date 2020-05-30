import { Ticket } from './Ticket';
import { role } from './role';


export class user{
    id:any;
    name: string;
    username: string;
    email: string;
    role: string;
    password: string;
    ticket: Ticket;
    satisfait:boolean
    constructor(name: string, username: string, email: string, password: string) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
      
    
  
    }
}