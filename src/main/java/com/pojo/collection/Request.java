package com.pojo.collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
 
   private String method;
   private String description;
   
   public Request() {
	   
   }

public Request(String method, String description) {
	this.method = method;
	this.description = description;
}

public String getMethod() {
	return method;
}

public void setMethod(String method) {
	this.method = method;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


   
}
