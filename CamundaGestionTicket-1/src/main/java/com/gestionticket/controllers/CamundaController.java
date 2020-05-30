package com.gestionticket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.gestionticket.models.*;
import com.gestionticket.repositories.*;
import com.gestionticket.dto.*;
import com.gestionticket.interfaces.CamundaRest;

import java.net.URI;
import java.util.List;
@CrossOrigin("*")

@Component
@RestController
@RequestMapping("/apiCamunda")
public class CamundaController {
	
	UserTaskDto userdto = new UserTaskDto() ;
	  @Autowired
	  
	  CamundaRest  restClient ;
	    public CamundaController(CamundaRest restClient) {
	        this.restClient = restClient;
	    }
		
		  @PostMapping(value="/apiCamunda/test")
	    public  String StartProcess(String bk) {
	      return restClient.StartProcess(bk) ;
	      
	    }
		  
		  
		  
		  
		  @PostMapping(value="/apiCamunda/start")
		    public   ResponseEntity<?> StartProcess2() {
		      return restClient.startProcess() ;
		      
		    }
		  @PostMapping(value="/apiCamunda/usertask/{idprocess}")
		    public  String StartuserTaskAjouterTicket(@PathVariable String idprocess) {
		      return  
		    		  restClient.startAllUserTasks( idprocess).get(0).getId();
		      
		    }
		  @PostMapping(value="/apiCamunda/usertaskcomplete/{idtask}")
		  public  void CompleteuserTaskAjouterTicket(@PathVariable String idtask , @RequestBody MainVarDTO1 var) {
			  
		
		    		  restClient.completajouterticket(idtask, var);
		      
		    }
		  @PostMapping(value="/apiCamunda/usertaskcompl/{idtask}")
		  public  void CompleteuserTask2(@PathVariable String idtask , @RequestBody MainVarDTO3 var) {
			  
		
		    		  restClient.completaSetStatut(idtask, var);
		      
		    }
		  @GetMapping(value="/apiCamunda/get/{idtask}/{var}")
		  public  String getaasigner(@PathVariable String idtask , @PathVariable String var) {
			  
		
		    		return  restClient.getassignerfromusertask(idtask,var) .getAssigner().getValue();
		      
		    }





}
