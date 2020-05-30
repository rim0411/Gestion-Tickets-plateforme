import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { Ticket } from '../_services/Ticket';
import { user } from '../_services/user';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  showAdminBoard = false;
  showSupportBoard = false;
  showUserBoard = false;
  username: string;
  email: string;
  roles2: string[]
  constructor(private tokenStorageService: TokenStorageService, private router: Router, private authService: AuthService, private tokenStorage: TokenStorageService, private ToastrService: ToastrService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
      const users = this.tokenStorageService.getUser();

    }
  }

  onSubmit() {
    this.authService.login(this.form).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
        this.showSupportBoard = this.roles.includes('ROLE_SUPPORT');
        this.showUserBoard = this.roles.includes('ROLE_USER');

        if (this.showAdminBoard) {
          this.router.navigate(["admin"])
            .then(() => {
              window.location.reload();
            });
        }
        if (this.showSupportBoard) {
          this.router.navigate(["supp"])
            .then(() => {
              window.location.reload();
            });
        }
        if (this.showUserBoard) {
          this.router.navigate(["user"])
            .then(() => {
              window.location.reload();
            });

        }

        this.ToastrService.success("login avec succès");
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
        this.ToastrService.warning("login avec echec");
      }
    );






  }

  reloadPage() {
    window.location.reload();
  }
  test() {
    this.router.navigate(["supp"])
  }
  motdepasseoublier(){}
}
