package com.local.greenproducts.service.productorder.v1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.local.greenproducts.model.customer.v1.Customer;
import com.local.greenproducts.model.product.v1.Product;
import com.local.greenproducts.model.productorder.v1.ProductOrder;
import com.local.greenproducts.model.productorder.v1.ProductOrderKafkaMessage;
import com.local.greenproducts.repository.productorder.v1.ProductOrderRepository;
import com.local.greenproducts.service.customer.v1.CustomerService;
import com.local.greenproducts.service.product.v1.ProductService;

@Service
public class ProductOrderService {

	@Autowired
	private ProductOrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private KafkaTemplate<String, ProductOrderKafkaMessage> kafkaTemplate;
	
	@Value(value = "${kafka.topic.name}")
	private String topicName;
	
	public Iterable<ProductOrder> getAllOrders() { 
		return orderRepository.findAll();
	}
	
	public ProductOrder getOrderById(Long id) {
		Optional<ProductOrder> productOptional = orderRepository.findById(id);
		
		if (productOptional.isEmpty())
			throw new IllegalArgumentException("No Product found for ID: " + id);
		
		return orderRepository.findById(id).get();
	}
	
	public ProductOrder createOrder(Product product, Customer customer) {
		ProductOrder order = new ProductOrder();
		order.setProduct(product);
		order.setCustomer(customer);
		
		orderRepository.save(order);
		
		return order;
	}
	
	public ListenableFuture<SendResult<String, ProductOrderKafkaMessage>> pushOrderToKafka(Long productId, Long customerId) {
		ProductOrderKafkaMessage kafkaMessage = new ProductOrderKafkaMessage();
		kafkaMessage.setProductId(productId);
		kafkaMessage.setCustomerId(customerId);
		
		Message<ProductOrderKafkaMessage> message = MessageBuilder
    			.withPayload(kafkaMessage)
    			.setHeader(KafkaHeaders.TOPIC, topicName)
    			.build();
		
		return kafkaTemplate.send(message);
	}
	
	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
	public void processProductOrderFromKafka(ProductOrderKafkaMessage productOrderKafkaMessage) {
		Product product = productService.getProductById(productOrderKafkaMessage.getProductId());
		Customer customer = customerService.getCustomerById(productOrderKafkaMessage.getCustomerId());
		
		createOrder(product, customer);
	}
}
