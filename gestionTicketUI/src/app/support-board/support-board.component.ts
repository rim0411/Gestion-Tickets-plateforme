import { Component, OnInit, Pipe } from '@angular/core';
import { Router } from '@angular/router';

import { Ticket } from '../_services/Ticket';
import { SupportService } from '../support.service';
import { TicketServiceService } from '../ticket-service';
import { isEmpty } from 'rxjs/operators';
import { TokenStorageService } from '../_services/token-storage.service';
import { labelc } from '../_services/labelc';
import { ToastrService } from 'ngx-toastr';
import { StringMap } from '@angular/compiler/src/compiler_facade_interface';
//import { BsModalRef } from 'ngx-bootstrap/modal';
@Component({
  selector: 'app-support-board',
  templateUrl: './support-board.component.html',
  styleUrls: ['./support-board.component.css']
})
export class SupportBoardComponent implements OnInit {
  ticket: Ticket
  selectedTicket : Ticket
  supports: any
  labelsname: any
  tickets: Ticket[]
  tickets2: Ticket[]
  tickets3: Ticket[]
  tickets4: Ticket[]
  isassigned = false
  assigner: string
  strValue: any
  currentUser: any
  notassigned = true
  assigner2:string
  ch: string = ""
  ch2: string = ""
  id: any
  chs: string = "enattente"
  cl: string = "rh"
  cl2: string = "mission"
  cl3: string = "facturation"
  id2: any
  form: any
actionfaite:String
actionafaire:string
  constructor(/*private bsModalRef: BsModalRef,*/private router: Router, private ticketservice: TicketServiceService,
    private supportservice: SupportService, private token: TokenStorageService, private ticketService: TicketServiceService, private toaster: ToastrService) { }


  ngOnInit() {


    this.currentUser = this.token.getUser();



    this.currentUser = this.token.getUser()
    this.supportservice
      .getuserbyrole()
      .subscribe(res => {
        console.log(res)
        this.supports = JSON.parse(JSON.stringify(res));
      })
    this.supportservice
      .getlabelnames()
      .subscribe(res => {
        console.log(res)
        this.labelsname = JSON.parse(JSON.stringify(res));
      })
    this.supportservice
      .getticketbystatut("En Attente")
      .subscribe(res => {
        console.log(res)
        this.tickets = JSON.parse(JSON.stringify(res));
      })
    this.supportservice
      .getticketbystatut("enCour")
      .subscribe(res => {
        console.log(res)
        this.tickets2 = JSON.parse(JSON.stringify(res));


      })
    this.supportservice
      .getticketbystatut("fin de traitement")
      .subscribe(res => {
        console.log(res)
        this.tickets3 = JSON.parse(JSON.stringify(res));


      })
    this.supportservice
      .getticketbystatut("Fermé")
      .subscribe(res => {
        console.log(res)
        this.tickets4 = JSON.parse(JSON.stringify(res));


      })

  }


  test(id) {
    localStorage.setItem("id", this.ticket.id_ticket.toString());
  }
  test2(ticket: Ticket) {
    localStorage.getItem("id");
    ticket = this.ticket
    this.ticketService.updateTicket(ticket)
      .subscribe(data => {
        this.ticket = data;

        this.router.navigate(["supp"]);
      })
  }



  setstatut(id) {
    this.supportservice.setStatutTicket(id)
      .subscribe(res => {
        console.log(res)

      })



    this.reloadPage();


  }
  reloadPage() {
    window.location.reload();
  }

  setstatutenfinDetraitement(id, ticket: Ticket) {
    this.notassigned = false
    this.supportservice.setStatutTicketenfintraitement(id)
      .subscribe(res => {
        console.log(res)

      });


    this.reloadPage();
  }
  action(ticket: Ticket) {
    localStorage.setItem("id", ticket.id_ticket.toString());


    this.router.navigate(["addaction"]);

  }
  getactionfaite(actionfaite: string) {
    return actionfaite
  }






  Editer(ticket: Ticket): void {



    localStorage.setItem("id", ticket.id_ticket.toString());
    console.log(ticket.id_ticket + "id")
    // this.id2  = sessionStorage.getItem("id");
    //  console.log(this.id2)
    // let id =(+this.id)
    this.ticketService.getTicket(this.ticket.id_ticket)
      .subscribe(data => {

        console.log(data)
        this.ticket = data
        this.ch2 = "changer"

      })



  }
  goto(id: number) {

    this.ticketService.getTicket(id)
      .subscribe(data => {
        console.log(id + "id")


        console.log(data)
        this.ticket = data
      })
  }

  getassigner(assigner) {
    this.isassigned = true
    return assigner
  }


  recherchebyassigner() {
   // st = this.form
    
    this.supportservice
      .getticketbyassigner(this.form, "En Attente")
      .subscribe(res => {
        console.log(res)


        this.tickets = JSON.parse(JSON.stringify(res));
      })
    this.supportservice
      .getticketbyassigner(this.form, "enCour")
      .subscribe(res => {
        console.log(res)


        this.tickets2 = JSON.parse(JSON.stringify(res));
      })
    this.supportservice
      .getticketbyassigner(this.form, "fin de traitement")
      .subscribe(res => {
        console.log(res)


        this.tickets3 = JSON.parse(JSON.stringify(res));
      })
    this.supportservice
      .getticketbyassigner(this.form, "Fermé")
      .subscribe(res => {
        console.log(res)


        this.tickets4 = JSON.parse(JSON.stringify(res));
      })
   

  }
  recherchebylabel(name) {
    name = this.form
    let label: labelc = new labelc(name)
    this.supportservice
      .getlabel(name)
      .subscribe(res => {
        console.log(res)
        label = res
        this.supportservice
          .getticketbylabel(res, "En Attente")
          .subscribe(res => {
            console.log(res)


            this.tickets = JSON.parse(JSON.stringify(res));
          })
        this.supportservice
          .getticketbylabel(res, "enCour")
          .subscribe(res => {
            console.log(res)


            this.tickets2 = JSON.parse(JSON.stringify(res));
          })
        this.supportservice
          .getticketbylabel(res, "fin de traitement")
          .subscribe(res => {
            console.log(res)


            this.tickets3 = JSON.parse(JSON.stringify(res));
          })
        this.supportservice
          .getticketbylabel(res, "Fermé")
          .subscribe(res => {
            console.log(res)


            this.tickets4 = JSON.parse(JSON.stringify(res));
          })

      })



  }
  Actualiser(ticket: Ticket) {
    let id = localStorage.getItem("id");
    this.ticketService.getTicket(+id)
      .subscribe(data => {
        console.log(id + "id")


        console.log(data)
        this.ticket = data
      })
    localStorage.setItem("id", ticket.id_ticket.toString());
    console.log(ticket.id_ticket + "id")
    this.id2 = +(sessionStorage.getItem("id"));

    //ticket.assigner=this.selectedTicket.assigner
    this.supportservice.setAssigner(ticket.id_ticket, this.assigner2)
      .subscribe(data => {
        console.log("test select ticket",this.assigner2)
        this.ticket = data;
       
        this.router.navigate(["supp"]);
        this.reloadPage();
        this.toaster.success("Modifier avec succèss");
      })
  }

  assignemoi(ticket) {
    this.assigner2 = this.currentUser.username
  }

  tes(ticket) {
    this.ch = ticket.id_ticket
  }

  openModal(ticket){
    this.selectedTicket = ticket;
   this.assigner2= this.selectedTicket.assigner
   this.actionfaite= this.selectedTicket.actionFaite
   this.actionafaire= this.selectedTicket.actionafaire
    console.log("test select ticket",this.selectedTicket)
   
  }
}
