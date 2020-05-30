import { Component, OnInit } from '@angular/core';
import { Ticket } from '../_services/Ticket';
import { ActivatedRoute, Router } from '@angular/router';
import { user } from '../_services/user';
import { TicketServiceService } from '../ticket-service';
import { TokenStorageService } from '../_services/token-storage.service';
import { SupportService } from '../support.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-addactions',
  templateUrl: './addactions.component.html',
  styleUrls: ['./addactions.component.css']
})
export class AddactionsComponent implements OnInit {
  form: any = {};
  id: any;
  ticket: any;
  currentUser: user
  constructor(private route: ActivatedRoute, private router: Router,
    private TicketServiceService: TicketServiceService, private token: TokenStorageService, private supportticket: SupportService, private toast: ToastrService) { }

  ngOnInit() {

    this.currentUser = this.token.getUser()


    /*  this.ticket = new Ticket(
        this.form.titre,
        this.form.description,
        this.form.label,this.currentUser);*/
    let id = localStorage.getItem("id");
    this.TicketServiceService.getTicket(+id)
      .subscribe(data => {
        console.log(id + "id")


        console.log(data)
        this.ticket = data
      })


  }

  Actualizer(ticket: Ticket) {
    ticket = this.ticket

    this.supportticket.addactions(ticket)
      .subscribe(data => {
        this.ticket = data;
        this.toast.success("ajout avec succès")
        this.router.navigate(["supp"]);
      })
  }

}