import { Component, OnInit } from '@angular/core';
import { Ticket } from '../_services/Ticket';
import { TicketServiceService } from '../ticket-service';
import { Router } from '@angular/router';
import { SupportService } from '../support.service';
import { ToastrService } from 'ngx-toastr';
import { labelc } from '../_services/labelc';

@Component({
  selector: 'app-ticketlist',
  templateUrl: './ticketlist.component.html',
  styleUrls: ['./ticketlist.component.css']
})
export class TicketlistComponent implements OnInit {


  ticket: Ticket
  tickets: Ticket[]
  tickets2: Ticket[]
  search = false
  choix: string
  titre:string
  statut2:string
  assigner:string
  constructor(private router: Router,
    private ticketservice: TicketServiceService, private supportservice: SupportService, private toaster: ToastrService) { }


  ngOnInit() {
    this.ticketservice
      .getTicketsList()
      .subscribe(res => {
        //console.log(JSON.parse(JSON.stringify(res)));
        this.tickets = JSON.parse(JSON.stringify(res));
      })

    this.supportservice
      .getticketbystatut(this.choix)
      .subscribe(res => {
        console.log(res)


        this.tickets2 = JSON.parse(JSON.stringify(res));
      })




  }





  Editar(ticket: Ticket): void {
    localStorage.setItem("id", ticket.id_ticket.toString());
    this.router.navigate(["editticketlist"]);
  }

  DeleteTicket(ticket: Ticket) {
    this.ticketservice.deleteTicket(ticket)
      .subscribe(data => {
        this.tickets = this.tickets.filter(p => p !== ticket);
        this.toaster.success("succès")
        window.location.reload()
      })
  }


  recherche(st: string) {
    st = this.choix
    this.search = true
    this.supportservice
      .getticketbystatut(this.choix)
      .subscribe(res => {
        console.log(res)


        this.tickets = JSON.parse(JSON.stringify(res));
      })

  }
  
  recherche2(st: string) {
   // st = this.statut
    this.search = true
    if(st=="statut"){
    this.supportservice
      .getticketbystatut(this.choix)
      .subscribe(res => {
        console.log(res)


        this.tickets = JSON.parse(JSON.stringify(res));
      })
    }
    if(st=="titre"){
      this.ticketservice
        . getticketsbyTitre(this.choix)
        .subscribe(res => {
          console.log(res)
  
  
          this.tickets = JSON.parse(JSON.stringify(res));
        })
      }

      if(st=="label"){
        let label: labelc = new labelc(st)
        this.supportservice
          .getlabel(this.choix)
          .subscribe(res => {
            console.log(res)
            label = res
            this.ticketservice
            . findByLabel(label)
            .subscribe(res => {
              console.log(res)
      
      
              this.tickets = JSON.parse(JSON.stringify(res));
            })
              })
     
        }


  
  }


  DeleteALLTicket() {
    this.ticketservice.deleteALLTickets()
      .subscribe(data => {
        this.toaster.success("succès")
      })
  }



}