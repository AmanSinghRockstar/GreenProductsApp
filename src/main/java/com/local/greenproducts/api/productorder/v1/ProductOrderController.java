package com.local.greenproducts.api.productorder.v1;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.greenproducts.model.customer.v1.Customer;
import com.local.greenproducts.model.product.v1.Product;
import com.local.greenproducts.model.productorder.v1.ProductOrder;
import com.local.greenproducts.model.productorder.v1.ProductOrderContract;
import com.local.greenproducts.service.customer.v1.CustomerService;
import com.local.greenproducts.service.product.v1.ProductService;
import com.local.greenproducts.service.productorder.v1.ProductOrderService;

@RestController
@RequestMapping("api/v1/productorder")
public class ProductOrderController {
	
	@Autowired
	private ProductOrderService orderService;
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/list")
	public ResponseEntity<Iterable<ProductOrder>> listAllOrders() {
		return ResponseEntity.ok().body(orderService.getAllOrders());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductOrder> listOrder(@PathVariable("id") Long id) {
		return ResponseEntity.ok().body(orderService.getOrderById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object> createOrder(@RequestBody ProductOrderContract order) throws InterruptedException, ExecutionException {
		String response = processProductOrderContract(order);
		return ResponseEntity.ok().body("{ \"topic\": \"" + response + "\"}");
	}
	
	private String processProductOrderContract(ProductOrderContract order) throws InterruptedException, ExecutionException {
		Customer customer;
		if (order.getCustomer().getId() != null)
			customer = customerService.getCustomerById(order.getCustomer().getId());
		else
			customer = customerService.createCustomer(
				order.getCustomer().getName(), 
				order.getCustomer().getContactNumber(), 
				order.getCustomer().getEmailId());
		
		Product product = productService.getProductById(order.getProductId());
		
		return orderService.pushOrderToKafka(product.getId(), customer.getId()).get().getRecordMetadata().topic();
	}
}
