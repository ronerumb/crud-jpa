package com.drugstore.DTO;

import java.util.List;

import com.drugstore.entities.RawMaterial;

public class OrderDTO {
	
	private List<Integer> rawMaterial;
	
	public OrderDTO() {
		
	}

	public OrderDTO(List<Integer> rawMaterial) {
		super();
		this.rawMaterial = rawMaterial;
	}

	public List<Integer> getRawMaterial() {
		return rawMaterial;
	}

	public void setRawMaterial(List<Integer> rawMaterial) {
		this.rawMaterial = rawMaterial;
	}


	

}
