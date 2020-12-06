package com.hsbc.shopping.dao;

import java.util.List;

import com.hsbc.shopping.models.Product;

public interface ProductDao {

	
	boolean addProduct(Product p);
	List<Product> getAllProducts();
	
}
