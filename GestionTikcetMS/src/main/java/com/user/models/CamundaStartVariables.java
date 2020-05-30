package com.user.models;

import javax.persistence.Entity;

//@Entity  
public class CamundaStartVariables {
private boolean saf ;
private String ticketid ;
public boolean isSaf() {
	return saf;
}
public void setSaf(boolean saf) {
	this.saf = saf;
}
public String getTicketid() {
	return ticketid;
}
public void setTicketid(String ticketid) {
	this.ticketid = ticketid;
}
}
