import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ticket } from './_services/Ticket';
import { labelc } from './_services/labelc';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})

export class SupportService {

  private baseUrl = 'http://localhost:8080/api';
  private baseUrl2 = 'http://localhost:8080/label';
  private baseUrl3 = 'http://localhost:8080/api/user/userRoles'


  constructor(private http: HttpClient) { }


  getticketbystatut(statut: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/Alltickets/${statut}`);
  }
  getticketbyassigner(assigner: string, statut: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/Alltickets4/${assigner}/${statut}`);
  }
  getticketbylabel(label: labelc, statut: String): Observable<any> {

    return this.http.post(`${this.baseUrl}/Alltickets5/${statut}`, { "id": label.id, "name": label.name }, httpOptions);
  }
  getuserbyrole(): Observable<any> {

    return this.http.post(`${this.baseUrl3}`, {
      "id": 2,
      "name": "ROLE_SUPPORT"
    }, httpOptions);
  }
  getlabel(name: string): Observable<any> {
    return this.http.get(`${this.baseUrl2}/getlabelbyname/${name}`);
  }
  getlabelnames(): Observable<any> {
    return this.http.get(`${this.baseUrl2}/getlabels`);
  }

  addactions(ticket: Ticket): Observable<any> {
    return this.http.put(`${this.baseUrl}/ticketsaction/${ticket.id_ticket}`, ticket);
  }
  setStatutTicket(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/StatutEncour/${id}`);
  }
  setStatutTicketenfintraitement(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/StatutEnfintraitement/${id}`);
  }



  setAssigner(id: number, assigner: string): Observable<any> {

    return this.http.get(`${this.baseUrl}/Setassigner/${id}/${assigner}`);
  }



  ReponseUtilisateur(id: number, satisfait: boolean): Observable<any> {
    return this.http.get(`${this.baseUrl}/reponseNotif/${id}/${satisfait}`);
  }

  setStatutTicketFerme(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/fermerTicket/${id}`);
  }


  ReouvrirTicket(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/reouvrirTicket/${id}`);
  }

}












