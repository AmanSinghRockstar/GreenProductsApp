package com.local.greenproducts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.local.greenproducts.model.product.v1.ProductType;
import com.local.greenproducts.service.product.v1.ProductService;

@Configuration
public class ProductConfig {

	@Autowired
	private ProductService productService;
	
	@Bean
	public void initializeProducts() {
		productService.createProduct("Enigma SP-01", ProductType.ENIGMA, "Enigma SP-01 is world's first ENIGMA-solving AI, able to solve "
				+ "the same in as low as 3 secs at a competitive price.");
		productService.createProduct("Enigma SP-02", ProductType.ENIGMA, "Enigma SP-02 is the next iteration to the world-breaking Enigma SP-01, able to solve "
				+ "Enigma in as low as 2.5 secs, setting a new world record.");
		
		productService.createProduct("Vision Infinity-01", ProductType.VISION, "Inspired by the infinite expanse of the universe, Vision Infinity-01 "
				+ "aims to bring the wide expanse of the universe to your fingertips, letting you survey any corner of the universe in a matter"
				+ "of minutes.");
		productService.createProduct("Vision Infinity-02", ProductType.VISION, "Inspired by the infinite expanse of the universe, Vision Infinity-02"
				+ " is the second iteration to the world breaking Vision Infinity-01, "
				+ "aims to bring the wide expanse of the universe to your fingertips in a matter"
				+ "of seconds.");
	}
}
