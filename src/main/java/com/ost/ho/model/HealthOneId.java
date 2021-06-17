package com.ost.ho.model;

import java.io.Serializable;


public class HealthOneId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6543617721127622427L;
	
	private long primaryId;
	private long caseId;
	
	public HealthOneId() {
		
	}
	
	public String toString() {
		return "PrimaryId "+primaryId+" CaseId "+caseId;
	}

	public long getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(long primaryId) {
		this.primaryId = primaryId;
	}

	public long getCaseId() {
		return caseId;
	}

	public void setCaseId(long caseId) {
		this.caseId = caseId;
	}
	
	
}
