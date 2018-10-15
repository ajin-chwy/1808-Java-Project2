import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './types/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private userUrl = 'http://Localhost:8081/RecipeSharingApplication/login';

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userUrl);
  }

  verifyUser(user: User): Observable<User> {
      return this.http.post<User>(this.userUrl, user, {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }
}
