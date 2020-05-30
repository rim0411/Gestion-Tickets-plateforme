package com.user.dto;

import java.io.Serializable;

public class DtoCamundaTicketTask7 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VariableDTO7 statut ;

	public static long getSerialversionuid() { 
		return serialVersionUID;
	}


	public VariableDTO7 getStaut() {
		return statut;
	}

	public void setStatut(VariableDTO7 satisfait) {
		this.statut = satisfait;
	}


}
