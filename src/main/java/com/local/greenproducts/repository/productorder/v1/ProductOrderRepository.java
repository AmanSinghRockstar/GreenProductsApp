package com.local.greenproducts.repository.productorder.v1;

import org.springframework.data.repository.CrudRepository;

import com.local.greenproducts.model.productorder.v1.ProductOrder;

public interface ProductOrderRepository extends CrudRepository<ProductOrder, Long> {

}
