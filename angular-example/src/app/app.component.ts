import {Component, OnInit} from '@angular/core';
import {ApiService} from './service/api.service';
import {User} from './model/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'angular-example';


  constructor(private apiService: ApiService) {
  }

  users: User[];
  user: User;

  ngOnInit(): void {
    this.apiService.getUserFromRemote().subscribe(data => {
        console.log(data);
        this.users = data;
      },
      error => console.log(error));
  }

  postRequest() {
    this.apiService.createUserInRemote().subscribe(data => {
        console.log(data);
        this.user = data;
      },
      error => console.log(error));
  }

  reload() {
    this.ngOnInit();
  }
}
