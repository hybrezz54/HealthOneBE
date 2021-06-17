package com.ost.ho.util;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.ost.ho.pojo.Query;
import com.ost.ho.pojo.QueryMap;

@Component
public class QueryBean {
	QueryMap queryMap;
	HashMap<String, Query> queries;
	
	private static  String QUERIES_XML= "queries.xml";
	
	public QueryBean(HashMap<String, Query> queries) {
		this.queries = queries;
	}
	
	public QueryBean() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(QueryMap.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			File queriesFile = new File(getClass().getClassLoader().getResource(QUERIES_XML).getFile());
			this.queryMap = (QueryMap)jaxbUnmarshaller.unmarshal(queriesFile);
			this.queries = (HashMap<String, Query>)queryMap.getQueryMap();
		}catch(Exception ex) {
			System.out.println("Error=========="+ex);
			
			
		}
	}
	
	public String getQuery(String key) {
		Query query =(Query) queries.get(key);
		return query.getSql().trim();
	}

}
