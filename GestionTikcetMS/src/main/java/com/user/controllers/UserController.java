package com.user.controllers;

import java.io.Serializable
;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.user.models.TicketM;
import com.user.models.userM;
import com.user.repositories.UserRepository;
import com.user.services.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController{
	@Autowired
	UserRepository repo ;
	@Autowired
	UserDetailsServiceImpl ser;

	
	

	
@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
@GetMapping(produces = "application/json")
public List<userM>  getAllUsers() {
List<userM> users = new ArrayList<userM>(); 
return ser.findAll();

	
		}
	


	

@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
@GetMapping("/userTickets/{id}")
public TicketM  getusers(@PathVariable("id") Long id) {
List<String> users = new ArrayList<String>();
TicketM ticketliste = ser.findById(id).get().getTicket();

return ticketliste ;}
	
	
@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
@GetMapping("/users/{id}")
public userM getUserById(@PathVariable("id") Long id)
                                                    {
 
 
return ser.findById(id).get() ;
    }

	
@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
@PutMapping("/{id}")
public userM updateuser(@PathVariable Long id,@Valid @RequestBody  userM user) {
user.setId(id);
return  ser.save(user);

	}


@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
 @DeleteMapping("/{id}")
void deleteuser(@PathVariable Long id) {
    	ser.deleteById(id);
    }

@GetMapping("/user")
@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	public String userAccess() {	
	return "useracess";
	}
	
@GetMapping("/{username}")
@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
public long getid(@PathVariable String username) {
Long id= ser.loadUserByid(username);
return id ;
	}


	@GetMapping("/supp")
	@PreAuthorize("hasRole('Support')")
	public String supportAccess() {
		return "Support Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	

		
		
		
	}

