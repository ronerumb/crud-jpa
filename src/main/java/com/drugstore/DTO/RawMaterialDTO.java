package com.drugstore.DTO;

import com.drugstore.entities.RawMaterial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RawMaterialDTO {
	
	@NotBlank(message = "Campo name não pode ser em branco")
	@NotNull(message = "Campo nome não pode ser nullo")
	private String name;
	private String note;	
	@NotNull(message = "Campo nome não pode ser nullo")
	private float stock;
	
	public RawMaterialDTO() {
		
	}

	public RawMaterialDTO(RawMaterial obj) {
		super();
		this.name = obj.getName();
		this.note = obj.getNote();
		this.stock = obj.getStock();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "RawMaterialDTO [name=" + name + ", note=" + note + ", stock=" + stock + "]";
	}
	

}
