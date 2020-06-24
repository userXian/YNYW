// import { Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';

// @Injectable()
// // 使用可被注入标签，必须加入到一个provider里-》放入到app.module里
// export class LoginService {
//   constructor(private httpClient: HttpClient) {}

//   public login(userId: string, password: string,data :any) {
//     const body = {
//       userId: userId,
//       password: password
//     };
//     // return this.httpClient.post<boolean>('http://localhost:8080/login', body);
//     return this.httpClient.get('assets/testJson/login.json',{params:data});
//   }
// }
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../interfaces/user.interface';
import { Observable, forkJoin } from 'rxjs';

@Injectable()
// 使用可被注入标签，必须加入到一个provider里-》放入到app.module里
export class LoginService {

  constructor(private httpClient: HttpClient) {}

  public  login(userId: string, password: string,authority: string) {
    const body = {
      userId: userId,
      password: password,
      authority: authority
    };
    return this.httpClient.post<number>('http://localhost:8080/login', body);
  }
}
