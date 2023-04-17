package com.example.furniture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.furniture.model.Category;
import com.example.furniture.model.SubCategory;
import com.example.furniture.repositories.CategoryRepository;
import com.example.furniture.repositories.ProductRepository;
import com.example.furniture.repositories.SubCategoryRepository;

@Controller
@RequestMapping("DisplayCart")
public class DisplayCartController {
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private ProductRepository productRepository;
	public String displayCart(ModelMap modelMap) {
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("subCategories",subCategories);
		return "cart";
	}
}
