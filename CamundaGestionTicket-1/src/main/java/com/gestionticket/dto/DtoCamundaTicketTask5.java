package com.gestionticket.dto;

import java.io.Serializable;

public class DtoCamundaTicketTask5 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VariableDTO5 action ;
	private VariableDTO5 email ;
	

	

	public VariableDTO5 getEmail() {
		return email;
	}




	public void setEmail(VariableDTO5 email) {
		this.email = email;
	}




	public VariableDTO5 getAction() {
		return action;
	}




	public void setAction(VariableDTO5 action) {
		this.action = action;
	}




	public static long getSerialversionuid() { 
		return serialVersionUID;
	}

}
