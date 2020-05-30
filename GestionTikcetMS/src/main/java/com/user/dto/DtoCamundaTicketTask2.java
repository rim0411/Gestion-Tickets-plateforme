package com.user.dto;

import java.io.Serializable;

public class DtoCamundaTicketTask2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VariableDTO2 assigner ;
	

	public VariableDTO2 getAssigner() {
		return assigner;
	}


	public void setAssigner(VariableDTO2 assigner) {
		this.assigner = assigner;
	}


	public static long getSerialversionuid() { 
		return serialVersionUID;
	}

}
