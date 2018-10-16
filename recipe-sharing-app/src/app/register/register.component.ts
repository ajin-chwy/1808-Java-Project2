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
  }

  updateUser(user: User): void {
    this.user = user;
    console.log(this.user);
    if (this.user == null) {
      this.router.navigate(['/register']);
    } else {
      this.router.navigate(['/login']);
    }
  }

  register(): void {
    const tempUser = new User(this.username, this.password, this.role, this.fName, this.lName, this.address, false);
    this.userService.registerUser(tempUser).subscribe(use => {
      this.updateUser(use);
    });
  }
}
