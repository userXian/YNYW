import { Injectable } from '@angular/core';

@Injectable()
export class AuthService{

    isLoggedIn=false;
    redirectUrl: string;

    longin(longin): void{
        this.isLoggedIn=longin;
    }
}