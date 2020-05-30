package com.gestionticket.dto;

import java.io.Serializable;

public class DtoCamundaTicketTask3 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VariableDTO3 statut ;
	
	public VariableDTO3 getStatut() {
		return statut;
	}
	
	public void setStatut(VariableDTO3 statut) {
		this.statut = statut;
	}
	public static long getSerialversionuid() { 
		return serialVersionUID;
	}
	

}
