package com.local.greenproducts.model.productorder.v1;

import com.local.greenproducts.model.customer.v1.CustomerContract;

public class ProductOrderContract {
	
	private Long productId;
	
	private CustomerContract customer;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public CustomerContract getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerContract customer) {
		this.customer = customer;
	}
}
