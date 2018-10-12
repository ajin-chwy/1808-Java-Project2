import { Component, OnInit } from '@angular/core';
import { User } from '../types/user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService) { }

  users: User[];
  ngOnInit() {
    this.userService.getUsers().subscribe(users => console.log(users));
      //this.users = users);
  }

}
