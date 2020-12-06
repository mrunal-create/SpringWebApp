package com.hsbc.shopping.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hsbc.shopping.models.Product;
//dao layer annotation
@Repository
public class ProductdaoImpl implements ProductDao{
//we will use jdbc template..spring uses that
	
	//jdbc templ will be injected/
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Override
	public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		boolean status=false;
		int result=jdbctemplate.update("insert into ADMIN.PRODUCT(PRODUCTID,NAME,DOP,UNITPRICE) values " + "(?,?,?,?)",p.getProductId(), p.getName(),Date.valueOf(p.getDop()),p.getUnitPrice());
		if(result>0)
		{
			status=true;
		}
		return status;
	}

	@Override
	public List<Product> getAllProducts() {
		
		
		return jdbctemplate.query("select * from ADMIN.PRODUCT", new BeanPropertyRowMapper<Product>(Product.class) );
		// TODO Auto-generated method stub
	//row by row it will be coppied to row 
	}

}
