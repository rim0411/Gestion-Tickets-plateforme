import { Component, OnInit, Input } from '@angular/core';

import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import { Router } from '@angular/router';
import { TicketServiceService } from '../ticket-service';

import { Ticket } from '../_services/Ticket';
import { FormGroup, FormBuilder } from '@angular/forms';
import { user } from '../_services/user';
import { UserlistComponent } from '../userlist/userlist.component';
import { Route } from '@angular/compiler/src/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  currentUser: any;
  @Input() user: user;
  ch: string
  ch2: string

  tickets: Ticket[];
  constructor(private userService: UserService, private TicketServiceService: TicketServiceService, private route: Router, private token: TokenStorageService, private router: Router) { }



  ngOnInit() {


    this.currentUser = this.token.getUser();
    this.tickets = this.currentUser.ticket;


    this.userService.getticketbyuserid(this.currentUser.id).subscribe(tickets => {

      // tickets = Array.from(tickets);
      this.tickets = tickets

      this.tickets = this.currentUser.ticket;
      console.log(tickets)
    })

  }
  goto() {


    console.log(this.ch + "hi")
    this.ch2 = this.ch

  }

  button() {

    console.log(this.ch2 + "heloo")


  }









}
