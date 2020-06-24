import { Router } from '@angular/router';
import { BooksService } from '../service/books.service';
import { Component, TemplateRef } from '@angular/core';
import { Book } from '../interfaces/book.interface';
import { BsModalService, BsModalRef} from 'ngx-bootstrap/modal';
import { LogService } from '../service/log.service';
import { log } from '../interfaces/log.interface';

const navigateMap = {
  1: 'details',
  3: 'books',
  4: 'log'
};

@Component({
  selector: 'book-log',
  templateUrl: './log.component.html',
  styleUrls: ['./log.component.scss']
})
export class LogComponent {
  userId:string;
  userName:string;
  authority:string;
  registerDatetime:string
  logs:log[];
  type = '4';

  constructor(private logService: LogService, private router: Router, private modalService: BsModalService){}

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
      userName: this.userName,
      authority: this.authority,
      registerDatetime: this.registerDatetime
    };
    this.logService.search(params).subscribe((logs: log[]) => {
      this.logs = logs;
    });
  }

}
