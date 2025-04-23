package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "products_info")     
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {           

	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message="product name can't be NULL or BLANK") //white space not allowed
	private String productName;
	@Column(name = "price")
	@Min(value=100 , message="product price must be above 100")
	@Max(value=100000 , message="product price must be below 1 lack ")
	private int productPrice;
	@Size(min=5,max=12,message="product category level between(5,12)")
	private String productCategory;
	@Column(name = "quantity")
	@Positive(message="Quantity cannot be Zero or -ve")
	private int productQuantity;
	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}
//	public Product() {}
	
}

//@NotNull  -> its check null value is there or not
//@NotEmpty -> check blank will allowed

//not mandatory => @Table @Column
//mandatory => @Entity @Id
//place cursor on table + ctrl => we get info
//@Entity -> table create automatically
//select pid,price from products_info : MySQL-> column name table name        
//select :  JPQL [java persistence query language] -> Variable name class name  

