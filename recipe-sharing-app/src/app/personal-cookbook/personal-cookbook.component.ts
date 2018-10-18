import { Component, OnInit } from '@angular/core';
import { User } from '../types/user';
import { Recipe } from '../types/recipe';
import { UserService } from '../user.service';
import { RecipeService } from '../recipe.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-personal-cookbook',
  templateUrl: './personal-cookbook.component.html',
  styleUrls: ['./personal-cookbook.component.css']
})
export class PersonalCookbookComponent implements OnInit {

  user: User;
  savedRecipes: Recipe[];
  constructor(private userService: UserService,
    private recipeService: RecipeService,
    private router: Router) { }

  ngOnInit() {
    this.userService.getSessionStatus().subscribe(result => {
      if (result != null) {
        this.generateSavedRecipes(result);
      } else {
        this.router.navigate(['/login']);
      }
    });
  }

  generateSavedRecipes(user: User): void {
    this.user = user;
    console.log(this.user);
    this.savedRecipes = user.savedRecipes;
  }

  save(recipe: Recipe): void {
    console.log(recipe);
    this.recipeService.removeSavedRecipe(recipe, this.user).subscribe(result => {
      this.updateUser();
    });
  }

  updateUser(): void {
    this.userService.getSessionStatus().subscribe(result => {
      this.user = result;
    });
    this.router.navigateByUrl('/home', { skipLocationChange: true})
    .then(() => this.router.navigate(['/cookbook']));
  }

}
