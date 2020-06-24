import { LoginService } from './service/login.service';
import { LoginComponent } from './login/login.component';
import { DetailsComponent } from './details/details.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ModalModule } from 'ngx-bootstrap/modal';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DetailsService } from './service/details.service';
import { BooksComponent } from './books/books.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BooksService } from './service/books.service';
import { AuthService } from './service/auth.service';
import { AuthGuard } from './auth/auth.guard';
import { AlertModule } from 'ngx-bootstrap/alert'
import { HeaderComponent } from './header/header.component';
import { DetailsuserComponent } from './detailsuser/detailsuser.component';
import { UserComponent } from './user/user.component';
import { UserService } from './service/user.service';
import { LogComponent } from './log/log.component';
import { LogService } from './service/log.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DetailsComponent,
    BooksComponent,
    HeaderComponent,
    DetailsuserComponent,
    UserComponent,
    LogComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ModalModule.forRoot(),
    AlertModule.forRoot()
  ],
  providers: [LoginService, DetailsService, BooksService,AuthService,AuthGuard,UserService,LogService],
  bootstrap: [AppComponent]
})
export class AppModule { }
