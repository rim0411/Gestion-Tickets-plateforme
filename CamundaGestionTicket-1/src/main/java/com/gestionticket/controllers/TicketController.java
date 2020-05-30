package com.gestionticket.controllers;
import com.gestionticket.dto.*;


import com.gestionticket.models.*;
import com.gestionticket.repositories.UserRepository;
import com.gestionticket.repositories.testRepositiry;
import com.gestionticket.services.*;
import com.gestionticket.controllers.NotFoundException;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class TicketController  {
	
	 @Autowired
	    TicketService service;
	 @Autowired
	    UserDetailsServiceImpl serviceU;
	 @Autowired
	 UserRepository rep ;
	 @Autowired
	 testRepositiry re ;
	 
	 @GetMapping("/test")
	 public String test () {
		 return "test";
	 }
	 @PostMapping("/test5")
	 public test test (@RequestBody test entity) {
		 return re.save(entity);
	 }
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
		@RequestMapping(value = "/tickets", //
        method = RequestMethod.GET, //
        produces = "application/json")
	 public ResponseEntity<List<TicketM>> getAllTickets() {
	        List<TicketM> list = service.findAll();
	 
	        return new ResponseEntity<List<TicketM>>(list, new HttpHeaders(), HttpStatus.OK);
	    }
		
		
		
	
		  
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("tickets/{id}")
	    public TicketM getTicketById(@PathVariable("id") Long id)
	                                                    throws RecordNotFoundException {
	  TicketM ticket = service.findById(id).get();
	    	return  ticket ;
	 

	    }
		
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @PutMapping("tickets/{id}")
	    public TicketM updateticket(@PathVariable Long id, @Valid @RequestBody TicketM ticket) {
	    	System.out.println("Update ticket with ID = " + id + "...");
	    	  ticket.setId_ticket(id);
				 return service.updateTicket(ticket) ;
    
		
		}
		
	/*	@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @PostMapping("/tickets/ajouterTicket")
	    public MainVarDTO1 createTicket(@RequestBody TicketM ticket)
	                                                    throws RecordNotFoundException {
			return service.save(ticket) ; 
	    }*/

		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @PostMapping("/tickets/ajouterTicket")
	    public TicketM createTicket(@RequestBody TicketM ticket)
	                                                    throws RecordNotFoundException {
			return service.save(ticket) ; 
	    }
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @PostMapping("/tickets/start")
	    public MainVarDTO1 startprocess(@RequestBody TicketM ticket)
	                                                    throws RecordNotFoundException {
			return service.startprocess(ticket) ; 
	    }
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @PostMapping("/tickets/ajouter")
	    public TicketM createTickedt(@RequestBody TicketM test)
	                                                    throws RecordNotFoundException {
			return service.save2(test) ; 
	    }
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("/Setassigner/{id}/{assigner}")
		  public void SetassignerTicket(@PathVariable Long id, @PathVariable String assigner) {
		service.changerassigner(id,assigner);}
		
		
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("StatutEncour/{id}")
	    public MainVarDTO3 setStatut(@PathVariable Long id) {
				 return service.userTask3(id);
    
		
		}
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @PutMapping("ticketsaction/{idd}")
	    public TicketM updateticketwithactions(@PathVariable Long idd, @Valid @RequestBody TicketM tickett) {
	    	
	    	  tickett.setId_ticket(idd);
	    	  System.out.println("Update Customer with ID = " + idd + "...");
				 return service.usertask5(tickett);
		}
		

		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("/StatutEnfintraitement/{id}")
		  public MainVarDTO4 SetStatutTicketEnFinTraitement(@PathVariable Long id) {
		return	service.userTask4(id) ;}

		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("/reponseNotif/{id}/{satisfait}")
		  public MainVarDTO6 ReponseNotification(@PathVariable Long id,@PathVariable boolean satisfait) {
		return	service.completeuserTask6(id,satisfait) ;}
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("/fermerTicket/{id}")
		  public MainVarDTO7 fermerTicket(@PathVariable Long id) {
		return	service.userTask7(id) ;}
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("/reouvrirTicket/{id}")
		  public MainVarDTO8 ReouvrirTicket(@PathVariable Long id) {
		return	service.userTask8(id) ;}
		
		
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("/Alltickets/{statut}")
	    public List<TicketM> getTicketsbyStatut(@PathVariable String statut) {
		List<TicketM> ticket= service.findBystatut(statut);
          return ticket ;
	    }
		
		
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("/Alltickets2/{assigner}")
	    public List<TicketM> getTicketsbyAssigner(@PathVariable String assigner ) {
			
		List<TicketM> ticket= service.findByassigner(assigner);
          return ticket ;
	    }
	
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @GetMapping("/Alltickets4/{assigner}/{statut}")
	    public List<TicketM> getTicketsbyAssignerAndstatut(@PathVariable String assigner, @PathVariable String statut ) {
			
		List<TicketM> ticket= service.findByassignerEtstatut(assigner, statut);
          return ticket ;
	    }
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
	    @PostMapping("/Alltickets5/{statut}")
	    public List<TicketM> getTicketsbyLabelAndstatut(@RequestBody label label, @PathVariable String statut ) {
			
		List<TicketM> tickets= service.findByLabelEtstatut(label, statut);
		return tickets;
	    }
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
		  @PostMapping("/Alltickets3")
		    public List<TicketM> getTicketsbylabel(@RequestBody label label) {
			List<TicketM> ticket= service.findBylabel(label);
	          return ticket ;
		    }
		@PreAuthorize("hasRole('ADMIN')")
		  @GetMapping("/Allticketstitre/{titre}")
		    public List<TicketM> findByTitre(@PathVariable String titre) {
			List<TicketM> ticket= service.findByTitre(titre);
	          return ticket ;
		    }

	

		   @DeleteMapping("/ticket/{Id}")
		    public String deleteAssignment2(
		    							   @PathVariable Long Id) {
		    	
		    	
		    	
		        return rep.findById(Id)
		                .map(assignment -> {
		                  rep.deleteById(Id);
		                    return "Deleted Successfully!";
		                }).orElseThrow(() -> new NotFoundException("Contact not found!"));
		    }
		@PreAuthorize("hasRole('USER') or hasRole('SUPPORT') or hasRole('ADMIN')")
		 @DeleteMapping("/delete")
		void DeleteALL() {
			service.deleteALL();
			
		}
		
		

	 
		
		
		
		
}

