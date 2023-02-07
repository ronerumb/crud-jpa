package com.drugstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drugstore.DTO.OrderDTO;
import com.drugstore.entities.Client;
import com.drugstore.entities.Order;
import com.drugstore.entities.RawMaterial;
import com.drugstore.entities.RawMaterialOrder;
import com.drugstore.exception.NotFoundException;
import com.drugstore.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private RawMaterialService rawMaterialService;

	public OrderDTO insert(OrderDTO obj) throws Exception{
		
		RawMaterial rm;
		List<RawMaterial> rawMaterial = new ArrayList<>();	
		
		for(RawMaterialOrder rmo : obj.getRawMaterial()) {
			
			rm = rawMaterialService.getById(rmo.getId());
			
			if(rm.getStock() >= rmo.getQuantity()) {
				rawMaterial.add(rm);
				rm.setStock(rm.getStock() - rmo.getQuantity());
			}else {
				throw new NotFoundException("Quantidade pedida maior que o estoque disponivel");
			}
			
			
		
		}
		Client client = clientService.getById(obj.getClient());
		Order order = new Order(null, rawMaterial,client);
		orderRepository.save(order);
		return obj;
					
	}
	
	public List<Order> getAll(){
		List<Order> orders = orderRepository.findAll();
		return orders;
	}

	public Order getById(Integer id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.orElseThrow(() -> new NotFoundException("Pedido não encontrado"));
	}

	public void delete(Integer id) {
		Order order = getById(id);
		orderRepository.delete(order);
		
	}
	
	
}
