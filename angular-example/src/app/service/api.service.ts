import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  host = 'http://localhost:9000/api';

  constructor(private http: HttpClient) {
  }

  getUserFromRemote(): Observable<User[]> {
    const requestPath = '/user/users';
    return this.http.get<User[]>(this.host + requestPath);
  }

  createUserInRemote(): Observable<User> {
    const requestPath = '/registration/user';
    return this.http.post<User>(this.host + requestPath, new User('abc', 'efgsh'));
  }

}
