package com.drugstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drugstore.DTO.OrderDTO;
import com.drugstore.entities.Order;
import com.drugstore.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody @Valid OrderDTO obj) throws Exception{
				
		return ResponseEntity.created(null).body(service.insert(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(){
		return ResponseEntity.ok().body(service.getAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Order> getById(@PathVariable Integer id){
		
		return ResponseEntity.ok().body(service.getById(id));
	}
	
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
