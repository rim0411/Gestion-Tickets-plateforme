package com.gestionticket.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestionticket.models.label;
import com.gestionticket.services.labelService;

@CrossOrigin(origins="*")
@RequestMapping("/label")
@RestController
public class LabelController {
	@Autowired
	labelService service ;

	@PostMapping("/add")
public label	addlabel(@RequestBody label label){
		return service.save(label);
		
	}
	@GetMapping("/getlabelbyname/{name}")
	public label	getlabel(@PathVariable String name){
			return service.findbyName(name);
			
		}
	@GetMapping("/getlabels")
	public List<String>	getlabels(){
		List<label> labels = new ArrayList<label>();
		 List<String> listenames = new ArrayList<String>();
		 labels=service.findAll() ;
	 for(label label: labels){
		 String name=  label.getName();
		 listenames.add(name);
		
		}
	return listenames ;	}
}
