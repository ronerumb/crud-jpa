package com.drugstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drugstore.DTO.OrderDTO;
import com.drugstore.entities.Order;
import com.drugstore.entities.RawMaterial;
import com.drugstore.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RawMaterialService rawMaterialService;

	public OrderDTO insert(OrderDTO obj){
		
		List<RawMaterial> rawMaterial = new ArrayList<>();		
		for(Integer id : obj.getRawMaterial()) {
			rawMaterial.add(rawMaterialService.getById(id));
		}
		Order order = new Order(null, rawMaterial);
		orderRepository.save(order);
		return obj;
					
	}
	
	public List<Order> getAll(){
		List<Order> orders = orderRepository.findAll();
		return orders;
	}
	
	
}
