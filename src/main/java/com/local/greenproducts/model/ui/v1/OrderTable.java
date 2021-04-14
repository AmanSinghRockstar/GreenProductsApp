package com.local.greenproducts.model.ui.v1;

import java.util.ArrayList;

import com.local.greenproducts.model.productorder.v1.ProductOrder;

public class OrderTable {
	private Iterable<ProductOrder> productOrders;

	public OrderTable() {
		this(new ArrayList<>());
	}
	
	public OrderTable(Iterable<ProductOrder> productOrders) {
		this.productOrders = productOrders;
	}
	
	@Override
	public String toString() {
		StringBuilder tableBuilder = new StringBuilder();
		
		tableBuilder.append("<TABLE>").append("\n")
			.append("<TBODY>").append("\n")
			.append("<TR>").append("\n")
			.append("<TH>").append("OrderID").append("</TH>").append("\n")
			.append("<TH>").append("ProductID").append("</TH>").append("\n")
			.append("<TH>").append("ProductName").append("</TH>").append("\n")
			.append("<TH>").append("ProductType").append("</TH>").append("\n")
			.append("<TH>").append("CustomerName").append("</TH>").append("\n")
			.append("</TR>").append("\n");
		
		productOrders.forEach(order -> {
			tableBuilder.append("<TR>").append("\n")
				.append("<TD>").append(order.getId()).append("</TD>").append("\n")
				.append("<TD>").append(order.getProduct().getId()).append("</TD>").append("\n")
				.append("<TD>").append(order.getProduct().getName()).append("</TD>").append("\n")
				.append("<TD>").append(order.getProduct().getType().toString()).append("</TD>").append("\n")
				.append("<TD>").append(order.getCustomer().getName()).append("</TD>").append("\n")
				.append("</TR>").append("\n");
		});
		
		tableBuilder.append("</TBODY>").append("</TABLE>").append("\n");
		return tableBuilder.toString();
	}
}
