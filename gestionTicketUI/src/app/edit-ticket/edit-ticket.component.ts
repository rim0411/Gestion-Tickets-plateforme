import { Component, OnInit } from '@angular/core';
import { Ticket } from '../_services/Ticket';
import { ActivatedRoute, Router } from '@angular/router';
import { TicketServiceService } from '../ticket-service';
import { TokenStorageService } from '../_services/token-storage.service';
import { user } from '../_services/user';
import { SupportService } from '../support.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-edit-ticket',
  templateUrl: './edit-ticket.component.html',
  styleUrls: ['./edit-ticket.component.css']
})
export class EditTicketComponent implements OnInit {
  form: any = {};
  id: any;
  ticket: any;
  currentUser: user
  assigneramoi: true
  constructor(private route: ActivatedRoute, private router: Router,
    private TicketServiceService: TicketServiceService, private token: TokenStorageService, private supportticket: SupportService, private toaster: ToastrService) { }

  ngOnInit() {
    this.Editar();
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
  showToaster() {
    this.toaster.success("Data shown successfully !!", "Notification")
  }

  Editar() {





  }
  Actualizar(ticket: Ticket, b: boolean) {
    ticket = this.ticket
    this.TicketServiceService.updateTicket(ticket)
      .subscribe(data => {
        this.ticket = data;
        this.toaster.success("sucess")
        this.router.navigate(["supp"]);
      })
  }




  test() {
    console.log(this.currentUser.username)

  }
  reloadPage() {
    window.location.reload();
  }

  Actualiser(ticket: Ticket) {
    ticket = this.ticket


    this.supportticket.setAssigner(ticket.id_ticket, ticket.assigner)
      .subscribe(data => {
        this.ticket = data;
        this.router.navigate(["supp"]);
        this.reloadPage();
        this.toaster.success("Modifier avec succèss");
      })
  }
  assignermoi(id: number) {
    this.supportticket.setAssigner(id, this.currentUser.username)
      .subscribe(data => {
        this.ticket = data;
        this.toaster.success("Modifier avec succèss");
        this.router.navigate(["supp"]);
        this.reloadPage();
      })

  }
  assignemoi() {
    this.ticket.assigner = this.currentUser.username
  }
  setstatut(id) {
    this.supportticket.setStatutTicket(id)
      .subscribe(res => {
        console.log(res)

      })



    this.reloadPage();


  }
}