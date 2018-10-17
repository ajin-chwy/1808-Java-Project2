import { User } from './user';

export class Recipe {
    recipeId: number;
    owner: User;
    name: string;
    steps: string;
    ingredients: string;
    deleted: boolean;
    score: number;

    constructor(owner: User, name: string, steps: string, ingredients: string, deleted: boolean, score: number) {
        this.owner = owner;
        this.name = name;
        this.steps = steps;
        this.ingredients = ingredients;
        this.deleted = deleted;
        this.score = score;
    }
}
