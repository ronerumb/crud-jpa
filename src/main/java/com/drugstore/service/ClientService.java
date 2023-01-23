package com.drugstore.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drugstore.DTO.ClientDTO;
import com.drugstore.entities.Client;
import com.drugstore.repository.ClientRepository;


@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<ClientDTO> getAll() {
		List<Client> client = clientRepository.findAll();
		List<ClientDTO> clientDTO = client.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		return clientDTO;

	}
	
	public ClientDTO insert(ClientDTO obj) {
	
		Client client = convertClient(obj);
		clientRepository.save(client);
		return obj;
		
	}
	
	public Client convertClient(ClientDTO obj) {
		Client client = new Client();
		client.setName(obj.getName());
		client.setEmail(obj.getEmail());
		client.setPhone(obj.getPhone());
		client.setAddress(obj.getAddress());
		return client;
		
	}

}
