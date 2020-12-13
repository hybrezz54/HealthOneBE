package com.ost.ho.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ost.ho.model.DrugSearch;
import com.ost.ho.model.DrugSearchResult;

@Repository
public interface DrugService {
	public DrugSearchResult drugSearch(DrugSearch drugSearch) throws Exception;
}
