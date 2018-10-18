import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Recipe } from './types/recipe';
import { User } from './types/user';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

  private url = 'http://localhost:8081/RecipeSharingApplication/';

  constructor(private http: HttpClient) { }

  getRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.url + 'recipe');
  }

  createRecipe(recipe: Recipe): Observable<Recipe> {
    return this.http.post<Recipe>(this.url + 'recipe', recipe, {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  getOwnedRecipes(user: User): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(this.url + 'status/' + user.userId);
  }

  addSavedRecipe(recipe: Recipe, user: User): Observable<User> {
    return this.http.post<User>(this.url + 'recipe/' + user.userId, recipe,
    {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

  removeSavedRecipe(recipe: Recipe, user: User): Observable<User> {
    return this.http.put<User>(this.url + 'recipe/' + user.userId, recipe,
    {headers: new HttpHeaders({'Content-Type': 'application/json'})});
  }

}
