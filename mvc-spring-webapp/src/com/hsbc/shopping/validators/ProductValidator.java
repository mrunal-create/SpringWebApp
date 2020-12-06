  
package com.hsbc.shopping.validators;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hsbc.shopping.models.Product;
@Component
public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product=(Product) target;
		if(product.getDop().isAfter(LocalDate.now()))
		{
			System.out.println("Error"+product.getDop().toString());
			errors.rejectValue("dop", "Date Error", new Object[]{"'dop'"}, 
					"Purchase Date can't be future value");
		}
		
		
	}

}