export class User {
    userId: number;
    username: string;
    password: string;
    role: string;
    fName: string;
    lName: string;
    address: string;
    deleted: boolean;

    constructor(username: string, password: string, role: string, fName: string, lName: string, address: string, deleted: boolean) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.deleted = deleted;
    }
}
