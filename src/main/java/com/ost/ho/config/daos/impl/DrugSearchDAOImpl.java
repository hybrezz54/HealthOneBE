package com.ost.ho.config.daos.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ost.ho.model.Drug;
import com.ost.ho.model.HealthOneId;
import com.ost.ho.util.QueryBean;
import com.sanctionco.thunder.ThunderBuilder;
import com.sanctionco.thunder.ThunderClient;
import com.sanctionco.thunder.models.User;
import com.ost.ho.config.daos.DrugSearchDAO;

@Repository("drugSearchDAO")
public class DrugSearchDAOImpl implements DrugSearchDAO {

	@Autowired
	JdbcTemplate hoJdbcTemplate;

	
	  @Autowired QueryBean queryBean;
	 

	
	  @Override 
	  public List<Drug> getDrugs(String drugName) { 
		  String sqlSelect = queryBean.getQuery("DrugSearchDAO.Drugquery"); 
		  drugName = drugName.toUpperCase(); 
			/*
			 * (rs, rownum) -> { Drug drug = new Drug();
			 * drug.setDrugName(rs.getString("drugname")); HealthOneId healthOneId = new
			 * HealthOneId(); healthOneId.setPrimaryId(rs.getLong("primaryid"));
			 * healthOneId.setCaseId(rs.getLong("caseid"));
			 * drug.setHealthOneId(healthOneId); return drug; }
			 */
	  
	  List<Drug> list = hoJdbcTemplate.query(sqlSelect, new Object[] { drugName},
	  (rs, rownum) -> {
	  
	  Drug drug = new Drug(); 
	  drug.setDrugName(rs.getString("drugname"));
	  drug.setCaseId(rs.getLong("caseid"));
	  drug.setPrimaryId(rs.getLong("primaryid")); return drug; });
	 // System.out.println("drug"+drug.);
	  return list; 
	  }
	 

	
	 /* public void connetToThunder() { ThunderClient tc = new
	  ThunderBuilder("http://localhost:8080", "application",
	  "secret").newThunderClient(); User user = tc.getUser("ahmed.khan@gmail.com",
	  "test"); 
	  */
	 // }
	 

}
