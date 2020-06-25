import { Router } from '@angular/router';
import { BooksService } from '../service/books.service';
import { Component, TemplateRef } from '@angular/core';
import { Book } from '../interfaces/book.interface';
import { BsModalService, BsModalRef} from 'ngx-bootstrap/modal';

const navigateMap = {
  1: 'details',
  2: 'revert',
  3: 'books',
  4: 'log',
  5: 'rank'
};

@Component({
  selector: 'book-list',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent {
  userId = '';
  bookId = ''; // 图书ID
  authorName = ''; // 作者名
  bookName = ''; // 书名
  educationName = ''; // 出版社
  books: Book[];
  type = '3';
  selectedBook: Book;
  modalRef: BsModalRef;
  targetBook: Book;

  constructor(private booksService: BooksService, private router: Router, private modalService: BsModalService){}

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
    this.booksService.search(params).subscribe((books: Book[]) => {
      this.books = books;
    });
  }

  public insert(template: TemplateRef<any>) {
    this.selectedBook = {
      bookId: '',
      authorName: '',
      bookName: '',
      educationName: '',
      quantity: 0
    };
    this.targetBook = {
      bookId: '',
      authorName: '',
      bookName: '',
      educationName: '',
      quantity: 0
    };
    this.modalRef = this.modalService.show(template);
  }

  public edit(template: TemplateRef<any>, book: Book) {
    this.targetBook = book;
    this.selectedBook = {
      bookId: book.bookId,
      authorName: book.authorName,
      bookName: book.bookName,
      educationName: book.educationName,
      quantity: book.quantity
    };
    this.modalRef = this.modalService.show(template);
  }

  public save() {
    this.modalRef.hide();
    if (this.targetBook.bookId !== '') {
      this.booksService.seveupdate(this.selectedBook).subscribe(
        (result:Boolean)=>{
          if(result){
            alert('修改成功');
            this.targetBook.bookId = this.selectedBook.bookId;
            this.targetBook.authorName = this.selectedBook.authorName;
            this.targetBook.bookName = this.selectedBook.bookName;
            this.targetBook.educationName = this.selectedBook.educationName;
            this.targetBook.quantity = this.selectedBook.quantity;
          }else{
            alert('添加失败');
          }
        }
      );
    } else {
      this.booksService.saveadd(this.selectedBook).subscribe(
        (result:Boolean)=>{
          if(result){
            alert('添加成功');
            this.books.push(this.selectedBook);
          }else{
            alert('添加失败');
          }
        }
      );
    }
  }
}
