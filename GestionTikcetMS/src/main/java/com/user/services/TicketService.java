package com.user.services;
import java.util.List

;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.controllers.CamundaRest;
import com.user.dto.CreateMainUser;
import com.user.dto.DtoCamundaTicket;
import com.user.dto.DtoCamundaTicketTask2;
import com.user.dto.DtoCamundaTicketTask3;
import com.user.dto.DtoCamundaTicketTask4;
import com.user.dto.DtoCamundaTicketTask5;
import com.user.dto.DtoCamundaTicketTask6;
import com.user.dto.DtoCamundaTicketTask7;
import com.user.dto.DtoCamundaTicketTask8;
import com.user.dto.MainVarDTO1;
import com.user.dto.MainVarDTO2;
import com.user.dto.MainVarDTO3;
import com.user.dto.MainVarDTO4;
import com.user.dto.MainVarDTO5;
import com.user.dto.MainVarDTO6;
import com.user.dto.MainVarDTO7;
import com.user.dto.MainVarDTO8;
import com.user.dto.VariableDTO;
import com.user.dto.VariableDTO2;
import com.user.dto.VariableDTO3;
import com.user.dto.VariableDTO4;
import com.user.dto.VariableDTO5;
import com.user.dto.VariableDTO6;
import com.user.dto.VariableDTO7;
import com.user.dto.VariableDTO8;
import com.user.dto.credential;
import com.user.dto.userCamundaDto;
import com.user.dto.userIdCamunda;
import com.user.models.TicketM;
import com.user.models.label;
import com.user.repositories.TicketRepository;
import com.user.repositories.UserRepository;
import com.user.repositories.labelRepository;
@Service
@Transactional()
public class TicketService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
    private TicketRepository  DaoTicket;
	@Autowired
    private labelRepository  daolabel;
	
	
	
	
	    @Autowired
	     CamundaRest  restClient ;
	    public TicketService(CamundaRest restClient) {
	     this.restClient = restClient;
	    }
	    
		
		  public  void ChangerUserCamunda( userCamundaDto user,String iduser) {
			    restClient.updateCamundaUsertask3(user,iduser);
			      
			    }
		  
		  public  void CreatUserCamunda( CreateMainUser user) {
			    restClient.createuserr(user);
			      
			    }
	    
	  public String   StartProcess () {
	  return  restClient.StartProcess() ;
	  }
	  
	  
	  public  String StartuserTask(String idprocess) {
	      return  restClient.startAllUserTasks( idprocess).get(0).getId();}
	  
	  
	  public  void Completeusertask(String idtask ,MainVarDTO1  var) {
	    restClient.completajouterticket(idtask, var);
	      
	    }
	  public  String getassignerdecision(String idtask ,String var) {
		  return  restClient.getassignerfromusertask(idtask, var).getAssigner().getValue() ;
		      
		    }
	  

	


	  
	  public  void Completeusertask2(String idtask ,MainVarDTO2 var) {
		    restClient.completaSetAssigner(idtask, var);;
		      
		    }
	  public  void Completeusertask3(String idtask ,MainVarDTO3 var) {
		    restClient.  completaSetStatut(idtask, var);
		  
		      
		    }
	  
	  
		public void   Completeusertask4(String idtask ,MainVarDTO4  var) {
		    restClient.completesetStatutenfindetraitement(idtask, var);
		      
		    }
	  public  void ChangerAssignerUserTask3( userIdCamunda userCamundaId,String userTaskId) {
		    restClient.setassigner(userCamundaId ,userTaskId);
		      
		    }
	  
		
		public void   Completeusertask5(String idtask ,MainVarDTO5  var) {
		    restClient.completeTraitementTicket(idtask, var);
		      
		    }
	  public void   Completeusertask6(String idtask ,MainVarDTO6 var) {
		    restClient.	completeReponseaNotification(idtask, var);
		      
		    }
	  public void   Completeusertask7(String idtask ,MainVarDTO7 var) {
		    restClient.	completeFermerTicket(idtask, var);
		      
		    }
	  public void   Completeusertask8(String idtask ,MainVarDTO8 var) {
		    restClient.completeReouvrirTicket(idtask, var);
		      
		    }
	  
	  

	  
	public List findAll() {
	 return (List)DaoTicket.findAll();
   }

   public  Optional<TicketM> findById(Long id) {
   return DaoTicket.findById(id);
   }
  
   
   
   
 
   
   
   public  List<TicketM> findBystatut(String statut) {
       return DaoTicket.findByStatut(statut);
   }
   public TicketM save2(TicketM ticket) {
	 return   DaoTicket.save(ticket);
   }
   public	MainVarDTO1 save(TicketM ticket) {
	
	TicketM ticketReslt=   DaoTicket.save(ticket);
    DaoTicket.findById(ticketReslt.getId_ticket()).get().setStatut("enattente");
	String titre=  DaoTicket.findById(ticketReslt.getId_ticket()).get().getTitre();
	String  label=DaoTicket.findById(ticketReslt.getId_ticket()).get().getLabel().getName();
	String  description =DaoTicket.findById(ticketReslt.getId_ticket()).get().getDescription();
	VariableDTO tit = new VariableDTO();
	tit.setValue(titre);
	tit.setType("string");
    VariableDTO labell = new VariableDTO();
	labell.setValue(label);
	labell.setType("string");
	VariableDTO descriptionn = new VariableDTO();
	descriptionn.setValue(description);
	descriptionn.setType("string");
	DtoCamundaTicket varcamunda = new  DtoCamundaTicket() ;
	varcamunda.setDescription(descriptionn);
	varcamunda.setLabel(labell);
	varcamunda.setTitre(tit);
	MainVarDTO1 vardto = new MainVarDTO1() ;
	vardto.setVariables(varcamunda);
	String ProcessId=   StartProcess();
	DaoTicket.findById(ticketReslt.getId_ticket()).get().setIdProcess(ProcessId);
	String taskid=StartuserTask( ProcessId) ;
	Completeusertask(taskid,vardto) ;

	String taskid2=StartuserTask( ProcessId) ;
String assigner1=	getassignerdecision(taskid2,"assigner") ;
DaoTicket.findById(ticketReslt.getId_ticket()).get().setAssigner(assigner1);

       return  vardto; }
  
public MainVarDTO2 completeUserTask2 (long id ,String assigner){ 	   
DaoTicket.findById(id).get().setAssigner(assigner);
DaoTicket.save(DaoTicket.findById(id).get());
String ProcessId =DaoTicket.findById(id).get().getIdProcess() ;
String idTask2=StartuserTask( ProcessId) ; 
userIdCamunda userId = new userIdCamunda();
userCamundaDto user  = new userCamundaDto();
user.setFirstName(assigner);
user.setId("support");
user.setLastName(assigner) ;
user.setEmail(assigner+"@camunda.com");			 
ChangerUserCamunda(user,"support" ) ;
userId.setUserId("support");
ChangerAssignerUserTask3(userId,idTask2);
VariableDTO2 assignerr3 = new VariableDTO2();
assignerr3.setValue(assigner) ;
assignerr3.setType("string");
DtoCamundaTicketTask2 varcamundatask2 = new  DtoCamundaTicketTask2() ;
varcamundatask2.setAssigner(assignerr3) ;
MainVarDTO2 vardto2 = new  MainVarDTO2() ;
vardto2.setVariables(varcamundatask2);
Completeusertask2(idTask2, vardto2);
return vardto2;} 



public MainVarDTO3 userTask3 (long id ) {   
DaoTicket.findById(id).get().setStatut("enCour"); 
DaoTicket.findById(id).get().setActionafaire("");
DaoTicket.findById(id).get().setActionFaite("");
DaoTicket.save( DaoTicket.findById(id).get()) ;
String Statut = DaoTicket.findById(id).get().getStatut() ;
String assigner = DaoTicket.findById(id).get().getAssigner() ;
String ProcessId =   DaoTicket.findById(id).get().getIdProcess() ;
String idTask2=StartuserTask( ProcessId) ;
//changer assigner
userIdCamunda userId = new userIdCamunda();
userCamundaDto user  = new userCamundaDto();
user.setFirstName(assigner);
user.setId("support");
user.setLastName(assigner) ;
user.setEmail(assigner+"@camunda.com");			 
ChangerUserCamunda(user,"support" ) ;
userId.setUserId("support");
ChangerAssignerUserTask3(userId,idTask2);
//completetask
VariableDTO2 assignerr3 = new VariableDTO2();
assignerr3.setValue(assigner) ;
assignerr3.setType("string");
VariableDTO3 Stat = new VariableDTO3();
Stat.setValue(Statut) ;
Stat.setType("string");
DtoCamundaTicketTask3 varcamundatask3 = new  DtoCamundaTicketTask3() ;
varcamundatask3.setStatut(Stat);
MainVarDTO3 vardto3 = new  MainVarDTO3() ;
vardto3.setVariables(varcamundatask3);		   
Completeusertask3(idTask2, vardto3);
return vardto3;	}

public MainVarDTO4 userTask4 (long id ){	
userIdCamunda userId = new userIdCamunda();
userCamundaDto user  = new userCamundaDto();
String assigner = DaoTicket.findById(id).get().getAssigner() ;
String ProcessId = DaoTicket.findById(id).get().getIdProcess() ;
DaoTicket.findById(id).get().setStatut("fin de traitement");	   		   
DaoTicket.save( DaoTicket.findById(id).get()) ;
String Statut = DaoTicket.findById(id).get().getStatut() ;
 //completeFinTraitement	
VariableDTO4 statutFintraitement = new VariableDTO4();
statutFintraitement.setValue(Statut) ;
statutFintraitement.setType("string");
DtoCamundaTicketTask4 varcamundatask4 = new  DtoCamundaTicketTask4() ;
varcamundatask4.setStatut(statutFintraitement );
MainVarDTO4 vardto4 = new  MainVarDTO4() ;
vardto4.setVariables(varcamundatask4);
String idTask3=StartuserTask( ProcessId) ;
Completeusertask4(idTask3, vardto4);         
return vardto4 ; }
   
   
public TicketM usertask5(TicketM ticket ) { 
DaoTicket.saveAndFlush(ticket) ;
String actionDto;
String ProcessId= DaoTicket.findById(ticket.getId_ticket()).get().getIdProcess() ;
String email= DaoTicket.findById(ticket.getId_ticket()).get().getUser().getEmail() ;
if( DaoTicket.findById(ticket.getId_ticket()).get().getActionafaire() == "") {
String actionfaites= DaoTicket.findById(ticket.getId_ticket()).get().getActionFaite() ;
 actionDto =actionfaites ;}
 else {  
String actionAfaire=DaoTicket.findById(ticket.getId_ticket()).get().getActionafaire() ;
actionDto =actionAfaire;}
VariableDTO5 actions = new VariableDTO5();
actions.setValue(actionDto) ;
actions.setType("string");
VariableDTO5 emaill = new VariableDTO5();
emaill.setValue(email) ;
emaill.setType("string");
DtoCamundaTicketTask5 varcamundatask5 = new  DtoCamundaTicketTask5() ;
varcamundatask5.setAction(actions);
varcamundatask5.setEmail(emaill);
MainVarDTO5 vardto5 = new  MainVarDTO5() ;
vardto5.setVariables(varcamundatask5);
String idTask5=StartuserTask( ProcessId) ;
Completeusertask5(idTask5, vardto5);
return ticket;   
	   
   } 
   
 public MainVarDTO6  completeuserTask6(long id, boolean satisfait) {
String ProcessId= DaoTicket.findById(id).get().getIdProcess() ;
DaoTicket.findById(id).get().getUser().setSatisfait(satisfait);
userRepository.save(DaoTicket.findById(id).get().getUser()) ;
DaoTicket.save( DaoTicket.findById(id).get()) ;
VariableDTO6 satisfaitt = new VariableDTO6();
satisfaitt.setValue(satisfait) ;
satisfaitt.setType("boolean");
DtoCamundaTicketTask6 varcamundatask6 = new  DtoCamundaTicketTask6() ;
varcamundatask6.setSatisfait(satisfaitt);
MainVarDTO6 vardto6 = new  MainVarDTO6() ;
vardto6.setVariables(varcamundatask6);
String idTask3=StartuserTask( ProcessId) ;
Completeusertask6(idTask3, vardto6);
	   return vardto6;
	   
   }
 public MainVarDTO7 userTask7 (long id ) {
DaoTicket.findById(id).get().setStatut("Fermé"); 
DaoTicket.save( DaoTicket.findById(id).get()) ;
String Statut = DaoTicket.findById(id).get().getStatut() ;
VariableDTO7 Stat = new VariableDTO7();
Stat.setValue(Statut);
Stat.setType("string");
DtoCamundaTicketTask7 varcamundatask7 = new  DtoCamundaTicketTask7() ;
varcamundatask7.setStatut(Stat);
MainVarDTO7 vardto7 = new  MainVarDTO7() ;
vardto7.setVariables(varcamundatask7);	   
String ProcessId =   DaoTicket.findById(id).get().getIdProcess() ;
String idTask7=StartuserTask( ProcessId) ;
Completeusertask7(idTask7, vardto7);
return vardto7 ;	       
 }
 
public MainVarDTO8 userTask8 (long id ) {
DaoTicket.findById(id).get().setStatut("enattente"); 
DaoTicket.save( DaoTicket.findById(id).get()) ;
String Statut = DaoTicket.findById(id).get().getStatut() ;
VariableDTO8 Stat = new VariableDTO8();
Stat.setValue(Statut);
Stat.setType("string");
DtoCamundaTicketTask8 varcamundatask8 = new  DtoCamundaTicketTask8() ;
varcamundatask8.setStatut(Stat);
MainVarDTO8 vardto8 = new  MainVarDTO8() ;
vardto8.setVariables(varcamundatask8);	   
String ProcessId =   DaoTicket.findById(id).get().getIdProcess() ;
String idTask8=StartuserTask( ProcessId) ;
Completeusertask8(idTask8, vardto8);
return vardto8 ;	       
 }
 
 
 
 
 

public void deleteByID(Long id) {
	DaoTicket.deleteById(id);
}

public void deleteALL() {
	DaoTicket.deleteAll();
}
   
 
   public TicketM updateTicket(TicketM t) {
       return DaoTicket.saveAndFlush(t);
   }
  
   

	

}
