/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gestionticket.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

public class ProcessInstanceDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Object links ;
  private String id;
  private String definitionId;
  private String businessKey;
  private String caseInstanceId;
  private boolean ended;
  private boolean suspended;
  private String tenantId;
  



 

  public String getId() {
	
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDefinitionId() {
    return definitionId;
  }

  public void setDefinitionId(String definitionId) {
    this.definitionId = definitionId;
  }

  public String getBusinessKey() {
    return businessKey;
  }

  public void setBusinessKey(String businessKey) {
    this.businessKey = businessKey;
  }

  public String getCaseInstanceId() {
    return caseInstanceId;
  }

  public void setCaseInstanceId(String caseInstanceId) {
    this.caseInstanceId = caseInstanceId;
  }

  public boolean isEnded() {
    return ended;
  }

  public void setEnded(boolean ended) {
    this.ended = ended;
  }

  public boolean isSuspended() {
    return suspended;
  }

  public void setSuspended(boolean suspended) {
    this.suspended = suspended;
  }

  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

}
