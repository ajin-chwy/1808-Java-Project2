import { User } from './user';

export class Recipe {
    recipeId: number;
    owner: User;
    name: string;
    steps: string;
    deleted: boolean;

    constructor(owner: User, name: string, steps: string, deleted: boolean) {
        this.owner = owner;
        this.name = name;
        this.steps = steps;
        this.deleted = deleted;
    }
}
