package com.drugstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drugstore.DTO.RawMaterialDTO;
import com.drugstore.entities.RawMaterial;
import com.drugstore.service.RawMaterialService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "rawmaterial")
public class RawMaterialController {
	@Autowired
	private RawMaterialService service;

	@GetMapping
	public ResponseEntity<List<RawMaterialDTO>> getAll() {
		return ResponseEntity.ok().body(service.getAll());
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<RawMaterialDTO> getById(@PathVariable Integer id) {
		RawMaterial rawMaterial = service.getById(id);
		return ResponseEntity.ok().body(new RawMaterialDTO(rawMaterial));

	}

	@PutMapping(value = "{id}")
	public ResponseEntity<RawMaterialDTO> update(@PathVariable Integer id, @RequestBody RawMaterialDTO obj) {
		RawMaterialDTO rawMaterialDTO = service.update(id, obj);

		return ResponseEntity.ok().body(rawMaterialDTO);

	}

	@PostMapping
	public ResponseEntity<RawMaterialDTO> insert(@RequestBody @Valid RawMaterialDTO obj) {

		return ResponseEntity.ok().body(service.insert(obj));

	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
