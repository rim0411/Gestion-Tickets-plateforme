import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { ToastrService } from 'ngx-toastr';
import { user } from '../_services/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addsupport',
  templateUrl: './addsupport.component.html',
  styleUrls: ['./addsupport.component.css']
})
export class AddsupportComponent implements OnInit {
  form: any = {};
  role:any =[] ;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  user:user;

  constructor(private authService: AuthService,private toaster:ToastrService,private router:Router) { }

  ngOnInit() {

 
  }


  onSubmit() {

    console.log(this.form);
    
    this.user = new user(
      
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password);
      let id
      if(this.form.label=="rh"){
        id=1
      }
      if(this.form.label=="mission"){
        id=2
      }
      if(this.form.label=="facturation"){
        id=4
      }
    this.authService.registersupport(this.user,id,this.form.label).subscribe(
      data => {
        console.log(data);
        this.toaster.success("signup avec succès")
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.router.navigate(["admin"]);
      },
      error => {
   
        console.log();
        this.errorMessage = error.error.message;
        this.toaster.warning("signup avec echec"+this.errorMessage)
        this.isSignUpFailed = true;
      }
    );
  
  }

}
