import { Router } from '@angular/router';
import { BooksService } from '../service/books.service';
import { Component, TemplateRef, OnInit } from '@angular/core';
import { Book } from '../interfaces/book.interface';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { LogService } from '../service/log.service';
import { log } from '../interfaces/log.interface';
import { RankService } from '../service/rank.service';

const navigateMap = {
  1: 'details',
  2: 'revert',
  3: 'books',
  4: 'log',
  5: 'rank',
};

@Component({
  selector: 'book-rank',
  templateUrl: './rank.component.html',
  styleUrls: ['./rank.component.scss'],
})
export class RankComponent implements OnInit {
  type = '5';
  bookNum = 0;
  readerNum = 0;
  books = null;
  readers = null;
  PAGE_SIZE = 2;
  bookPageIndex = 0;
  readerPageIndex = 0;
  bookPageNum = [];
  readerPageNum = [];
  constructor(
    private rankService: RankService,
    private router: Router,
    private modalService: BsModalService
  ) {}

  public tagClick(type) {
    this.type = type;
    const url = navigateMap[type];
    if (url) {
      this.router.navigate([url]);
    }
  }
  
  public bookPrevious() {
    if(this.bookPageIndex + 1 <= 1) return;
    this.selectBookPage(this.bookPageIndex);
  }

  public bookNext() {
    if(this.bookPageIndex + 1 >= this.bookPageNum.length) return;
    this.selectBookPage(this.bookPageIndex + 2);
  }
  
  public readerPrevious() {
    if(this.readerPageIndex + 1 <= 1) return;
    this.selectReaderPage(this.readerPageIndex);
  }

  public readerNext() {
    if(this.readerPageIndex + 1 >= this.readerPageNum.length) return;
    this.selectReaderPage(this.readerPageIndex + 2);
  }

  public selectBookPage(page) {
    if(page <= 0 || page > this.bookPageNum.length) return;
    this.bookPageIndex = page-1;
    this.rankService
        .getBooks({ pageIndex: this.bookPageIndex, pageSize: this.PAGE_SIZE })
        .subscribe((books: any) => {
          this.books = books;
        });
  }

  public selectReaderPage(page) {
    if(page <= 0 || page > this.readerPageNum.length) return;
    this.readerPageIndex = page - 1;
    this.rankService
            .getReaders({
              pageIndex: this.readerPageIndex,
              pageSize: this.PAGE_SIZE,
            })
            .subscribe((re: any) => {
              this.readers = re;
            });
  }

  public isActiveBookPage(page) {
    console.log(page);
    
    if(this.bookPageIndex == page - 1) return 1;
    return 0;
  }

  public isActiveReaderPage(page) {
    if(this.readerPageIndex == page - 1) return 1;
    return 0;
  }

  ngOnInit() {
    // this.books = [{bookName:"孤独时间", cnt:11, authorName:"张三"},{bookName:"孤独时间", cnt:11, authorName:"张三"},{bookName:"孤独时间", cnt:11, authorName:"张三"},{bookName:"孤独时间", cnt:11, authorName:"张三"}]
    console.log('start....');
    this.rankService.getNum().subscribe((res: any) => {
      this.bookNum = res['bookNum'];
      this.readerNum = res['readerNum'];
      const bookNum = this.bookNum / this.PAGE_SIZE;
      const readerNum = this.readerNum / this.PAGE_SIZE;
      for(let i = 0;i < bookNum;i++) {
        this.bookPageNum.push(i+1);
      }
      for(let i = 0;i < readerNum;i++) {
        this.readerPageNum.push(i+1);
      }
      console.log(res);
      console.log(this.bookPageNum);
      console.log(this.readerPageNum);

      // {bookName:"XX", cnt: 10, authorName:zz
      // {readerName:"XX", cnt: 100}
      this.rankService
        .getBooks({ pageIndex: this.bookPageIndex, pageSize: this.PAGE_SIZE })
        .subscribe((books: any) => {
          this.books = books;
          this.rankService
            .getReaders({
              pageIndex: this.readerPageIndex,
              pageSize: this.PAGE_SIZE,
            })
            .subscribe((re: any) => {
              this.readers = re;
              console.log(this.books);
              console.log(this.readers);
            });
        });
    });
  }
}
