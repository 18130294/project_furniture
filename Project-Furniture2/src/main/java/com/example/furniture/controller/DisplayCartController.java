package com.example.furniture.controller;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

public class DisplayCartController {
		@Autowired
		private CategoryRepository categoryRepository;
		@Autowired
		private SubCategoryRepository subCategoryRepository;
		@Autowired
		private ProductRepository  productRepository;
		@RequestMapping(value="DisplayCart", method = RequestMethod.GET)
	public String displayCart(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
			List<Category> categories = categoryRepository.findAll();
			List<SubCategory> subCategories = subCategoryRepository.findAll();
			List<Product> product1 = productRepository.findAll();
			modelMap.addAttribute("product",product1);

			modelMap.addAttribute("categories",categories);
			modelMap.addAttribute("subCategories",subCategories);
			Cart cart = (Cart)session.getAttribute("cart");
		return "cart";
	}
	
}