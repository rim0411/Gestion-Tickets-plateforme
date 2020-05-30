import { Injectable } from '@angular/core';

import { CATCH_ERROR_VAR } from '@angular/compiler/src/output/output_ast';
import { Ticket } from './_services/Ticket';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { labelc } from './_services/labelc';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class TicketServiceService {

  private baseUrl = 'http://localhost:8080/api/tickets';

  private baseUrl3 = 'http://localhost:8080/api';
  private baseUrl4 = 'http://localhost:8080/label/add';
  private baseUrl7 = ' http://localhost:8080/api/tickets/ajouterTicket'
  private baseUrl8 = ' http://localhost:8080/api/tickets/start'
  private baseUrl2 = 'http://localhost:8080/label/get';

  constructor(private http: HttpClient) { }

  getTicket(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  getlabel(id: number): Observable<labelc> {
    return this.http.get<labelc>(`${this.baseUrl2}/${id}`);
  }
  createlabel(label: labelc): Observable<any> {
    return this.http.post(`${this.baseUrl4}`, {
      "name": label.name
    }, httpOptions);
  }

 /* createTicket(ticket: Ticket): Observable<any> {
    return this.http.post(`${this.baseUrl7}`, {
      "titre": ticket.titre,
      "description": ticket.description,
      "label": {
        id: ticket.labelid,
        name: ticket.labelname
      },
      "user": {
        id: ticket.user.id
      }
    }, httpOptions);
  }*/
    createTicket(ticket: Ticket): Observable<any> {
    return this.http.post(`${this.baseUrl7}`, {
      "titre": ticket.titre,
      "description": ticket.description,
      "label": {
        id: ticket.labelid,
        name: ticket.labelname
      },
      "user": {
        id: ticket.user.id
      }
    }, httpOptions);
  }
  startprocess(ticket: Ticket): Observable<any> {
    return this.http.post(`${this.baseUrl8}`,ticket, httpOptions);
  }

findByLabel(label:labelc): Observable<any> {
  return this.http.post(`${this.baseUrl3}/Alltickets3`,  { "id": label.id, "name": label.name }, httpOptions);
}


  updateTicket(ticket: Ticket): Observable<any> {
    return this.http.put(`${this.baseUrl}/${ticket.id_ticket}`, ticket);
  }
  deleteTicket(ticket: Ticket) {
    return this.http.delete<Ticket>(`${this.baseUrl3}/ticket/${ticket.id_ticket}`);
  }
  deleteALLTickets() {
    return this.http.delete<Ticket>(`${this.baseUrl3}/delete`);
  }

  getticketsbyTitre(titre: string): Observable<any> {
    return this.http.get(`${this.baseUrl3}/Allticketstitre/${titre}`);
  }

  getTicketsList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

}
