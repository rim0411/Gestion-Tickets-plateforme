import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TicketServiceService } from '../ticket-service';
import { Router } from '@angular/router';
import { Ticket } from '../_services/Ticket';
import { TokenStorageService } from '../_services/token-storage.service';
import { user } from '../_services/user';
import { Camunda } from '../_services/camunda';
import { ToastrService } from 'ngx-toastr';
import { labelc } from '../_services/labelc';
import { SupportService } from '../support.service';
import { AuthService } from '../_services/auth.service';


@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  camundastart: Camunda
  ticket: Ticket;
  ticket2: any
  successAjoutTicket: string
  form: any = {};
  username: string;
  content = '';
  isSuccessful = false;
  isSignUpFailed = false;
  submitted = false;
  currentUser: user;
  label: any;
  id: string
  user:user
  errorMessage = '';
  postedid;
  postedid2
  assigner = ""
  statut2 = "fin de traitement"
  statut = ""
  isajout = false;
  ch: string = ""
  ch2: string = ""
  ticketstart:Ticket
  constructor(private authservice:AuthService,private router:Router,private supportservice: SupportService, private userService: UserService, private TicketServiceService: TicketServiceService, private route: Router, private token: TokenStorageService, private toaster: ToastrService) {

  }

  ngOnInit() {
    //usercourant
    this.currentUser = this.token.getUser();

    console.log(this.currentUser.id)
    this.ticket2 = this.userService.getticketbyuserid(this.currentUser.id)


    //AfficherTicketDeuser
    this.userService.getticketbyuserid(this.currentUser.id).subscribe(
      ticket2 => {
        // this.toaster.success("succès")
        this.ticket2 = ticket2;
        console.log(ticket2)
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );

  }
  gototicketdetails(ticket: Ticket): void {
    localStorage.setItem("id", ticket.id_ticket.toString());
    this.route.navigate(["ticketdetails"]);
  }
  gotoeditticket(ticket: Ticket): void {
    localStorage.setItem("id", ticket.id_ticket.toString());
    this.route.navigate(["finsenario"]);
  }






 /* onSubmit(): string {
    let user1: user = this.currentUser;
    user1.email = null;
    user1.name = null;
    user1.password = null;
    user1.role = null;
    user1.ticket = null;
    user1.username = null;
    this.label = new labelc(this.form.label);
    // console.log("label"+this.label);
    this.TicketServiceService.createlabel(this.label)
      .subscribe(
        data => {
          this.postedid2 = data.id;
          this.label.name = data.name

          console.log(this.label + "data");
          sessionStorage.setItem("lastname", this.form.label);
          sessionStorage.setItem("id", data.id);
          // Retrieve
          //  this.name = sessionStorage.getItem("lastname");
          this.id = sessionStorage.getItem("id");
          let id = (+this.id)
          //this.label= this.TicketServiceService.getlabel(+this.id)
          console.log("id" + id)
          this.ticket = new Ticket(this.form.titre, this.form.description, id, this.form.label, user1);
          console.log("ticket" + this.ticket);
          this.TicketServiceService.createTicket(this.ticket)
            .subscribe(
              data => {
                this.postedid = data.id;

                console.log(data + "data");
              }
            )
        }
      )



    this.successAjoutTicket = "Ajout avec succès";
    return ("successAjoutTicket")
  }*/


 /* onSubmit2() {

    let user1: user = this.currentUser;
    user1.email = null;
    user1.name = null;
    user1.password = null;
    user1.role = null;
    user1.ticket = null;
    user1.username = null;
    this.label = new labelc(this.form.label);
    let id
    if (this.form.label == "rh") {
      id = 1
    }
    if (this.form.label == "mission") {
      id = 2
    }
    if (this.form.label == "facturation") {
      id = 4
    }

    this.ticket = new Ticket(this.form.titre, this.form.description, id, this.form.label, user1);
    console.log("ticket" + this.ticket);


    this.TicketServiceService.createTicket(this.ticket)
      .subscribe(
        data => {


         this.postedid = data.id;
          this.isajout = true
          console.log(data + "data")
          this.router.navigate(["user"]);
          this.isSuccessful = true;
       


          err => {
            this.isajout = false
            this.errorMessage = err.error.message;
            this.toaster.warning( this.errorMessage)
            console.log("ereur")
            

          }
        }
      )


    window.location.reload();
   
  }*/
  
 onSubmit2() {

    let user1: user = this.currentUser;
    user1.email = null;
    user1.name = null;
    user1.password = null;
    user1.role = null;
    user1.ticket = null;
    user1.username = null;
    this.label = new labelc(this.form.label);
    let id
    if (this.form.label == "rh") {
      id = 1
    }
    if (this.form.label == "mission") {
      id = 2
    }
    if (this.form.label == "facturation") {
      id = 4
    }

    this.ticket = new Ticket(this.form.titre, this.form.description, id, this.form.label, user1);
    console.log("ticket" + this.ticket);


    this.TicketServiceService.createTicket(this.ticket)
      .subscribe(
        data => {


         this.postedid = data.id;
          this.isajout = true
          console.log(data + "data")
      //    this.router.navigate(["user"]);
          this.isSuccessful = true;
       this.ticketstart=data
          this.TicketServiceService.startprocess( this.ticketstart) .subscribe(
            data2 => {
    
    
             this.postedid = data2.id;
              this.isajout = true
              console.log(data2 + "data")
             this.router.navigate(["user"]);
              this.isSuccessful = true;})

          err => {
            this.isajout = false
            this.errorMessage = err.error.message;
            this.toaster.warning( this.errorMessage)
            console.log("ereur")
            

          }
        }
      )


  window.location.reload();
  window.location.reload();
   
  }
  onSubmit3() {
    this.toaster.warning("ddd")
  }


  reponseauticket2(ticket: Ticket) {
    this.ticket2.user.satisfait = false
    this.supportservice.ReponseUtilisateur(ticket.id_ticket, ticket.user.satisfait).subscribe(data => {
      this.ticket = data;

      let id = localStorage.getItem("id");
      this.supportservice.ReouvrirTicket(+id).subscribe(res => {
        console.log(res)

        this.toaster.success("succès")

        window.location.reload();

      });

    })

  }
  Notification(ticket:Ticket) {
    if(ticket.assigner!=null)
    this.toaster.success("Notification", "Ajout avec succès")
  }


  Editar(ticket: Ticket): void {
    localStorage.setItem("id", ticket.id_ticket.toString());
    this.route.navigate(["edituser"]);
  }


  reponseauticket(ticket: Ticket) {
    this.ticket2.user.satisfait = true
    this.supportservice.ReponseUtilisateur(ticket.id_ticket, ticket.user.satisfait).subscribe(data => {
      this.ticket = data;

      let id = localStorage.getItem("id");
      this.supportservice.setStatutTicketFerme(+id).subscribe(res => {
        console.log(res)

        this.toaster.success("succès")
        window.location.reload();
      });
    })


  }


  getactionafaire(ticket) {

    return ticket.actionafaire


  }
  getactionfaite() {

    let act = this.ticket.actionFaite;
    return act

  }
  onSubmit() {

    console.log(this.form);

    this.user = new user(

      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password);

    this.authservice.register(this.user).subscribe(
      data => {
        console.log(data);
        this.reloadPage();
        this.toaster.success("inscription avec succès");
        this.router.navigate(["home"])
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.toaster.warning( this.errorMessage)
   
        this.isSignUpFailed = true;
      }
    );
   

  }
  reloadPage() {
    window.location.reload();
  }
 
  getactionfaite2(actionfaite: string) {
    return actionfaite
  }
}

