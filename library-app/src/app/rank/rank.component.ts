import { Router } from '@angular/router';
import { BooksService } from '../service/books.service';
import { Component, TemplateRef, OnInit } from '@angular/core';
import { Book } from '../interfaces/book.interface';
import { BsModalService, BsModalRef} from 'ngx-bootstrap/modal';
import { LogService } from '../service/log.service';
import { log } from '../interfaces/log.interface';
import { RankService } from '../service/rank.service';

const navigateMap = {
  1: 'details',
  2: 'revert',
  3: 'books',
  4: 'log',
  5: 'rank'
};

@Component({
  selector: 'book-rank',
  templateUrl: './rank.component.html',
  styleUrls: ['./rank.component.scss']
})
export class RankComponent implements OnInit {
  type = '5';
  bookNum = 0;
  readerNum = 0;
  books = null;
  readers = null;
  PAGE_SIZE = 10;
  bookPageIndex = 0;
  readerPageIndex = 0;
  bookPageNum = 0;
  readerPageNum = 0;
  constructor(private rankService: RankService, private router: Router, private modalService: BsModalService){}

  public tagClick(type) {
    this.type = type;
    const url = navigateMap [type];
    if (url){
      this.router.navigate([url]);
    }
  }

  ngOnInit() {
    // this.books = [{bookName:"孤独时间", cnt:11, authorName:"张三"},{bookName:"孤独时间", cnt:11, authorName:"张三"},{bookName:"孤独时间", cnt:11, authorName:"张三"},{bookName:"孤独时间", cnt:11, authorName:"张三"}]
    console.log("start....")
    this.rankService.getNum().subscribe(
    (res:any)=>{
    this.bookNum = res['bookNum']
    this.readerNum = res['readerNum']
    this.bookPageNum = this.bookNum / this.PAGE_SIZE;
    this.readerPageNum = this.readerNum / this.PAGE_SIZE;
    console.log(res)
    console.log(this.bookNum);
    console.log(this.readerNum);
    
    // {bookName:"XX", cnt: 10, authorName:zz
    // {readerName:"XX", cnt: 100}
    this.rankService.getBooks({pageIndex: this.bookPageIndex, pageSize: this.PAGE_SIZE}).subscribe(
      (books:any)=>{
      this.books = books;
     this.rankService.getReaders({pageIndex: this.readerPageIndex, pageSize: this.PAGE_SIZE}).subscribe(
       (re:any)=>{
       this.readers= re;
    console.log(this.books);
    console.log(this.readers);
      })
      })
    }
    );
  }


}
