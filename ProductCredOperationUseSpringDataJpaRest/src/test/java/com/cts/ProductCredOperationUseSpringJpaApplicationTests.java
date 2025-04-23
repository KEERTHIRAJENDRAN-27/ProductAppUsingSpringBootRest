package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
import com.cts.repository.ProductRepository;
//import com.cts.service.ProductService;
import com.cts.service.ProductServiceImpl;

@SpringBootTest
class ProductCredOperationUseSpringJpaApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	@Mock
	ProductRepository repository;
	
	@InjectMocks
	ProductServiceImpl service;
	
	@Test
	void saveProductTest() {
		Product product = new Product("samsung",35000,"electronics",27);
		Mockito.when(repository.save(product)).thenReturn(product);
		String response= service.saveProduct(product);
		assertEquals("Product saved", response);
		
	}

	
}
