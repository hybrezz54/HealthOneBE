package com.ost.ho.model;


public class DrugSearch {
	

	private String caseId;
	
	private String primaryId;
	
	
	private String drug_name;
	
	
	private String roleCode;
	
	private String sex;
	
	private Integer age;
	
	
	private String occrCountry;
	
	private String reportedCountry;
	
	private String indicationPt;
	
	private String outcome;
	
	private String reactionPt;
	
	private String rand_state;
	
	private String max_depth;
	
	

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getPrimaryId() {
		return primaryId;
	}

	public void setPrimaryId(String primaryId) {
		this.primaryId = primaryId;
	}

	public String getDrug_name() {
		return drug_name;
	}

	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOccrCountry() {
		return occrCountry;
	}

	public void setOccrCountry(String occrCountry) {
		this.occrCountry = occrCountry;
	}

	public String getReportedCountry() {
		return reportedCountry;
	}

	public void setReportedCountry(String reportedCountry) {
		this.reportedCountry = reportedCountry;
	}

	public String getIndicationPt() {
		return indicationPt;
	}

	public void setIndicationPt(String indicationPt) {
		this.indicationPt = indicationPt;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getReactionPt() {
		return reactionPt;
	}

	public void setReactionPt(String reactionPt) {
		this.reactionPt = reactionPt;
	}

	public String getRand_state() {
		return rand_state;
	}

	public void setRand_state(String rand_state) {
		this.rand_state = rand_state;
	}

	public String getMax_depth() {
		return max_depth;
	}

	public void setMax_depth(String max_depth) {
		this.max_depth = max_depth;
	}

	@Override
	 public String toString() {
		return "DrugName:"+drug_name+" Outcome:"+outcome+" max_depth:"+max_depth+" rand state:"+rand_state;
	}
}
