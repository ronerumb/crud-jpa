package com.drugstore.DTO;

import com.drugstore.entities.Client;

public class ClientDTO {

	private String name;
	private String email;
	private String phone;
	private String address;
	
	public ClientDTO() {
		
	}

	public ClientDTO(Client obj) {
		
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.phone = obj.getPhone();
		this.address = obj.getAddress();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ClientDTO [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
	

}
