package com.drugstore.DTO;

import java.util.List;

import com.drugstore.entities.RawMaterialOrder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;



public class OrderDTO {

	
	@NotNull(message = "Campo rawMaterial não pode ser nullo")
	private List<RawMaterialOrder> rawMaterial;	
	@NotNull(message = "Campo client não pode ser nullo")
	private Integer client;

	public OrderDTO() {

	}

	public OrderDTO(List<RawMaterialOrder> rawMaterial, Integer client) {
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

	public List<RawMaterialOrder> getRawMaterial() {
		return rawMaterial;
	}

	public void setRawMaterial(List<RawMaterialOrder> rawMaterial) {
		this.rawMaterial = rawMaterial;
	}

}
