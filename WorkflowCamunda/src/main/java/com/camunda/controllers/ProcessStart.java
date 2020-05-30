package com.camunda.controllers;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@RestController
public class ProcessStart {
	

	
@PostMapping("/startCamunda/{bk}")

public String StartProcess(@PathVariable String bk) throws JsonProcessingException{
ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
RuntimeService runtimeService = processEngine.getRuntimeService();
ProcessInstance instance=runtimeService.startProcessInstanceByKey("ticketm",bk);
String processInstanceId=instance.getId()  ; 
String bsk=instance.getBusinessKey() ; 
System.out.print(bsk+"bus");
return processInstanceId;
}

}
