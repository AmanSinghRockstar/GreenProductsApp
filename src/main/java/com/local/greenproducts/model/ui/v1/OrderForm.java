package com.local.greenproducts.model.ui.v1;

import java.util.ArrayList;
import java.util.List;

import com.local.greenproducts.model.product.v1.Product;

public class OrderForm {
	private static final String INPUT_FORMAT = "<INPUT type=\"input\" id=\"%s\" name=\"%s\"/><BR>";
	private static final String LABEL_FORMAT = "<LABEL for=\"%s\">%s</LABEL><BR>";
	private static final String BUTTON_FORMAT = "<INPUT type=\"button\" value=\"%s\" id=\"%s\"/><BR>";
	private static final String FORM_FORMAT = "<FORM id=\"%s\">";
	private static final String SELECT_FORMAT = "<SELECT id=\"%s\" name=\"%s\"/>";
	private static final String OPTION_FORMAT = "<OPTION value=\"%s\"/>";
	
	private List<String> formElements = new ArrayList<>();
	private String submitPath;
	private String id;
	private Iterable<Product> listOfProducts;
	
	public OrderForm(String submitPath, String id, Iterable<Product> listOfProducts) {
		this.submitPath = submitPath;
		this.id = id;
		this.listOfProducts = listOfProducts;
		
		addElements();
	}
	
	public String getScript() {
		String script = "$(\"document\").ready(function() {\r\n"
				+ "$(\"#placeOrderButton\").click(function() {\r\n"
				+ "var stringifiedData = JSON.stringify({\r\n"
				+ "				     \"productId\": $(\"#productId\").val(),\r\n"
				+ "				     \"customer\": {\r\n"
				+ "				         \"name\": $(\"#customerName\").val(),\r\n"
				+ "				         \"contactNumber\": $(\"#customerContactNumber\").val(),\r\n"
				+ "				         \"emailId\": $(\"#customerEmailId\").val()\r\n"
				+ "				     }\r\n"
				+ "				 });\r\n"
				+ "$.ajax({\r\n"
				+ "  type: \"POST\",\n"
				+ "  url: '"+ submitPath +"',\r\n"
				+ "  data: stringifiedData,\r\n"
				+ "  success: function() { alert(\"Order placed successfully.\"); location.reload(); },\r\n"
				+ "  error: function(jqXHR, textStatus) { alert(\"Order placement failed, status: \" + textStatus); },\r\n"
				+ "  contentType: 'application/json',\r\n"
				+ "  dataType: 'json'\r\n"
				+ "});\r\n"
				+ "});});";
		
		return script;
	}
	
	@Override
	public String toString() {
		StringBuilder formBuilder = new StringBuilder();
		formBuilder.append(String.format(FORM_FORMAT, id)).append("\n");
		
		for(String element : formElements) {
			formBuilder.append(element).append("\n");
		}
		
		formBuilder.append("</FORM>").append("\n");
		
		return formBuilder.toString();
	}
	
	private void addElements() {
		formElements.add(String.format(LABEL_FORMAT, "productId", "Product ID: "));
		formElements.add(getProductIdDropDown());
		formElements.add(String.format(LABEL_FORMAT, "customerName", "Name: "));
		formElements.add(String.format(INPUT_FORMAT, "customerName", "productName"));
		formElements.add(String.format(LABEL_FORMAT, "customerContactNumber", "Contact No.: "));
		formElements.add(String.format(INPUT_FORMAT, "customerContactNumber", "customerContactNumber"));
		formElements.add(String.format(LABEL_FORMAT, "customerEmailId", "Email ID: "));
		formElements.add(String.format(INPUT_FORMAT, "customerEmailId", "customerEmailId"));
		formElements.add(String.format(BUTTON_FORMAT, "Place Order", "placeOrderButton"));
	}
	
	private String getProductIdDropDown() {
		StringBuilder selectInputBuilder = new StringBuilder();
		selectInputBuilder.append(String.format(SELECT_FORMAT, "productId", "productId"));
		
		listOfProducts.forEach(product -> {
			selectInputBuilder.append(String.format(OPTION_FORMAT, product.getId()))
				.append(product.getName())
				.append("</OPTION>")
				.append("\n");
		});
		
		selectInputBuilder.append("</SELECT>").append("<BR>").append("\n");
		
		return selectInputBuilder.toString();
	}
}
