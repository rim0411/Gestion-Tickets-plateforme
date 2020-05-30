package com.camunda.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RestController;







/**
 * 
 * @param user
 * @throws MailException
 */
@RestController
public class NotifierUtilisateur implements JavaDelegate {
@Autowired
	 
	 JavaMailSender javaMailSender;
		
		public NotifierUtilisateur(JavaMailSender javaMailSender) {
			this.javaMailSender = javaMailSender;
		}


	  // TODO: Set Mail Server Properties
	//  private static final String HOST = "smtp.gmail.com";
	//  private static final String USER = "rim.zouary@gmail.com";
	 // private static final String PWD = "rimrami123";
	  
	  
	  
	
public void sendEmail(String useremail) throws MailException {
	
	

 
	SimpleMailMessage mail = new SimpleMailMessage();
	
	mail.setTo(useremail);
	mail.setSubject("Réponse à votre ticket ");
	mail.setText("Votre ticket a été traité! Veuillez visiter notre plateforme  ");

	/*
	 * This send() contains an Object of SimpleMailMessage as an Parameter
	 */
	javaMailSender.send(mail);
}



	@Override
	public void execute(DelegateExecution execution) throws Exception {
	String email=	(String)execution.getVariable("email") ;
		
		 sendEmail(email) ;
		 System.out.println("salut") ;
		
	
/*	String actions=(String)execution.getVariable("action") ;
	System.out.println("hello"+actions);
	Email email = new SimpleEmail();
      email.setCharset("utf-8");
      email.setHostName(HOST);
      email.setAuthentication(USER, PWD);


        email.setFrom("noreply@camunda.org");
        email.setSubject("Réponse a votre ticket: " );
        email.setMsg("ton ticket est traité veuillez se connecter à notre plateform et spécifier ta satisfaction" + actions);

        email.addTo("rim.zouary@gmail.com");

        email.send();*/
       

   
	}
	}



