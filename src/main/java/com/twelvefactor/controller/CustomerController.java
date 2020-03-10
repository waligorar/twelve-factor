package com.twelvefactor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twelvefactor.entity.Customer;
import com.twelvefactor.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping("/customer")
	private List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	private Customer getCustomer(@PathVariable("id") Long id) {
		logger.info("Get customer by ID: " + id);
		return customerService.getCustomerById(id);
	}
	
	@DeleteMapping("/customer/{id}")
	private void deleteCustomer(@PathVariable("id") Long id) {
		customerService.delete(id);
	}
	
	@PostMapping("/customer")
	private Long saveCustomer(@RequestBody Customer customer) {
		customerService.saveOrUpdate(customer);
		return customer.getId();
	}
	
}
