import { Component, OnInit } from '@angular/core';
import { User } from '../types/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }
  username: '';
  password: '';
  user: User;
  users: User[];
  ngOnInit() {
    this.userService.getUsers().subscribe(users => this.users = users);
  }

  login(): void {
    const tempUser = new User(this.username, this.password);
    this.userService.verifyUser(tempUser).subscribe(use => {
      this.updateUser(use);
    });
  }

  updateUser(user: User): void {
    this.user = user;
    console.log(this.user);
    if (this.user == null) {
      this.router.navigate(['/login']);
    } else {
      this.router.navigate(['/register']);
    }
  }

}
