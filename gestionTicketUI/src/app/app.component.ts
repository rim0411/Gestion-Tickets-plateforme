import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './_services/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  private roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showSupportBoard = false;
  showUserBoard = false;
  username: string;
  email: string;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showSupportBoard = this.roles.includes('ROLE_SUPPORT');
      this.showUserBoard = this.roles.includes('ROLE_USER');

      this.username = user.username;
      this.email = user.email;
    }
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
