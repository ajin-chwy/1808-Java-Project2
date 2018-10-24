import { Recipe } from './recipe';

export class User {
    userId: number;
    username: string;
    password: string;
    role: string;
    fName: string;
    lName: string;
    address: string;
    deleted: boolean;
    ownedRecipes: Recipe[];
    savedRecipes: Recipe[];

    constructor(username: string, password: string, role: string
        , fName: string, lName: string, address: string,
        deleted: boolean, savedRecipes: Recipe[]) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.deleted = deleted;
        this.savedRecipes = savedRecipes;
    }
}
