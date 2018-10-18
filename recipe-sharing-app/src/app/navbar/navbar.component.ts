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
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getSessionStatus().subscribe(result => {
      if (result != null ) {
        this.currentUser = result;
      } else {
        this.currentUser = null;
      }
    });
  }

  logout(): void {
    this.userService.logout().subscribe(result => this.currentUser = null);
  }
}
