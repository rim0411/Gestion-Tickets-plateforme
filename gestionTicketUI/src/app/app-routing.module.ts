import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';

import { BoardAdminComponent } from './board-admin/board-admin.component';
import { UserlistComponent } from './userlist/userlist.component';
import { TicketlistComponent } from './ticketlist/ticketlist.component';
import { SupportBoardComponent } from './support-board/support-board.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EditTicketComponent } from './edit-ticket/edit-ticket.component';
import { EdituserComponent } from './edituser/edituser.component';
import { AddactionsComponent } from './addactions/addactions.component';
import { EditicketlistComponent } from './editicketlist/editicketlist.component';
import { TicketdetailsComponent } from './ticketdetails/ticketdetails.component';
import { FinscenarioComponent } from './finscenario/finscenario.component';
import { AddsupportComponent } from './addsupport/addsupport.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'userlist', component: UserlistComponent },
  { path: 'supp', component: SupportBoardComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'editticket', component: EditTicketComponent },
  { path: 'editticketlist', component: EditicketlistComponent },
  { path: 'edituser', component: EdituserComponent },
  { path: 'addaction', component: AddactionsComponent },
  { path: 'ticketlist', component: TicketlistComponent },
  { path: 'ticketdetails', component: TicketdetailsComponent },
  { path: 'addsupport', component: AddsupportComponent },
  { path: 'finsenario', component: FinscenarioComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
