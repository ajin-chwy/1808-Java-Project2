import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { RecipeService } from '../recipe.service';
import { User } from '../types/user';
import { Recipe } from '../types/recipe';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  currentUser: User;
  recipes: Recipe[];
  constructor(private userService: UserService, private router: Router,
    private recipeService: RecipeService) { }

  ngOnInit() {
    this.recipeService.getRecipes().subscribe(result => {
      this.recipes = result;
    });
    this.checkSess();
  }

  checkSess(): void {
    this.userService.getSessionStatus().subscribe(result => {
      if (result != null) {
        this.currentUser = result;
        console.log(this.currentUser);
      } else {
        this.router.navigate(['/login']);
      }
    });
  }

  logout(): void {
    this.userService.logout().subscribe(result => this.router.navigate(['/login']));
  }

  save(recipe: Recipe): void {
    console.log(recipe);
  }
}
