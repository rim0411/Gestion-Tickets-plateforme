import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VerifyEmailRequest } from './VerifyEmailRequest';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  login(credentials): Observable<any> {
    return this.http.post(AUTH_API + 'signin', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions);
  }

  register(user): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username: user.username,
      email: user.email,
      password: user.password,
      role: ["user"],
      label: {
        id: 3,
        name: "indefenie"

      }

    }, httpOptions);
  }
  registersupport(user, ids: number, label: string): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username: user.username,
      email: user.email,
      password: user.password,
      role: ["support"],
      label: {
        id: ids,
        name: label

      }

    }, httpOptions);
  }
  sendemail(email:VerifyEmailRequest): Observable<any> {
    return this.http.post(AUTH_API + 'send-email', {
      email: email.email,
      otpNo: email.otpNo,

      }
, httpOptions);
  }
  
}
