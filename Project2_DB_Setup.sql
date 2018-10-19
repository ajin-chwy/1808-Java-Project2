create table if not exists users (
    userId serial,
    username text,
    password text,
    role text,
    fName text,
    lName text,
    address text,
    deleted boolean,
    primary key (userId)
);

create table if not exists recipes (
    recipeId serial,
    owner int,
    name text,
    steps text,
    ingredients text,
    score decimal(3, 2),
    deleted boolean,
    primary key (recipeId),
    foreign key (owner) references users(userId)
);

create table if not exists savedRecipes (
    userId int,
    recipeId int,
    primary key (userId, recipeId),
    foreign key (userId) references users(userId),
    foreign key (recipeId) references recipes(recipeId)
);

create table if not exists reviews (
    reviewId int,
    recipesId int,
    score int,
    message text,
    primary key (reviewId),
    foreign key (recipesId) references recipes(recipeId) on delete cascade
);

create table if not exists ingredients (
    ingredientId int,
    name text,
    primary key (ingredientId)
);

create table if not exists RIJunction (
    recipe int,
    ingredient int,
    primary key (recipe, ingredient),
    foreign key (recipe) references recipes(recipeId) on delete cascade,
    foreign key (ingredient) references ingredients (ingredientId) on delete cascade
);

create table if not exists suggestions (
    suggestId int,
    recipeId int,
    message text,
    primary key (suggestId),
    foreign key (recipeId) references recipes(recipeId) on delete cascade
);

create sequence USERID_SEQ start 1;
create sequence RECIPEID_SEQ start 1;
create sequence REVIEWSID_SEQ start 1;
create sequence INGREDIENTID_SEQ start 1;
create sequence SUGGESTIONID_SEQ start 1;
--drop table suggestions, users, recipes, reviews, ingredients, rijunction, savedrecipes;
--drop sequence USERID_SEQ, RECIPEID_SEQ, REVIEWSID_SEQ, INGREDIENTID_SEQ, SUGGESTIONID_SEQ;

--drop table suggestions, reviews , rijunction, savedRecipes,recipes;