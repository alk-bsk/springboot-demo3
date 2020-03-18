package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.project.service.consumerService;

@RestController
public class inventorycontroller {
	
	@Autowired
	consumerService cs;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ResponseBody
	public List<Inventory> getProduct(){
		System.out.println("hello");
		//cs.getProduct();
		return cs.getProduct();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Inventory getProductById(@PathVariable("id") int id){
		System.out.println("test---"+id);
		//cs.getProductById(id);
		return cs.getProductById(id);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createProduct(@RequestBody Inventory product ){	
		return cs.createProduct(product);
	}
}