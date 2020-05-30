import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TicketServiceService } from '../ticket-service';
import { TokenStorageService } from '../_services/token-storage.service';
import { user } from '../_services/user';
import { Ticket } from '../_services/Ticket';

@Component({
  selector: 'app-editicketlist',
  templateUrl: './editicketlist.component.html',
  styleUrls: ['./editicketlist.component.css']
})
export class EditicketlistComponent implements OnInit {
  form: any = {};
  id: any;
  ticket: any;
currentUser :user
assigneramoi:true
  constructor(private route: ActivatedRoute,private router: Router,
    private TicketServiceService: TicketServiceService,private token:TokenStorageService) { }

    ngOnInit() {
     this.currentUser= this.token.getUser()
     this.ticket = new Ticket(
        this.form.titre,
        this.form.description,
        this.form.label,this.form.id,this.currentUser);
        let id=localStorage.getItem("id");
      this.TicketServiceService.getTicket(+id)
      .subscribe(data=>{
        console.log(id+"id")
  
   
        console.log(data)
        this.ticket=data
      })
  
  
    }

    Actualiser(ticket:Ticket){
  ticket=this.ticket
      this.TicketServiceService.updateTicket(ticket)
      .subscribe(data=>{
        this.ticket=data;

        this.router.navigate(["ticketlist"]);
      })
    }


        reloadPage() {
          window.location.reload();
        }
      }
