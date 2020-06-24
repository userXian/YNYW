import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../interfaces/user.interface';
import { Observable, forkJoin, Subject } from 'rxjs';

@Injectable()
// 使用可被注入标签，必须加入到一个provider里-》放入到app.module里
export class UserService {
  userId:string;
  constructor(private httpClient: HttpClient) {}
  public find() {
    return this.httpClient.post('http://localhost:8080/user',this.userId);
  }
public update(user :User) {
      return this.httpClient.post('http://localhost:8080/userupdate',user);
    }
}
