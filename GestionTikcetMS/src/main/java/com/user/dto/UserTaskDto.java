package com.user.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;

import org.hibernate.annotations.CreationTimestamp;

public class UserTaskDto implements  	Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	  private String processInstanceId;
	  private String taskDefinitionKey;
	  private String executionId;
	  private String name ;
	  private String assignee ;

	  @CreationTimestamp
	private Date created ;

	  public String getId() {
	    return id;
	  }

	  public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
	    this.id = id;
	  }

	  public String getProcessInstanceId() {
	    return processInstanceId;
	  }

	  public void setProcessInstanceId(String processInstanceId) {
	    this.processInstanceId = processInstanceId;
	  }

	  public String getTaskDefinitionKey() {
	    return taskDefinitionKey;
	  }

	  public void setTaskDefinitionKey(String taskDefinitionKey) {
	    this.taskDefinitionKey = taskDefinitionKey;
	  }

	  public String getExecutionId() {
	    return executionId;
	  }

	  public void setExecutionId(String executionId) {
	    this.executionId = executionId;
	  }
	  @PrePersist
	  public void addTimestamp() {
	 Date   createdAt = new Date();
	  }

	}



