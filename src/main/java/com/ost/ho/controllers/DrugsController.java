package com.ost.ho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ost.ho.daos.DrugSearchDAO;
import com.ost.ho.model.Drug;
import com.ost.ho.model.DrugSearch;
import com.ost.ho.model.DrugSearchResult;
import com.ost.ho.pojo.User;
import com.ost.ho.service.DrugService;

@RestController
public class DrugsController {
	
	@Autowired
	DrugSearchDAO drugSearchDAO;
	
	@Autowired
	DrugService drugService;
	
	@RequestMapping(value="drugs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> DrugsSearchByName(@RequestParam String drugname) {
		ResponseEntity<?> entity = null;
		List<Drug> drugList = null;
		try {
			drugList = drugSearchDAO.getDrugs(drugname);
			entity = new ResponseEntity<List<Drug>>(drugList, HttpStatus.OK);
			System.out.println(entity);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		
		
		//return new ResponseEntity<List<Drug>>(drugList, HttpStatus.OK);
		return entity;
	}
	
	@PostMapping(value="drug/search")
	public ResponseEntity<?> DrugSearch(@RequestBody DrugSearch drugSearch) {
		
		ResponseEntity<?> entity = null;
		try {
			DrugSearchResult result = drugService.drugSearch(drugSearch);
			entity = new  ResponseEntity<DrugSearchResult>(result, HttpStatus.OK);
			System.out.println(entity.getBody());
		}catch(Exception ex) {
			System.out.println(ex);
			entity = new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		//return new ResponseEntity<List<Drug>>(drugList, HttpStatus.OK);
		return entity;
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
