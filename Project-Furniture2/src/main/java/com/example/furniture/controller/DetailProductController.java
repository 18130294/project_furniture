package com.example.furniture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.furniture.model.Category;
import com.example.furniture.model.Product;
import com.example.furniture.model.SubCategory;
import com.example.furniture.repositories.CategoryRepository;
import com.example.furniture.repositories.ProductRepository;
import com.example.furniture.repositories.SubCategoryRepository;

@Controller
public class DetailProductController {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@RequestMapping(value = "DetailProductController",method = RequestMethod.GET)
	public String getDetailProduct(ModelMap modelMap, @RequestParam("idDetailProduct") Integer idProduct ) {
		//ModelMap là để gửi dữ liệu từ database lên
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		Product pro = productRepository.getReferenceById(idProduct);
		modelMap.addAttribute("idDetailProduct", pro);
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("subCategories",subCategories);
		return "productDetail";
	}
	
}
