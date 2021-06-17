package com.ost.ho.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ost.ho.model.Drug;

@Repository
public interface DrugSearchDAO  {

 public List<Drug> getDrugs(String drugName);
 public List<Drug> getaLLDrug();
 
}
