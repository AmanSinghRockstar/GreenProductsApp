package com.local.greenproducts.api.ui.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.greenproducts.model.ui.v1.BaseUiPage;
import com.local.greenproducts.model.ui.v1.OrderForm;
import com.local.greenproducts.model.ui.v1.OrderTable;
import com.local.greenproducts.service.product.v1.ProductService;
import com.local.greenproducts.service.productorder.v1.ProductOrderService;

@RestController
@RequestMapping("/")
public class UiController {
	private static final String HEADER = "Green Products";
	private static final String SUBHEADER = "Welcome to the future";
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductOrderService productOrderService;
	
	@GetMapping("/index")
	public ResponseEntity<String> renderHomePage() {
		BaseUiPage page = BaseUiPage.builder()
				.withHead()
				.withStyle(BaseUiPage.getDefaultStyle())
				.withBody()
				.withHeading(HEADER)
				.withSubHeading(SUBHEADER)
				.withProductsMenu(productService.getAllProducts())
				.withContentHeading("Home")
				.withContentPageSection("Welcome to the future, future brought closer by GREEN PRODUCTS.")
				.withContentPageSection("At GREEN PRODUCTS, we're always striving to go ahead, rise and shine, never to look back.")
				.withContentPageSection("Feel free to look around, explore our products and come closer to what's ahead for humanity.")
				.build();
		
		return ResponseEntity.ok().body(page.getContent());
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<String> renderProductPage(@PathVariable("id") Long id) {
		BaseUiPage page = BaseUiPage.builder()
				.withHead()
				.withStyle(BaseUiPage.getDefaultStyle())
				.withBody()
				.withHeading(HEADER)
				.withSubHeading(SUBHEADER)
				.withProductsMenu(productService.getAllProducts())
				.withContentHeading(productService.getProductById(id).getName())
				.withContentPageSection(productService.getProductById(id).getProductDescription())
				.build();
		
		return ResponseEntity.ok().body(page.getContent());
	}

	@GetMapping("/orders")
	public ResponseEntity<String> renderOrderPage() {
		OrderForm createOrderForm = new OrderForm("/api/v1/productorder/create", "createOrderForm", productService.getAllProducts());
		OrderTable currentOrderTable = new OrderTable(productOrderService.getAllOrders());
		
		BaseUiPage page = BaseUiPage.builder()
				.withHead()
				.withStyle(BaseUiPage.getDefaultStyle())
				.withScript("https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js", true)
				.withScript(createOrderForm.getScript(), false)
				.withBody()
				.withHeading(HEADER)
				.withSubHeading(SUBHEADER)
				.withProductsMenu(productService.getAllProducts())
				.withContentHeading("Orders")
				.withContentPageSection(createOrderForm.toString(), "New Order")
				.withContentPageSection(currentOrderTable.toString(), "Current Orders")
				.build();
		
		return ResponseEntity.ok().body(page.getContent());
	}
}
