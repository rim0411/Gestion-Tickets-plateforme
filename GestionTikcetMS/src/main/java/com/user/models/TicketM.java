package com.user.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="TicketM")
	@Table(uniqueConstraints = { 
			@UniqueConstraint(columnNames = "titre")
		})
public class TicketM {
	
	public TicketM() {} ;
	@GeneratedValue(strategy = GenerationType.AUTO,  generator="seq_ticket")
	@Id
	private long id ;
	private String actionafaire;
	
	 @UpdateTimestamp
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "created_date")
	 private Date Date;
	private String description;
	private String titre ;
	@NotNull
	@OneToOne(fetch = FetchType.EAGER, targetEntity = label.class )
	@JoinColumn(name="id_label", referencedColumnName = "id")
	private label label ;

	public label getLabel() {
		return label;
	}
	public void setLabel(label label) {
		this.label = label;
	}
	private String idProcess ;
	private String assigner;
	private String actionFaite;
	private String statut ;
	@NotNull
	@OneToOne(fetch = FetchType.EAGER, targetEntity = userM.class)
	@JoinColumn(name="id_user", referencedColumnName = "id")
	private userM user ;

 public String getIdProcess() {
		return idProcess;
	}
	public void setIdProcess(String idProcess) {
		this.idProcess = idProcess;
	}

	public String getActionafaire() {
		return actionafaire;
	}
	public void setActionafaire(String actionafaire) {
		this.actionafaire = actionafaire;
	}
	public String getAssigner() {
		return assigner;
	}
	public void setAssigner(String assigner) {
		this.assigner = assigner;
	}
	public String getActionFaite() {
		return actionFaite;
	}
	public void setActionFaite(String actionFaite) {
		this.actionFaite = actionFaite;
	}

	public long getId_ticket() {
		return id;
	}
	public void setId_ticket(long id_ticket) {
		this.id = id_ticket;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public userM getUser() {
		return user;
	}
	public void setUser(userM user) {
		this.user = user;
	}


	


}
