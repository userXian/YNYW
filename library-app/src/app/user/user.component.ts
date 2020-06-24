import { Router } from '@angular/router';
import { DetailsService } from './../service/details.service';
import { Component, TemplateRef } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../interfaces/user.interface';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

const navigateMap = {
  1: 'detailsuser',
  2: 'user'
};

@Component({
  selector: 'book-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent {
  type = '2';
  user:User;
  userId:string;
  modalRef: BsModalRef;
  targetuser:User;
  selectuser:User;
  constructor(private router: Router,private userService:UserService,private modalService: BsModalService){
    this.userId=this.userService.userId;
    console.log(this.userId);
    this.userService.find().subscribe(
      (user:User)=>{
        this.user=user;
      }
    );
  }

 public tagClick(type){
  this.type=type;
  let url=navigateMap[type];
  this.router.navigate([url]);
 }
 
 public edit(template: TemplateRef<any>, user: User){
  this.targetuser = user;
  this.selectuser = {
  userName:user.userName,
	password:user.password,
	email:user.email,
	birthday:user.birthday,
	sex:user.sex,
	grade:user.grade,
  interest:user.interest,
  comment:user.comment,
  authority:user.authority,
  description:user.description,
  userId:user.userId
  };
    this.modalRef = this.modalService.show(template);
 }

 public save() {
  this.modalRef.hide();
  if (this.targetuser.userId !== '') {
    this.userService.update(this.selectuser).subscribe(
      (result:Boolean)=>{
        if(result){
          alert('修改成功');
          this.targetuser.userName = this.selectuser.userName;
          this.targetuser.password = this.selectuser.password;
          this.targetuser.comment = this.selectuser.comment;
          this.targetuser.email = this.selectuser.email;
          this.targetuser.birthday = this.selectuser.birthday;
        }else{
          alert('添加失败');
        }
      }
    );
  }
}

}
