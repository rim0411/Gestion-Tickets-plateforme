package com.user.dto;

import java.io.Serializable;

public class DtoCamundaTicketTask8 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VariableDTO8 statut ;

	public static long getSerialversionuid() { 
		return serialVersionUID;
	}


	public VariableDTO8 getStaut() {
		return statut;
	}

	public void setStatut(VariableDTO8 satisfait) {
		this.statut = satisfait;
	}


}
