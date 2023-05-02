package com.example.furniture.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.furniture.model.Category;
import com.example.furniture.model.Product;
import com.example.furniture.model.SubCategory;
import com.example.furniture.model.Users;
import com.example.furniture.repositories.CategoryRepository;
import com.example.furniture.repositories.ProductRepository;
import com.example.furniture.repositories.SubCategoryRepository;
import com.example.furniture.repositories.UserRepository;

@Controller


public class AdAddProduct {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("adminadd")
	public String addToCart(ModelMap modelMap) {
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		List<Product> product1 = productRepository.findAll();
		modelMap.addAttribute("categories", categories);
		modelMap.addAttribute("subCategories", subCategories);

		modelMap.addAttribute("product", product1);
		return "ad_addproduct";
	}
	
	@PostMapping(path="addpradmin")
	public ModelAndView addProductSus(ModelMap modelMap, @RequestParam("id") int id, @RequestParam("name") String name,  @RequestParam("soluong") int soluong,
			@RequestParam("describes") String describes, @RequestParam("price") int price, @RequestParam("namesc") String namesc, @RequestParam("img") String img) {
		Product pr = new Product();
		SubCategory sc = new SubCategory();
		double priced = (double) price;
		List<Product> listpr = productRepository.findAll();
		List<SubCategory> listsc =subCategoryRepository.findAll();
		Product check = pr.checkProduct(listpr, id);
		SubCategory checkid= sc.checkSubCategory(listsc, namesc);
		if(check == null) {
			Product pr1 = new Product(id, checkid.getIdcategories(),checkid.getIdSubcategory() , name, price,img, soluong, describes);
			productRepository.save(pr1);
			System.out.println("So tai khoan" +userRepository.count());
			
		}else {
			modelMap.addAttribute("messDK", "id san pham da ton tai");
			return new ModelAndView("redirect:/adminadd",modelMap);
		}
		
		
		return new ModelAndView("redirect:/adminadd",modelMap);
		
	}
}