package com.drugstore.DTO;

import java.util.List;

import com.drugstore.entities.Client;

public class OrderDTO {
	
	private List<Integer> rawMaterial;
	private Integer client;
	
	public OrderDTO() {
		
	}

	public OrderDTO(List<Integer> rawMaterial,Integer client) {
		super();
		this.rawMaterial = rawMaterial;
		this.client = client;
	}
	
	

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}

	public List<Integer> getRawMaterial() {
		return rawMaterial;
	}

	public void setRawMaterial(List<Integer> rawMaterial) {
		this.rawMaterial = rawMaterial;
	}


	

}
