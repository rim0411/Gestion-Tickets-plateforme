import { Component, OnInit } from '@angular/core';
import { TicketServiceService } from '../ticket-service';
import { Ticket } from '../_services/Ticket';

@Component({
  selector: 'app-detailticket',
  templateUrl: './detailticket.component.html',
  styleUrls: ['./detailticket.component.css']
})
export class DetailticketComponent implements OnInit {
  ticket: Ticket
  constructor(private TicketService: TicketServiceService) { }

  ngOnInit() {
    let id = localStorage.getItem("id");
    this.TicketService.getTicket(+id)
      .subscribe(data => {
        console.log(id + "id")


        console.log(data)
        this.ticket = data
      })
  }

}
