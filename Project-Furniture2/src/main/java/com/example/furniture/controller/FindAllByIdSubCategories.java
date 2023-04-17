package com.example.furniture.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.furniture.model.Category;
import com.example.furniture.model.Product;
import com.example.furniture.model.SubCategory;
import com.example.furniture.repositories.CategoryRepository;
import com.example.furniture.repositories.ProductRepository;
import com.example.furniture.repositories.SubCategoryRepository;

@Controller
public class FindAllByIdSubCategories {
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private ProductRepository productRepository;

	@GetMapping("/productsubCate")
	public String getProBySubCate(ModelMap modelMap,@RequestParam("idSubCate") String idSubCate) {
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("subCategories",subCategories);
		
		List<Product> product = productRepository.findAllByIdSubCategories(idSubCate);
		System.out.println(product.size());
		for(Product p :product) {
		System.out.println("Sanppppppppppp"+p.toString());
		}
		modelMap.addAttribute("product",product);
		return "index";
	}
}
