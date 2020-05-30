package com.user.dto;

import java.io.Serializable;

public class DtoCamundaTicketTask6 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VariableDTO6 satisfait ;

	public static long getSerialversionuid() { 
		return serialVersionUID;
	}


	public VariableDTO6 getSatisfait() {
		return satisfait;
	}

	public void setSatisfait(VariableDTO6 satisfait) {
		this.satisfait = satisfait;
	}


}
