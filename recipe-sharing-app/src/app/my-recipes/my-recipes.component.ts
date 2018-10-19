import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { User } from '../types/user';
import { Recipe } from '../types/recipe';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { RecipeService } from '../recipe.service';

@Component({
  selector: 'app-my-recipes',
  templateUrl: './my-recipes.component.html',
  styleUrls: ['./my-recipes.component.css']
})
export class MyRecipesComponent implements OnInit {

  ownedRecipes: Recipe[];
  currentUser: User;

  constructor(private router: Router,
    private userService: UserService,
    private recipeService: RecipeService) { }

  ngOnInit() {
    this.userService.getSessionStatus().subscribe(result => {
      if (result != null) {
        this.generateOwnedRecipes(result);
      } else {
        this.router.navigate(['/login']);
      }
    });
  }

  generateOwnedRecipes(user: User): void {
    this.currentUser = user;
    console.log(this.currentUser);
    this.recipeService.getOwnedRecipes(this.currentUser).subscribe(result => {
      this.ownedRecipes = result;
    });
  }

  hide(recipe: Recipe): void {
    this.recipeService.hideRecipe(recipe).subscribe( result => {
      this.router.navigateByUrl('/home', { skipLocationChange: true})
    .then(() => this.router.navigate(['/my-recipes']));
    });
  }
}
