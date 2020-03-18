package com.example.flywaydb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flywaydb.Inventory;

import com.example.flywaydb.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;

	public List<Inventory> getProduct() {
		return (List<Inventory>) inventoryRepository.findAll();
	}

	public Inventory getProductById(int id) {
		// TODO Auto-generated method stub
		System.out.println("testing---"+inventoryRepository.findById(id).get());
		return inventoryRepository.findById(id).get();
	}

	public Inventory createProduct(Inventory product) {
		// TODO Auto-generated method stub
		return inventoryRepository.save(product);
	}

	public Inventory updateProduct(Inventory product) {
		// TODO Auto-generated method stub
		Inventory prod=inventoryRepository.findById(product.getProduct_Id()).get();
		prod.setProduct_Name(product.getProduct_Name());
		prod.setProduct_Category(product.getProduct_Category());
		prod.setFare(product.getFare());	
		return inventoryRepository.save(prod);
	}

	public boolean deleteProductById(int id) {
		// TODO Auto-generated method stub
		 inventoryRepository.deleteById(id);
		 return true;
	} 

	




}
