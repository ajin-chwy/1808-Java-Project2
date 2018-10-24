import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../types/user';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentUser: User;
  role: string;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getSessionStatus().subscribe(result => {
      if (result != null ) {
        this.currentUser = result;
        this.role = result.role;
        console.log(result);
        console.log(result.role);
      } else {
        this.currentUser = null;
      }
    });
  }

  logout(): void {
    this.userService.logout().subscribe(result => this.currentUser = null);
    window.location.reload();
  }
}
