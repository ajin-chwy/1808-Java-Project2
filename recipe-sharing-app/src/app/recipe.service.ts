import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Recipe } from './types/recipe';
import { User } from './types/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private url = 'http://10.41.27.189:8081/RecipeSharingApplication/';

  constructor(private http: HttpClient) { }

  getRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.url + 'recipe');
  }

  createRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.url + 'recipe', recipe, {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  //addSavedRecipe(recipe: Recipe, user: User)
}
