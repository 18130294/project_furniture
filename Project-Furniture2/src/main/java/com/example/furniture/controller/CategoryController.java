
	package com.example.furniture.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.furniture.model.Category;
import com.example.furniture.model.SubCategory;
import com.example.furniture.repositories.CategoryRepository;
import com.example.furniture.repositories.SubCategoryRepository;

	@Controller
	@RequestMapping(path = "home")
	//http:localhost:8080/home
	public class CategoryController {
		@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
		private CategoryRepository categoryRepository;
		@Autowired
		private SubCategoryRepository subCategoryRepository;

		
		@RequestMapping(value = "",method = RequestMethod.GET)
		//return name of jsp file
		public String getAllCategories(ModelMap modelMap) {
			//ModelMap là để gửi dữ liệu từ database lên
			List<Category> categories = categoryRepository.findAll();
			List<SubCategory> subCategories = subCategoryRepository.findAll();
			modelMap.addAttribute("categories",categories);
			modelMap.addAttribute("subCategories",subCategories);

			
			return "login";
		}


}
