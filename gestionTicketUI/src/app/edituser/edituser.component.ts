import { Component, OnInit } from '@angular/core';
import { user } from '../_services/user';
import { Router } from '@angular/router';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent implements OnInit {
  form: any = {};
  user :user 
id:number
  constructor(private router:Router,private service:UserService) { }

  ngOnInit() {
    this.Editar();
    
   this.user = new user(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password);
      let id=localStorage.getItem("id");
    this.service.getUserId(+id)
    .subscribe(data=>{
      console.log(id+"id")
      console.log(data)
      this.user=data
      console.log( this.user)
    })
     

  }

  Editar(){


  
    

  }
  Actualiser(user:user){
user=this.user

    this.service.updateUser( user,this.id)
    .subscribe(data=>{
      this.user=data;
      alert("Modifier avec success");
      this.router.navigate(["userlist"]);
    })
  }

}
