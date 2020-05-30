package com.user.dto;

import java.io.Serializable;

public class DtoCamundaTicket implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private  VariableDTO titre ;
private  VariableDTO description ;
private VariableDTO label ; 


public VariableDTO getTitre() {
	return titre;
}
public void setTitre(VariableDTO titre) {
	this.titre = titre;
}
public VariableDTO getDescription() {
	return description;
}
public void setDescription(VariableDTO description) {
	this.description = description;
}
public VariableDTO getLabel() {
	return label;
}
public void setLabel(VariableDTO label) {
	this.label = label;
}
public static long getSerialversionuid() { 
	return serialVersionUID;
}

	


}
