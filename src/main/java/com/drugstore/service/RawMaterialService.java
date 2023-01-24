package com.drugstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drugstore.DTO.RawMaterialDTO;
import com.drugstore.entities.RawMaterial;
import com.drugstore.repository.RawMaterialRepository;


@Service
public class RawMaterialService {

	@Autowired
	private RawMaterialRepository rawMaterialRepository;

	public List<RawMaterialDTO> getAll() {
		List<RawMaterial> rawMaterial = rawMaterialRepository.findAll();
		List<RawMaterialDTO> rawMaterialDTO = rawMaterial.stream().map(x -> new RawMaterialDTO(x)).collect(Collectors.toList());
		return rawMaterialDTO;

	}

	public RawMaterial getById(Integer id) {

		Optional<RawMaterial> rawMaterial = rawMaterialRepository.findById(id);
		return rawMaterial.orElseThrow(() -> new RuntimeException("RawMaterial not found"));

	}

	public RawMaterialDTO insert(RawMaterialDTO obj) {

		RawMaterial rawMaterial = convertRawMaterial(obj);
		rawMaterialRepository.save(rawMaterial);
		return obj;

	}
	
	public RawMaterialDTO update(Integer id,RawMaterialDTO obj) {
		
		RawMaterial rawMaterial =  getById(id);
		rawMaterial = updateRawMaterial(obj, rawMaterial);
		rawMaterialRepository.save(rawMaterial);
		return obj;

	}

	public RawMaterial convertRawMaterial(RawMaterialDTO obj) {
		RawMaterial rawMaterial = new RawMaterial();
		rawMaterial.setName(obj.getName());
		rawMaterial.setNote(obj.getNote());
		rawMaterial.setStock(obj.getStock());		
		return rawMaterial;

	}
	
	public RawMaterial updateRawMaterial(RawMaterialDTO obj, RawMaterial rawMaterial) {
		rawMaterial.setName(obj.getName());
		rawMaterial.setNote(obj.getNote());
		rawMaterial.setStock(obj.getStock());		
		return rawMaterial;
		
	}
	
	public RawMaterialDTO delete(Integer id) {
		RawMaterial rawMaterial = getById(id);
		rawMaterialRepository.delete(rawMaterial);		
		return null;
		
	}

}
