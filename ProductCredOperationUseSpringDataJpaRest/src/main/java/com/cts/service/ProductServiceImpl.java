package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.ProductNotFound;
//import com.cts.ProductCredOperationUseSpringJpaApplication;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;
//import com.cts.repository.ProductRepositoryImpl;

@Service("productService")
public class ProductServiceImpl implements ProductService{

//    private final ProductCredOperationUseSpringJpaApplication productCredOperationUseSpringJpaApplication;
	
	Logger log= LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository repository;

//    ProductServiceImpl(ProductCredOperationUseSpringJpaApplication productCredOperationUseSpringJpaApplication) {
//        this.productCredOperationUseSpringJpaApplication = productCredOperationUseSpringJpaApplication;
//    }
	
//	public ProductServiceImpl() {
//		repository = new ProductRepositoryImpl();
//	}
	
	@Override
	public String saveProduct(Product product) {
		log.info("In ProductRepositoryImpl saveProduct method...");
		Product pro = repository.save(product);
		if(pro!=null)
			return "Product saved successfully";
		else
			return "Something went Wrong";
	}

	@Override
	public Product updateProduct(Product product) {
		Product pro = repository.save(product);
		return pro;
	}

	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "Product Deleted";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound{
		Optional<Product> optional = repository.findById(productId);
		if(optional.isPresent())
		  return optional.get();
		else
			throw new ProductNotFound("Product ID is invalid");
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> findByProductsBetween(int initialPrice, int finalPrice) {
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> findByProductsByCategory(String category) {
		return repository.findByProductCategory(category);
	}

	
//	@Override
//	public List<Product> findByProductsByPriceRange(int price) {
//		return repository.findByProductsByPriceRange(price);
//	}
	
}
