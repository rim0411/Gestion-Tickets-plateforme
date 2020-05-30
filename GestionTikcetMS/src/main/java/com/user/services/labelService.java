package com.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.models.label;
import com.user.repositories.labelRepository;
@Service
public class labelService {
	@Autowired
    private labelRepository  daolabel;
	public label save(label label){
		return daolabel.save(label);
		
	}

}
