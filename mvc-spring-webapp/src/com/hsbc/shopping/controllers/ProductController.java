package com.hsbc.shopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hsbc.shopping.models.Product;
import com.hsbc.shopping.services.ProductService;
import com.hsbc.shopping.validators.ProductValidator;

@Controller
public class ProductController {
   //autowiring will create object of productvalidator
	@Autowired
	private ProductValidator validator;
	//inject service
	@Autowired
	private ProductService d;
	
	@GetMapping("/")
	public ModelAndView home()
	{
		//controller has to return the home page///request came from webapplicationinitializer 
		//method 1 whcih we had done was showing home page first
		//return new ModelAndView("home","product",new Product());  //you are returning which model your view page should return //
		return new ModelAndView("viewproduct","productlist",d.getAllProducts()); 
		//method 2;;;first viewproduct page is shown..so product list is returned...then after that if you click on add product then it goes to home page and lets you add products
	}
	@GetMapping("/showProductForm")
	public ModelAndView showProductForm()   //coming from viewproduct.jsp
	{
		//part of method 2...after you clicj add prodyucts ...you view home.jsp which lets you add products// 
		return new ModelAndView("home","product",new Product());   //you are returning which model your view page should return //
	}
	
	//create method for addproduct  //controller receives model attributes from jsp//
	@PostMapping("/addProduct")
	public ModelAndView addProduct(@ModelAttribute("product") @Validated Product product ,BindingResult result,Model model)
	{
	ModelAndView modelandview=null;
		if(product!=null)
		{
			System.out.println(product.getDop());
			validator.validate(product, result);
			//validator will return result,,,you pass product
			
	
		if(result.hasErrors())
			
			modelandview=new ModelAndView("home");
		else
		{
			
		    if(d.addProduct(product))     //call goes to service
		    {
		// this result returned from service should goo to view page//
		modelandview=new ModelAndView("viewproduct","productlist",d.getAllProducts());
		    }  
		    //if succesfullly added then product list returned//to viewproduct
				/*
				 * else { modelandview=new
				 * ModelAndView("viewproduct","productlist","REcord not Added"); }
				 */
		}
				
		}
		return modelandview;
		
	}
	//if product is added it will go to viewproduct else goes back to same page which is home page//
}
