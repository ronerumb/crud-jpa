package com.drugstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drugstore.DTO.ClientDTO;
import com.drugstore.entities.Client;
import com.drugstore.repository.ClientRepository;
import com.drugstore.service.ClientService;

@RestController
@RequestMapping(value = "client")
public class ClientController {
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDTO>> getAll() {
		return ResponseEntity.ok().body(service.getAll());
	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO obj){		
		
		return ResponseEntity.ok().body(service.insert(obj));
		
	}

}
