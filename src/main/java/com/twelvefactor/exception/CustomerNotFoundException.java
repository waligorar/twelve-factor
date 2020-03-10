package com.twelvefactor.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(Long id) {
		super("Could not find customer with ID: " + id);
	}

}
	
