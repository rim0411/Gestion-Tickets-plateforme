import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'

})
export class AuthServiceSService {
  private baseUrl = "localhost:8080/api/auth";
  constructor(private http: HttpClient) { }

}