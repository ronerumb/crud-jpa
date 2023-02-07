package com.drugstore.entities;

import java.io.Serializable;

public class RawMaterialOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private float quantity;
	
	public RawMaterialOrder() {
		
	}

	public RawMaterialOrder(Integer id, float quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	
}
