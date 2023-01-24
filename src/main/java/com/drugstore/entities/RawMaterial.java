package com.drugstore.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rawmaterial")
public class RawMaterial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String note;
	private float stock;
	
	public RawMaterial() {
		
	}

	public RawMaterial(Integer id, String name, String note, float stock) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.stock = stock;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RawMaterial other = (RawMaterial) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "RawMaterial [id=" + id + ", name=" + name + ", note=" + note + ", stock=" + stock + "]";
	}
	
	
	
	
}
