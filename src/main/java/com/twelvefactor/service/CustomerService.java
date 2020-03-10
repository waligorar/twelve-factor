package com.twelvefactor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twelvefactor.entity.Customer;
import com.twelvefactor.exception.CustomerNotFoundException;
import com.twelvefactor.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;


	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}
	
	public Customer getCustomerById(Long id) throws CustomerNotFoundException {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}
	
	public void saveOrUpdate(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void delete(long id) {
		customerRepository.deleteById(id);
	}
}
