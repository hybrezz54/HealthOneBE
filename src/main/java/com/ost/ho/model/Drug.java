package com.ost.ho.model;

import java.io.Serializable;


public class Drug implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1122012945453315314L;

	//private HealthOneId healthOneId;
	
	private String drugName;
	private long primaryId;
	
	private long caseId;
	
	
	
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

	@Override
	public String toString() {
		return "Primary Id "+primaryId+" DrugName "+drugName;
	}

	/*
	 * public HealthOneId getHealthOneId() { return healthOneId; }
	 * 
	 * public void setHealthOneId(HealthOneId healthOneId) { this.healthOneId =
	 * healthOneId; }
	 */

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	

	
	
	
	
	

}
