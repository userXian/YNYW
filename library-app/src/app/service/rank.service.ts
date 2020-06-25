import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../interfaces/book.interface';

@Injectable()
export class RankService {
  constructor(private httpClient: HttpClient) {}

    public getNum() {
      return this.httpClient.post('http://localhost:8080/getnum', {});
    }

    public getBooks(data) {
      return this.httpClient.post("http://localhost:8080/getbooks", data)
    }
    public getReaders(data) {
      return this.httpClient.post("http://localhost:8080/getreaders", data)
    }
  }

