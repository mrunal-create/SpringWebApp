package com.hsbc.shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsbc.shopping.dao.ProductDao;
import com.hsbc.shopping.models.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao d1;
	
	private boolean status;
	//controller->service->dao
public boolean addProduct(Product product)
{
	
	return d1.addProduct(product);      //call goes to dao
}
public  List<Product> getAllProducts()
{
	return d1.getAllProducts();
}
}
