import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { ProfileComponent } from './profile/profile.component';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserlistComponent } from './userlist/userlist.component';
import { TicketlistComponent } from './ticketlist/ticketlist.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SupportBoardComponent } from './support-board/support-board.component';
import { EditTicketComponent } from './edit-ticket/edit-ticket.component';
import { EdituserComponent } from './edituser/edituser.component';
import { AddactionsComponent } from './addactions/addactions.component';
import { EditicketlistComponent } from './editicketlist/editicketlist.component';
import { TicketdetailsComponent } from './ticketdetails/ticketdetails.component';
import { FinscenarioComponent } from './finscenario/finscenario.component';
import { ToastrModule } from 'ngx-toastr';
import { CommonModule } from '@angular/common';
import { AddsupportComponent } from './addsupport/addsupport.component';
import { DetailticketComponent } from './detailticket/detailticket.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    BoardAdminComponent,
    BoardUserComponent,
    ProfileComponent,
    SupportBoardComponent,
    DashboardComponent,
    UserlistComponent,
    TicketlistComponent,
    EditTicketComponent,
    EdituserComponent,
    AddactionsComponent,
    EditicketlistComponent,
    TicketdetailsComponent,
    FinscenarioComponent,
    AddsupportComponent,
    DetailticketComponent,
    ResetpasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    BrowserAnimationsModule, 
    ToastrModule.forRoot({
      timeOut: 10000,
      positionClass: 'toast-bottom-center',
      preventDuplicates: true,
    }) ,
    ReactiveFormsModule,
    HttpClientModule,
    
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
