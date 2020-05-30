import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Camunda } from './camunda';


import { user } from './user';
import { catchError, map, tap } from 'rxjs/operators';
import { JsonPipe } from '@angular/common';
import { Ticket } from './Ticket';
import { labelc } from './labelc';



const API_URL = 'http://localhost:8080/api/user';
const API_URLT = 'http://localhost:8080/api/ticket';
const API_URL2 = 'http://localhost:8080/api/user/userTickets';



const httpOptions: any = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Headers': 'Content-Type',
    'Access-Control-Allow-Methods': 'POST',

  })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseUrl = 'http://localhost:8080/api/user';


  constructor(private http: HttpClient) { }
  private log(log: string) {
    console.info(log);
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };

  }


  getidByTitle(titre: string): Observable<any> {
    return this.http.get(`${API_URLT}/${titre}`, { responseType: 'text' });
  }

  getticketbyuserid(id: any): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({ 'content-Type': 'application/json' })
    };
    return this.http.get(`${API_URL2}/${id}`, httpOptions);


  }

  getUserId(id: number) {
    return this.http.get<user>(API_URL + "/users/" + id);
  }
  updateUser(user: user,id :number) {
    return this.http.put<user>(API_URL + "/" +id, user);
  }
  deleteUser(user: user) {
    return this.http.delete<user>(API_URL + "/" + user.id);
  }
  deleteAllUsers() {
    return this.http.delete<user>(API_URL + "/all");
  }


  getUsers(): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({ 'content-Type': 'application/json' })
    };
    return this.http.get<any>(API_URL, httpOptions);
  }
  getuserByusername(username:string):Observable<any> {
    return this.http.get(`${this.baseUrl}/username/${username}`);

  }
  getuserByEmail(email:string):Observable<any> {
    return this.http.get(`${API_URL}/email/${email}`);

  }
  getuserById(id:any){
    const httpOptions = {
      headers: new HttpHeaders({ 'content-Type': 'application/json' })
    };
    return this.http.get<any>(`${API_URL}/users/{id}`, httpOptions);

  }
  getuserByLabel(label:labelc): Observable<any> {
    return this.http.post(`${API_URL}/userlabel`,  { "id": label.id, "name": label.name }, httpOptions);
  }







}



