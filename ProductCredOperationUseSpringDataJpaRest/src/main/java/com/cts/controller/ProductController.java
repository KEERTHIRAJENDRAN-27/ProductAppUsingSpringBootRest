package com.cts.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;
 
@RestController
@RequestMapping("/products") // http://localhost:1234/products

public class ProductController {
	@Autowired
	ProductService service;
 
	// @RequestMapping(value="/getMsg",method=RequestMethod.GET)
	@GetMapping("/getMsg") // http://localhost:1234/products/getMsg
	public String sayHello() {
		return "am trying to listen but am getting sleep";
	}
 
	@PostMapping("/saveproduct") // http://localhost:1234/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}
 
	@PutMapping("/updateproduct") // http://localhost:1234/products/updateproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
 
	@GetMapping("/getproduct/{pid}") // http://localhost:1234/products/getproduct/1
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
 
	@DeleteMapping("/removeproduct/{pid}") // http://localhost:1234/products/removeproduct/1
	@ResponseBody
	public String removeProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
 
	@GetMapping("/getallproducts") // http://localhost:1234/products/getallproducts
	public List<Product> fetchProducts() {
		return service.getAllProducts();
	}
 
	@GetMapping("/getallproductsbetween/{price1}/{price2}") // http://localhost:1234/products/getallproductsbetween/2000/10000
	public List<Product> getAllProductsBetween(@PathVariable("price1") int intialPrice,
			@PathVariable("price2") int finalPrice) {
		return service.findByProductsBetween(intialPrice, finalPrice);
	}
 
	@GetMapping("/getallproductsbycategory/{category}") // http://localhost:1234/products/getallproductsbycategory/electronics
	public List<Product> fetchProductByCategory(@PathVariable("category") String category) {
		return service.findByProductsByCategory(category);
	}
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}
 
}


//package com.cts.controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cts.model.Product;
//import com.cts.service.ProductService;
//
//@RestController  // along with controller and rest
//@RequestMapping("/products") // http://localhost:1234/products
//public class ProductController {
//	@Autowired
//	ProductService service;
//
//	@GetMapping("/getMsg") // http://localhost:1234/products/getMsg
//	public String sayHello() {
//		return "am trying to listen but am getting sleep";
//	}
//
//	@PostMapping("/saveproduct") // http://localhost:1234/products/saveproduct
//	public String insertProduct(@RequestBody Product product) {
//		return service.saveProduct(product);
//	}
//}


//instead of request mapping   -> get mapping
//by default get is a request type