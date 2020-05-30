import { Component, OnInit } from '@angular/core';
import { SupportService } from '../support.service';
import { Ticket } from '../_services/Ticket';
import { TicketServiceService } from '../ticket-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-finscenario',
  templateUrl: './finscenario.component.html',
  styleUrls: ['./finscenario.component.css']
})
export class FinscenarioComponent implements OnInit {
  ticket: Ticket
  constructor(private router: Router, private SupportService: SupportService, private TicketServiceService: TicketServiceService) { }

  ngOnInit() {
    let id = localStorage.getItem("id")
    this.TicketServiceService.getTicket(+id)
      .subscribe(data => {
        console.log(id + "id")


        console.log(data)
        this.ticket = data

      })
  }
  fermerTicket(id: number) {
    this.SupportService.setStatutTicketFerme(id).subscribe(res => {
      console.log(res)

    });

  }
  ReouvrirTicket(id: number) {
    this.SupportService.ReouvrirTicket(id).subscribe(res => {
      console.log(res)

    });

  }

  Actualiser(ticket: Ticket) {
    ticket = this.ticket
    this.TicketServiceService.updateTicket(ticket)
      .subscribe(data => {
        this.ticket = data;

        this.router.navigate(["user"]);
      })
  }

}
