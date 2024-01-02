package com.pojo.collection;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Collection {
	Info info;
	List<Item> item;
	
	public Collection() {
		
	}
	

	public Collection(Info info, List<Item> item) {
		super();
		this.info = info;
		this.item = item;
	}


	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	

	

}
