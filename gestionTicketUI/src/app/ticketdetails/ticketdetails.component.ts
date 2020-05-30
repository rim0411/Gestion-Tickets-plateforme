import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Ticket } from '../_services/Ticket';
import { TokenStorageService } from '../_services/token-storage.service';
import { TicketServiceService } from '../ticket-service';
import { user } from '../_services/user';
import { SupportService } from '../support.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-ticketdetails',
  templateUrl: './ticketdetails.component.html',
  styleUrls: ['./ticketdetails.component.css']
})
export class TicketdetailsComponent implements OnInit {
  form: any = {};
  ticket: Ticket
  currentUser: user
  actionafaire: String
  ch: string = ""

  constructor(private router: Router, private service: UserService, private route: ActivatedRoute,
    private TicketServiceService: TicketServiceService, private token: TokenStorageService, private supportservice: SupportService, private toaster: ToastrService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser()
    let id = localStorage.getItem("id");
    this.TicketServiceService.getTicket(+id)
      .subscribe(data => {
        console.log(data)
        this.ticket = data

      })
  }
  reponseauticket(ticket: Ticket) {
    ticket.user.satisfait = true
    this.supportservice.ReponseUtilisateur(ticket.id_ticket, ticket.user.satisfait).subscribe(data => {
      this.ticket = data;

      let id = localStorage.getItem("id");
      this.supportservice.setStatutTicketFerme(+id).subscribe(res => {
        console.log(res)
        this.reloadPage()
        this.toaster.success("succès")

      });
    })

    this.router.navigate(["user"]);
  }
  reponseauticket2(ticket: Ticket) {
    ticket.user.satisfait = false
    this.supportservice.ReponseUtilisateur(ticket.id_ticket, ticket.user.satisfait).subscribe(data => {
      this.ticket = data;

      let id = localStorage.getItem("id");
      this.supportservice.ReouvrirTicket(+id).subscribe(res => {
        console.log(res)
        this.reloadPage()
        this.toaster.success("succès")



      });

    })

    this.router.navigate(["user"]);
  }
  getactionafaire() {
    console.log(this.ticket.actionafaire)
    return this.ticket.actionafaire


  }
  getactionfaite() {
    console.log(this.ticket.actionFaite + " actionfaite ");
    let act = this.ticket.actionFaite;
    return act

  }

  fermerTicket(id) {
    id = localStorage.getItem("id");
    this.TicketServiceService.getTicket(+id)
      .subscribe(data => {
        console.log(id + "id")
        console.log(data)
        this.ticket = data

      })
    this.supportservice.setStatutTicketFerme(+id).subscribe(res => {
      console.log(res)
      this.reloadPage()
      this.toaster.success("succès")




    });
    this.router.navigate(["user"]);
  }
  ReouvrirTicket(id) {
    id = localStorage.getItem("id");
    this.supportservice.ReouvrirTicket(+id).subscribe(res => {
      console.log(res)
      this.reloadPage()
      this.toaster.success("succès")



    });

    this.router.navigate(["user"]);
  }
  reloadPage() {
    window.location.reload();
  }
}


