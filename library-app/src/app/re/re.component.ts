import { Router } from '@angular/router';
import { BooksService } from '../service/books.service';
import { Component, TemplateRef } from '@angular/core';
import { BsModalService, BsModalRef} from 'ngx-bootstrap/modal';


@Component({
  selector: 'book-re',
  templateUrl: './re.component.html',
  styleUrls: ['./re.component.scss']
})
export class ReComponent {
  userName;
  password;
  email;
  birthday;
  sex;
  grade;
  interest;
  interest1;
  interest2;
  interest3;
  comment;
  

  constructor(private booksService: BooksService, private router: Router, private modalService: BsModalService){}

  public save() {

  }

}
