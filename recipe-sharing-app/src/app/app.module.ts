import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { PersonalCookbookComponent } from './personal-cookbook/personal-cookbook.component';
import { HomeComponent } from './home/home.component';
import { CreateRecipeComponent } from './create-recipe/create-recipe.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MyRecipesComponent } from './my-recipes/my-recipes.component';
import { OnlyVisibleRecipesPipe } from './only-visible-recipes.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    PersonalCookbookComponent,
    HomeComponent,
    CreateRecipeComponent,
    NavbarComponent,
    MyRecipesComponent,
    OnlyVisibleRecipesPipe

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
