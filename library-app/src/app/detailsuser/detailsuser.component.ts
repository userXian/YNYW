import { Router } from '@angular/router';
import { DetailsService } from './../service/details.service';
import { Component } from '@angular/core';
import { Book } from '../interfaces/book.interface';

const navigateMap = {
  1: 'detailsuser',
  2: 'user'
};

@Component({
  selector: 'book-detailsuser',
  templateUrl: './detailsuser.component.html',
  styleUrls: ['./detailsuser.component.scss']
})
export class DetailsuserComponent {
  userId = '';
  bookId = ''; // 图书ID
  authorName = ''; // 作者名
  bookName = ''; // 书名
  educationName = ''; // 出版社
  books: Book[];
  type = '1';

  constructor(private detailsService: DetailsService, private router: Router){}

  public tagClick(type) {
    this.type = type;
    const url = navigateMap [type];
    if (url){
      this.router.navigate([url]);
    }
  }

  public search(){ 
    const params = {
      userId: this.userId,
      bookId: this.bookId, // 图书ID
      authorName: this.authorName, // 作者名
      bookName: this.bookName, // 书名
      educationName: this.educationName // 出版社
    };
    this.detailsService.search(params).subscribe((books: Book[]) => {
      this.books = books;
    });
  }

  public reset(){
    this.userId = '';
    this.bookId = ''; // 图书ID
    this.authorName = ''; // 作者名
    this.bookName = ''; // 书名
    this.educationName = ''; // 出版社
  }
}
