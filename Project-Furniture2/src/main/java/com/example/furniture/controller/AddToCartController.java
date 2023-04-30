package com.example.furniture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.furniture.model.Cart;
import com.example.furniture.model.Category;
import com.example.furniture.model.Product;
import com.example.furniture.model.SubCategory;
import com.example.furniture.repositories.CategoryRepository;
import com.example.furniture.repositories.ProductRepository;
import com.example.furniture.repositories.SubCategoryRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AddToCartController {
	@Autowired 
	private ProductRepository productRepository;
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	
	
	@GetMapping("Cart")
	public ModelAndView addToCart(ModelMap modelMap,@RequestParam("product_id") Integer idProduct,HttpServletRequest request,HttpSession session,
			@RequestParam("command") String command ) {
		
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		List<Product> product1 = productRepository.findAll();
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("subCategories",subCategories);
	
		modelMap.addAttribute("product",product1);
		
		session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		String url ="redirect:/home";
			Product product =productRepository.findByIdProduct(idProduct);
			
		switch (command) {
		case "insertItem": 
			
				cart.insertToCart(product, 1);
				
			url="redirect:/home";
			break;
		case "addItem": //tang so luong
			
				cart.insertToCart(product, 1);
				
			url="cart";
			break;
		case "subItem": 
				cart.removeToCart(product, 1);		
		url="cart";
		break;
		case "removeItem": 
				cart.removeCart(product);
		url="cart";
		break;
		default:
			url="redirect:/home";
			break;
		}
return new ModelAndView(url);

		
		}



}
