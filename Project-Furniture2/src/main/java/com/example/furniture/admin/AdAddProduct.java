package com.example.furniture.admin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    @Value("${upload.dir}")
    private String uploadDir;
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
	
	@PostMapping(path="savepr")
	public ModelAndView addProductSus(ModelMap modelMap, @RequestParam("id") int id, @RequestParam("name") String name,  @RequestParam("soluong") int soluong,
			@RequestParam("describes") String describes, @RequestParam("price") int price, @RequestParam("namesc") String namesc, @RequestParam("img") MultipartFile img) {
		Product pr = new Product();
		SubCategory sc = new SubCategory();
		double priced = (double) price;
		List<Product> listpr = productRepository.findAll();
		List<SubCategory> listsc =subCategoryRepository.findAll();
		Product check = pr.checkProduct(listpr, id);
		SubCategory checkid= sc.checkSubCategory(listsc, namesc);
		String fileName = StringUtils.cleanPath(img.getOriginalFilename());
		try {
			 Path path = Paths.get(uploadDir + fileName);
	            Files.copy(img.getInputStream(), path);
	           
		} catch (Exception e) {
			 e.printStackTrace();
		}
		if(check == null) {
			Product pr1 = new Product(id, checkid.getIdcategories(),checkid.getIdSubcategory() , name, price,
					fileName, soluong, describes);
			productRepository.save(pr1);
			System.out.println("So tai khoan" +userRepository.count());
			
		}else {
			modelMap.addAttribute("messDK", "id san pham da ton tai");
			return new ModelAndView("redirect:/adminadd",modelMap);
		}
		
		
		return new ModelAndView("redirect:/adminadd",modelMap);
		
	}
	@GetMapping("adhome")
	public String adHome(ModelMap modelMap) {
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		List<Product> product1 = productRepository.findAll();
		modelMap.addAttribute("categories", categories);
		modelMap.addAttribute("subCategories", subCategories);

		modelMap.addAttribute("product", product1);
		return "ad_home";
	}

	@RequestMapping(value = "Deletepr",method = RequestMethod.GET)
	public ModelAndView deletePr(ModelMap modelMap, @RequestParam("idDetailProduct") Integer id ) {
		 productRepository.deleteById(id);
		return new ModelAndView("redirect:/adhome",modelMap);
	}
}
