package com.local.greenproducts.api.product.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.greenproducts.model.product.v1.Product;
import com.local.greenproducts.service.product.v1.ProductService;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/list")
	public ResponseEntity<Iterable<Product>> listAllProducts() {
		return ResponseEntity.ok().body(productService.getAllProducts());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> listProduct(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(productService.getProductById(id));
	}
}
