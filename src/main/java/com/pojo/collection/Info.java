package com.pojo.collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
	
	private String name;
	private String Schema;
	
	public Info() {
		
	}
	
	
	public Info(String name, String schema) {
		this.name = name;
		Schema = schema;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchema() {
		return Schema;
	}
	public void setSchema(String schema) {
		Schema = schema;
	}
	
	
	

}
