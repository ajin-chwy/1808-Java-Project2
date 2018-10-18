import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './types/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private userUrl = 'http://10.41.27.189:8081/RecipeSharingApplication/';

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl + 'login');
  }

  verifyUser(user: User): Observable<User> {
    return this.http.post<User>(this.userUrl + 'login', user, {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  registerUser(user: User): Observable<User> {
    return this.http.post<User>(this.userUrl + 'register', user, {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  getSessionStatus(): Observable<User> {
    return this.http.get<User>(this.userUrl + 'status');
  }

  setSessionStatus(user: User): Observable<User> {
    return this.http.post<User>(this.userUrl + 'status', user, {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  logout(): Observable<User> {
    return this.http.put<User>(this.userUrl + 'status', null);
  }
}
