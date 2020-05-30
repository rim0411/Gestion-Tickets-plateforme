import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']

  
})
export class HomeComponent implements OnInit {
  content: string;

  constructor(private userService: UserService,private toastr: ToastrService) { }

  ngOnInit() {
   
  }

}
