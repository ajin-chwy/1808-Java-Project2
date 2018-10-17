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
  sess: User = null;
  users: User[];
  ngOnInit() {
    this.userService.getUsers().subscribe(users => this.users = users);
    // this.checkSess();
  }

  login(): void {
    const tempUser = new User(this.username, this.password, null, null, null, null, false);
    this.userService.verifyUser(tempUser).subscribe(use => {
      this.router.navigate(['/home']);
    });
  }

  updateUser(use: User): void {
    this.user = use;
  }

  checkSess(): void {
    this.userService.getSessionStatus().subscribe(result => this.router.navigate(['/home']));
  }

  afterSess(user: User): void {
    if (user == null) {
      console.log('Session is empty');
    } else {
      this.sess = user;
    }
  }

}
