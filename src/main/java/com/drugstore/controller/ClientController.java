package com.drugstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping(value = "{id}")
	public ResponseEntity<ClientDTO> getById(@PathVariable Integer id) {
		Client client = service.getById(id);
		return ResponseEntity.ok().body(new ClientDTO(client));

	}

	@PutMapping(value = "{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @RequestBody ClientDTO obj) {
		ClientDTO clientDTO = service.update(id, obj);

		return ResponseEntity.ok().body(clientDTO);

	}

	@PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO obj) {

		return ResponseEntity.ok().body(service.insert(obj));

	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
