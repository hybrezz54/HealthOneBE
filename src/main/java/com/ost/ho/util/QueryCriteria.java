package com.ost.ho.util;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.ost.ho.model.DrugSearch;

public class QueryCriteria {
	 
	String AND = "AND";
	
	 
	
	public static String getDynamicQuery(DrugSearch search) {
		
		String dynamicQuery = "";
		StringBuffer buf = new StringBuffer();
		HashMap<String, String> parameterMap = getParameterMap(search);
		String  searchSql = "select * from search_view sw where ";
		buf.append(searchSql);
		if(parameterMap != null && parameterMap.size() > 0) {
			if(parameterMap.containsKey("drugName")) {
				buf.append(" UPPER(sw.drugname) like UPPER('%'"+parameterMap.get("drugName")+"%') AND");
			}
		}
		buf.append(" rownum <= 500 order by sw.drug");
		
		return "";
	}
	
	private static HashMap<String, String> getParameterMap(DrugSearch drugSearch) {
		HashMap<String, String> parameterMap = new HashMap<String, String>();
		
		try {
			for(Field field: drugSearch.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				String name = field.getName();
				Object value = field.get(drugSearch);
				if(value != null && value.toString().length() > 0) {
					parameterMap.put(name, value.toString());
				}
			}
		}catch(Exception ex) {
			
		}
		return parameterMap;
	} 
}
