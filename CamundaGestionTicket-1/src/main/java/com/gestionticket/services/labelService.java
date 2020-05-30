package com.gestionticket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.gestionticket.models.label;
import com.gestionticket.repositories.labelRepository;
@Service
public class labelService {
	@Autowired
    private labelRepository  daolabel;
	public label save(label label){
		return daolabel.save(label);
		
	}
	public  label findbyName(String name){
		return daolabel.findByName(name);
		
	}
	public  List<label> findAll(){
		return daolabel.findAll();
		
	}

}
