import { Component, OnInit } from '@angular/core';
import { User } from '../types/user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User;
  username: string;
  password: string;
  role: string;
  fName: string;
  lName: string;
  address: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.checkSess();
  }

  checkSess(): void {
    this.userService.getSessionStatus().subscribe( result => {
      this.afterSess(result);
    });
  }

  afterSess(user: User): void {
    if (user == null) {
      console.log('Session is empty');
    } else {
      this.router.navigate(['/home']);
    }
  }

  updateUser(user: User): void {
    this.userService.setSessionStatus(user).subscribe(result => {
      if (result != null) {
        this.router.navigate(['/home']);
      } else {
        this.router.navigate(['/register']);
      }
    });
  }

  register(): void {
    const tempUser = new User(this.username, this.password, this.role, this.fName, this.lName, this.address, false, null);
    this.userService.registerUser(tempUser).subscribe(use => {
      this.updateUser(use);
    });
  }
}
