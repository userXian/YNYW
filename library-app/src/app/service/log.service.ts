import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../interfaces/book.interface';

@Injectable()
export class LogService {
  constructor(private httpClient: HttpClient) {}

    public search() {
      
      return this.httpClient.post('http://localhost:8080/logs',{});
    }
  }

