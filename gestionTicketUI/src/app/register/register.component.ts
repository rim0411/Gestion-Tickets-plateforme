import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { user } from '../_services/user';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {};
  role: any = [];
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  user: user;

  constructor(private router: Router, private authService: AuthService, private toaster: ToastrService) { }

  ngOnInit() {

    // this.form.role = this.form;
  }

  /* onSubmit() {
     this.authService.register(this.form).subscribe(
       data => {
         console.log(data);
         this.isSuccessful = true;
         this.isSignUpFailed = false;
       },
       err => {
         this.errorMessage = err.error.message;
         this.isSignUpFailed = true;
       }
     );
   }*/


  onSubmit() {

    console.log(this.form);

    this.user = new user(

      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password);

    this.authService.register(this.user).subscribe(
      data => {
        console.log(data);
        this.reloadPage();
        this.toaster.success("inscription avec succès");
        this.router.navigate(["home"])
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.toaster.warning( this.errorMessage)
   
        this.isSignUpFailed = true;
      }
    );
   this.router.navigate(['home'])

  }
  reloadPage() {
    window.location.reload();
  }
}


