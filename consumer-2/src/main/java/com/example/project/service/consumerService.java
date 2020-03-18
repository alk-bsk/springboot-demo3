package com.example.project.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.project.Inventory;
import com.example.project.config;

@Service
public class consumerService {
	
	 @LoadBalanced
	  private RestTemplate restTemplate=new RestTemplate();

	@SuppressWarnings("unchecked")
	public List<Inventory> getProduct() {
		List<Inventory> listInv =  (List<Inventory>) restTemplate.getForObject("http://localhost:8077", Object.class);
		return listInv;
	}

	public Inventory getProductById(int id) {
		// TODO Auto-generated method stub
		Inventory inventory = (Inventory) restTemplate.getForObject("http://localhost:8077/"+id, Inventory.class);
		return inventory;
	}

	public ResponseEntity<String> createProduct(Inventory product) {
		// TODO Auto-generated method stub
		ResponseEntity<String> inventory = restTemplate.postForEntity("http://localhost:8077/create", product,String.class);
		return inventory;
	}
		

}
