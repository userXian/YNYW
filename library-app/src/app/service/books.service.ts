import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../interfaces/book.interface';

@Injectable()
export class BooksService {
  constructor(private httpClient: HttpClient) {}

    public search(data: any) {
      return this.httpClient.post('http://localhost:8080/books',data);
    }
    public saveadd(data : Book){
      return this.httpClient.post<Boolean>('http://localhost:8080/booksadd',data);
    }
    public seveupdate(data : Book){
      return this.httpClient.post<Boolean>('http://localhost:8080/booksupdate',data);
    }
  }

