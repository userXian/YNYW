import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class DetailsService {
  constructor(private httpClient: HttpClient) {}

    public search(data: any) {

       return this.httpClient.post('http://localhost:8080/details',data);
    }
    public ent(userId:string,bookId:string){
     const data = {
        userId:userId,
        bookId:bookId
      }
      return this.httpClient.post<boolean>('http://localhost:8080/ent',data);
    }
  }

