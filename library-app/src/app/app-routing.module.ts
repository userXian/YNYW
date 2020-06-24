import { LoginComponent } from './login/login.component';
import { DetailsComponent } from './details/details.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BooksComponent } from './books/books.component';
import { AuthGuard } from './auth/auth.guard'
import { DetailsuserComponent } from './detailsuser/detailsuser.component';
import { UserComponent } from './user/user.component';
import { LogComponent } from './log/log.component';

const routes: Routes = [
   
  {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'details', component: DetailsComponent,canActivate:[AuthGuard]},
  {path: 'books', component: BooksComponent,canActivate:[AuthGuard]},
  {path: 'detailsuser', component: DetailsuserComponent,canActivate:[AuthGuard]},
  {path: 'user', component: UserComponent,canActivate:[AuthGuard]},
  {path: 'log', component: LogComponent,canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
