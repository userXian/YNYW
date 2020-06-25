import { Router } from '@angular/router';
import { BooksService } from '../service/books.service';
import { Component, TemplateRef } from '@angular/core';
import { Book } from '../interfaces/book.interface';
import { BsModalService, BsModalRef} from 'ngx-bootstrap/modal';
import { RevertService } from '../service/revert.service';

const navigateMap = {
  1: 'details',
  2: 'revert',
  3: 'books',
  4: 'log',
  5: 'rank'
};

@Component({
  selector: 'book-revert',
  templateUrl: './revert.component.html',
  styleUrls: ['./revert.component.scss']
})
export class RevertComponent {
  userId = '';
  bookId = ''; // 图书ID
  type = '3';
  constructor(private revertService: RevertService, private router: Router, private modalService: BsModalService){}

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
    };
    this.revertService.search(params).subscribe((result:number) => {
     if(result===1){
       alert(this.userId+'归还'+this.bookId+'成功');
     }else if(result===2){
      alert(this.userId+'没有借'+this.bookId);
     }else{
      alert(this.userId+'归还'+this.bookId+"失败");
     }
    });
  }
}
