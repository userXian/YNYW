import { Component, TemplateRef } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';


const navigateMap = {
  1: 'details',
  3: 'books'
};

@Component({
  selector: 'header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  constructor(private router: Router,private authService :AuthService){}
  result=true;
  public uswitch(){
     this.router.navigate(['login']);
  } 
}
