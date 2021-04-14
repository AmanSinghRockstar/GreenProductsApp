package com.local.greenproducts.repository.product.v1;

import org.springframework.data.repository.CrudRepository;

import com.local.greenproducts.model.product.v1.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
