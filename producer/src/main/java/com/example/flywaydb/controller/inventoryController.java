package com.example.flywaydb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flywaydb.Inventory;
import com.example.flywaydb.service.InventoryService;

@RestController
public class inventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public List<Inventory> getProduct(){
		
		return inventoryService.getProduct();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Inventory getProductById(@PathVariable("id") int id){
		System.out.println("hello----"+id);
		return inventoryService.getProductById(id);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public Inventory createProduct(@RequestBody Inventory product ){
		
		return inventoryService.createProduct(product);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	@ResponseBody
	public Inventory updateProduct(@RequestBody Inventory product){
		
		return inventoryService.updateProduct(product);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteProductById(@PathVariable("id") int id){
		
		return inventoryService.deleteProductById(id);
	}

}
