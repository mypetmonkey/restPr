package com.pojo;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


 //@JsonInclude(JsonInclude.Include.NON_NULL)
 //@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class Workspace {
    //@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	@JsonIgnore
    public int i;
	public String name;
	public String type;
    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonIgnore
	private HashMap<String,String> hs=new   HashMap<String, String>();
	public String description;
   @JsonInclude(JsonInclude.Include.NON_NULL)
	public String id;
	
	public Workspace(String name, String type, String description) {
		this.name = name;
		this.type = type;
		this.description = description;
	}
	
	
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public HashMap<String, String> getHs() {
		return hs;
	}

	public void setHs(HashMap<String, String> hs) {
		this.hs = hs;
	}

	public Workspace() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
