package com.drugstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drugstore.DTO.OrderDTO;
import com.drugstore.entities.Order;
import com.drugstore.service.OrderService;

@RestController
@RequestMapping(value = "orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO obj){
		
		
		return ResponseEntity.ok().body(service.insert(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(){
		return ResponseEntity.ok().body(service.getAll());
	}

}
