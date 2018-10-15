export class User {
    userId: number;
    username: string;
    password: string;
    role: string;
    fName: string;
    lName: string;
    address: string;
    deleted: boolean;

    constructor(username: string, password: string) {
        this.username = username;
        this.password = password;
    }
}
