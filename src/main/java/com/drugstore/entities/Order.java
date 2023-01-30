package com.drugstore.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<RawMaterial> rawMaterial;
	
	@ManyToOne
	private Client client;
	
	public Order() {
		
		
	}

	public Order(Integer id, List<RawMaterial> rawMaterial,Client client) {
		super();
		this.id = id;
		this.rawMaterial = rawMaterial;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<RawMaterial> getRawMaterial() {
		return rawMaterial;
	}

	public void setRawMaterial(List<RawMaterial> rawMaterial) {
		this.rawMaterial = rawMaterial;
	}
	
	
	
	

}
