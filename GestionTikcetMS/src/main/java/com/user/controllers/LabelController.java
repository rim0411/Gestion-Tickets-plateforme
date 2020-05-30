package com.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.models.label;
import com.user.services.labelService;

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

}
