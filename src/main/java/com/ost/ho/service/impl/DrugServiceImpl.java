package com.ost.ho.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.ost.ho.model.DrugSearch;
import com.ost.ho.model.DrugSearchResult;
import com.ost.ho.service.DrugService;

@Repository("drugService")
public class DrugServiceImpl implements DrugService {
	
	public static final String DTREEURL= "http://ec2-65-0-99-66.ap-south-1.compute.amazonaws.com:5001/getdtree";
	
	public static final String NEWDTREEURL= "http://ec2-52-66-247-71.ap-south-1.compute.amazonaws.com:5001/getNewDtree";

	@Override
	public DrugSearchResult drugSearch(DrugSearch drugSearch) throws Exception {
		//drugSearch.setMax_depth("3");
		String dName = drugSearch.getDrug_name().toUpperCase();
		drugSearch.setDrug_name(dName);
		double random = Math.random() * 1000;
		long randomNum= (long)random/5;
		drugSearch.setRand_state(""+randomNum);
		//drugSearch.getDrug_name().toUpperCase();
		System.out.println(drugSearch);
		RestTemplate restTemplate = new RestTemplate();
		
		DrugSearchResult result =  restTemplate.postForObject(NEWDTREEURL,
				drugSearch, DrugSearchResult.class);
		//HttpEntity<?> httpEntity = entity.getBody();
		//DrugSearchResult result =(DrugSearchResult) entity.getBody();
		//http://ec2-15-207-19-70.ap-south-1.compute.amazonaws.com:5001
		//
		//https://89db5cf6-e9b0-4c8d-9912-cd24dc416521.mock.pstmn.io
		return result;
	}

}
