package com.local.greenproducts.service.customer.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.greenproducts.model.customer.v1.Customer;
import com.local.greenproducts.repository.customer.v1.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer getCustomerById(Long id) {
		Optional<Customer> productOptional = customerRepository.findById(id);
		
		if (productOptional.isEmpty())
			throw new IllegalArgumentException("No Customer found for ID: " + id);
		
		return customerRepository.findById(id).get();
	}
	
	public Customer createCustomer(String name, String contactNumber, String emailId) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setContactNumber(contactNumber);
		customer.setEmailId(emailId);
		
		customerRepository.save(customer);
		
		return customer;
	}
}
