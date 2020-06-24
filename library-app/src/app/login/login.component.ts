import { LoginService } from './../service/login.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service'
import { UserService } from '../service/user.service';

@Component({
  selector: 'account-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  public userId: string;
  public password: string;
  public authority: string;
  public result1;

  constructor(private router: Router, private loginService: LoginService,private authService :AuthService,private userService:UserService){}

  public login() {
     this.loginService.login(this.userId, this.password,this.authority).subscribe((result: number) => {
       if (result===1) {
                this.authService.isLoggedIn=true;
                this.router.navigate(['details']);
       }else if(result===2){
                  this.authService.isLoggedIn=true;
                  this.userService.userId=this.userId;
                  this.router.navigate(['detailsuser']);
       }else{
          alert("请核实信息登录");
           this.result1=true;
       }
     });
  }
}
