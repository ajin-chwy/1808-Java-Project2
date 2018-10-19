import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { CreateRecipeComponent } from './create-recipe/create-recipe.component';
import { PersonalCookbookComponent } from './personal-cookbook/personal-cookbook.component';
import { MyRecipesComponent } from './my-recipes/my-recipes.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent},
  {path: 'create-recipe', component: CreateRecipeComponent},
  {path: 'cookbook', component: PersonalCookbookComponent},
  {path: 'my-recipes', component: MyRecipesComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
