package com.local.greenproducts.service.product.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.greenproducts.model.product.v1.Product;
import com.local.greenproducts.model.product.v1.ProductType;
import com.local.greenproducts.repository.product.v1.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> getAllProducts() { 
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		
		if (productOptional.isEmpty())
			throw new IllegalArgumentException("No Product found for ID: " + id);
		
		return productRepository.findById(id).get();
	}
	
	public Product createProduct(String name, ProductType productType, String productDescription) {
		Product product = new Product();
		product.setName(name);
		product.setType(productType);
		product.setProductDescription(productDescription);
		
		productRepository.save(product);
		
		return product;
	}
}
