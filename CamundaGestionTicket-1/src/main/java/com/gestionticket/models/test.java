package com.gestionticket.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
@Entity
@Table(name="dddqq")
public class test {

	public test() {} ;
	@GeneratedValue(strategy = GenerationType.AUTO,  generator="seq_ticket")
	@Id
	private long id ;
	private String actionafaire;
	// @CreatedDate
	  @CreationTimestamp
	//  @Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dateDecreation ;
	  public LocalDateTime getDateDecreation() {
		return dateDecreation;
	}
	public void setDateDecreation(LocalDateTime dateDecreation) {
		this.dateDecreation = dateDecreation;
	}
	@PrePersist
	  public void addTimestamp() {
	 Date   createdAt = new Date();
	  }
	 @UpdateTimestamp
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "created_date")
	 private Date Date;
	private String description;
	private String titre ;
	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_label", referencedColumnName = "id")
	private label label ;
	
	@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "last_modified_date")
	    private Date lastModifiedDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		Date = date;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
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
	@OneToOne(fetch = FetchType.EAGER,targetEntity = userM.class, cascade=CascadeType.REMOVE)
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
