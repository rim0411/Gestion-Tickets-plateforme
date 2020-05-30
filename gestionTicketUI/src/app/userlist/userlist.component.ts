import { Component, OnInit, Input, ɵɵcontainerRefreshEnd } from '@angular/core';
import { user } from '../_services/user';
import { UserService } from '../_services/user.service';
import { Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { Ticket } from '../_services/Ticket';
import { ToastrService } from 'ngx-toastr';
import { SupportService } from '../support.service';
import { labelc } from '../_services/labelc';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {
 users: user[]
 user:user
 selecteduser:user
  tickets: Ticket[]
 choix:any
 statut2:any
 users2:any
 email:string
 username:string
 id:number
  constructor( private router: Router,
    private userservice: UserService,private toaster:ToastrService, private supportservice:SupportService){ }


   ngOnInit() {
      this.userservice
        .getUsers()
        .subscribe( res => {
         
          this.users = JSON.parse(JSON.stringify(res));
        })
       
    }
    DeleteUser(user:user){
      this.userservice.deleteUser(user)
      .subscribe(data=>{
        this.users=this.users.filter(p=>p!==user);
        this.toaster.success("succès")
      })
    }
    DeleteallUser(){
      this.userservice.deleteAllUsers()
      .subscribe(data=>{
        this.toaster.success("succès")
      })
    }
    Editer(persona:user):void{
      localStorage.setItem("id",persona.id.toString());
      this.router.navigate(["edituser"]);
    }
    gotoaddsupport(){
      this.router.navigate(["addsupport"]);

    }

    recherche2(st: string) {
       if(st=="username"){
      this.userservice
         .getuserByusername(this.choix)
         .subscribe(res => {
           console.log(res)
           console.log(this. users)
         this. users= JSON.parse(JSON.stringify(res));
         console.log(this. users.toString)
      
         })
       }
       if(st=="email"){
         this.userservice
         . getuserByEmail(this.choix)
           .subscribe(res => {
             console.log(res)
     
     
             this.users = JSON.parse(JSON.stringify(res));
           })
         }
         if(st=="id"){
          this.userservice
            .getUserId(this.choix)
            .subscribe(res => {
              console.log(res)
      
      
              this.users = JSON.parse(JSON.stringify(res));
            })
          }
   
         if(st=="label"){
          let label: labelc = new labelc(st)
           this.supportservice
             .getlabel(this.choix)
             .subscribe(res => {
               console.log(res)
               label = res
               this.userservice
               . getuserByLabel(label)
               .subscribe(res => {
                 console.log(res)
         
         
                 this.users = JSON.parse(JSON.stringify(res));
               })
                 })
        
           }
   
   
    
     }
     openModal(user){
      this.selecteduser = user;
      this.username=this.selecteduser.username
      this.email=this.selecteduser.email
      this.id=this.selecteduser.id
      console.log("test select ticket",this.selecteduser)
     
    }
    Actualiser(){
      console.log(this.selecteduser)
      this.selecteduser.email=this.email
      this.selecteduser.username=this.username
          this.userservice.updateUser(this.selecteduser,this.id)
          .subscribe(data=>{
            this.selecteduser=data;
            console.log(this.selecteduser)
            this.toaster.success("succès");
          window.location.reload();
          })
        }

  }


