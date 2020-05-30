package com.user.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.user.dto.CreateMainUser;
import com.user.dto.MainVarDTO1;
import com.user.dto.MainVarDTO2;
import com.user.dto.MainVarDTO3;
import com.user.dto.MainVarDTO4;
import com.user.dto.MainVarDTO5;
import com.user.dto.MainVarDTO6;
import com.user.dto.MainVarDTO7;
import com.user.dto.MainVarDTO8;
import com.user.dto.ProcessInstanceDto;
import com.user.dto.UserTaskDto;
import com.user.dto.formvariableusertaskdt;
import com.user.dto.userCamundaDto;
import com.user.dto.userIdCamunda;
import com.user.repositories.TicketRepository;

@FeignClient(name="camunda-server")
public interface CamundaRest {
	
	 
	
@PostMapping("/startCamunda")
public String StartProcess() ;
@GetMapping("/rest/task/?processInstanceId={idprocess}")
public List<UserTaskDto> startAllUserTasks (@PathVariable String idprocess);
@PostMapping("/rest/task/{idtask}/complete")
public void completajouterticket (@PathVariable String idtask ,MainVarDTO1 var) ;
@PostMapping("/rest/task/{idtask}/complete")
public void completaSetStatut (@PathVariable String idtask ,MainVarDTO3 var) ;
@PostMapping("/rest/task/{idtask}/complete")
public void completaSetAssigner (@PathVariable String idtask ,MainVarDTO2 var) ;
@PostMapping("/rest/task/{idtask}/complete")
public void completesetStatutenfindetraitement (@PathVariable String idtask ,MainVarDTO4 var) ;
@PostMapping("/rest/task/{idtask}/complete")
public void completeTraitementTicket (@PathVariable String idtask ,MainVarDTO5 var) ;
@PostMapping("/rest/task/{idtask}/complete")
public void completeFermerTicket(@PathVariable String idtask ,MainVarDTO7 var) ;
@PostMapping("/rest/task/{idtask}/complete")
public void completeReouvrirTicket(@PathVariable String idtask ,MainVarDTO8 var) ;
@PostMapping("/rest/task/{idtask}/complete")
public void completeReponseaNotification (@PathVariable String idtask ,MainVarDTO6 var) ;
@PostMapping("/rest/process-definition/key/ticketm/start")
public  ResponseEntity<?> startProcess () ;
@PutMapping("/rest/user/{iduser}/profile")
void updateCamundaUsertask3(userCamundaDto userCamunda,@PathVariable String iduser );
@PostMapping( "/rest/task/{idtask}/assignee")
void setassigner(userIdCamunda id , @PathVariable String idtask);
@PostMapping( "/rest/user/create")
void createuserr( CreateMainUser user);
@GetMapping("/rest/task/{idtask}/form-variables?variableNames={var}")
public formvariableusertaskdt getassignerfromusertask (@PathVariable String idtask,@PathVariable String var);


	 
}
