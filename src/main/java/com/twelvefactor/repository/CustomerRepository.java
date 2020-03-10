package com.twelvefactor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twelvefactor.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
	
	Customer findById(long id);
}
