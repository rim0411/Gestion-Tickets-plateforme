package com.gestionticket.dto;

import java.io.Serializable;

public class VariableDTO3 implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;
	private String type;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
