package com.ost.ho.pojo;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name="queries")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryMap {
	private Map<String,Query> queryMap;

	public Map<String, Query> getQueryMap() {
		return queryMap;
	}

	public void setQueryMap(Map<String, Query> queryMap) {
		this.queryMap = queryMap;
	}
	 
}
