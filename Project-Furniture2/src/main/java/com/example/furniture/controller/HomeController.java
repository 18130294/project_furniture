
	package com.example.furniture.controller;

	import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	//http:localhost:8080/home
	public class HomeController {
		@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
		private CategoryRepository categoryRepository;
		@Autowired
		private SubCategoryRepository subCategoryRepository;
		@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
		private ProductRepository productRepository;

		
		@RequestMapping(value = "home",method = RequestMethod.GET)
		//return name of jsp file
		
		public String getAllCategoriesAndProduct(ModelMap modelMap,HttpServletRequest request) {
			//ModelMap là để gửi dữ liệu từ database lên
			List<Category> categories = categoryRepository.findAll();
			List<SubCategory> subCategories = subCategoryRepository.findAll();
			//tinh phan bao nhieu trang
			long count =productRepository.count();
			long endPage =count/5;//Tính hiển thị bao nhiêu trang
			if(count%5!=0) {
				endPage++;
			}
			String indexPage = request.getParameter("indexPage");
			if(indexPage==null) {
				indexPage="1";
			}
				int index = Integer.parseInt(indexPage);
			Pageable pageable = PageRequest.of(index-1, 5);//index la chỉ số trang hiện tại, 5 là lấy ra 5 sản phâm,
//			index -1 bởi vì PageRequest.of lấy từ vị trí 0
			Page<Product> pagedResult = productRepository.findAll(pageable);
			List<Product> list = pagedResult.getContent();
			

			modelMap.addAttribute("endPage", endPage);
			modelMap.addAttribute("categories",categories);
			modelMap.addAttribute("subCategories",subCategories);
			modelMap.addAttribute("indexActive", index);
			modelMap.addAttribute("product",list);
			
			return "index";
		}
		
}
