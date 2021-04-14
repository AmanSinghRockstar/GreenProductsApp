package com.local.greenproducts.repository.customer.v1;

import org.springframework.data.repository.CrudRepository;

import com.local.greenproducts.model.customer.v1.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
