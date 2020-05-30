package com.gestionticket.controllers;


import java.util.ArrayList;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.gestionticket.models.*;
import com.gestionticket.repositories.*;
import com.gestionticket.services.UserDetailsServiceImpl;


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
@GetMapping("/userrs/{id}")
public userM getUserByid(@PathVariable("id") Long id)
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
	

	@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	@PostMapping("/userRoles")
	public  List<String> getsupports(@RequestBody Role role) {
		List<userM> users = new ArrayList<userM>();
		 List<String> supports = new ArrayList<String>();
	users=ser.findByRole(role) ;
	for(userM u: users){
		 String us=  u.getUsername();
		supports.add(us);
		
		}
	return supports ;


	}
		
		
		
	@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	@GetMapping("/users/{id}")
	public List<userM> getUserById(@PathVariable Long id)
	                                                    {
	 
	 
	return ser.findByid(id) ;
	    }
	@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	@GetMapping("/useremail/{email}")
	public userM getUserByEmail(@PathVariable String email)
	                                                    {
	 
	 
	return ser.findByEmail(email) ;
	    }
	@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	@PostMapping("/userlabel")
	public List<userM> getUserBylabel(@RequestBody label label)
	                                                    {
	return ser.findBylabel(label) ;
	    }
	@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	@GetMapping("/username/{username}")
	public List<userM> getUserByusername(@PathVariable String username)
	                                                    {
	 
	 
	return ser.findByUsername(username) ;
	    }
	@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	@GetMapping("/email/{email}")
	public List<userM> getUserByemail(@PathVariable String email)
	                                                    {
	return ser.findByemail(email) ;
	    }	
		
		
	}

