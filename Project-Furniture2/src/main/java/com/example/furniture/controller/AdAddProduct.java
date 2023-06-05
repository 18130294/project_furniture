package com.example.furniture.controller;

import java.nio.file.Files;



import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
import com.example.furniture.model.InvoiceDetail;
import com.example.furniture.model.Product;
import com.example.furniture.model.SubCategory;
import com.example.furniture.model.Users;
import com.example.furniture.repositories.CategoryRepository;
import com.example.furniture.repositories.InvoiceDetailRepository;
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
	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;
    @Value("${upload.dir}")
    private String uploadDir;
    @GetMapping("adminhome")
	public String showPageAdminHome(ModelMap modelMap) {
    	long sumUser = userRepository.count();	
    	long sumProduct = productRepository.count();
    	long sumInvoiceDetail = invoiceDetailRepository.count();
    	modelMap.addAttribute("sumUser",sumUser);
    	modelMap.addAttribute("sumProduct",sumProduct);
    	modelMap.addAttribute("sumInvoiceDetail",sumInvoiceDetail);

		return "ad_home";
	}
    @GetMapping("manage_product")
	public String showPageQLSP(ModelMap modelMap) {
		List<Product> product = productRepository.findAll();
		modelMap.addAttribute("product", product);
		return "quanLySanPham";
	}
    @GetMapping("formAddProduct")
	public String showFormAddProduct(ModelMap modelMap) {
    	List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		modelMap.addAttribute("categories", categories);
		modelMap.addAttribute("subCategories", subCategories);
		return "admin_add-san-pham";
	}
    
    
	@PostMapping(path="save_product")
	public ModelAndView save_product(ModelMap modelMap, @RequestParam("id") int id, @RequestParam("name") String name,  @RequestParam("soluong") int soluong,
			@RequestParam("describes") String describes, @RequestParam("price") long price, @RequestParam("namesc") String namesc, @RequestParam("img") MultipartFile img) {
		Product pr = new Product();
		SubCategory sc = new SubCategory();
		List<Product> listpr = productRepository.findAll();
		List<SubCategory> listsc =subCategoryRepository.findAll();
		Product check = pr.checkProduct(listpr, id);
		SubCategory checkid = sc.checkSubCategory(listsc, namesc);
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
			
		}else {
			modelMap.addAttribute("messDK", "id san pham da ton tai");
			return new ModelAndView("redirect:/formAddProduct",modelMap);
		}
		
		
		return new ModelAndView("redirect:/manage_product",modelMap);
		
	}
	 @PostMapping("deleteProduct")
		public ModelAndView deleteProduct(ModelMap modelMap,@RequestParam("id") int id) {
	    	Product pro = productRepository.findByIdProduct(id);
	    	productRepository.delete(pro);
			return new ModelAndView("redirect:/manage_product",modelMap);
		}
	 @GetMapping("showpageedit")
	 public String showPageEdit(ModelMap modelMap,@RequestParam("id") int id) {
	    	Product product = productRepository.findByIdProduct(id);
	    	List<Category> categories = categoryRepository.findAll();
			List<SubCategory> subCategories = subCategoryRepository.findAll();
			modelMap.addAttribute("categories", categories);
			modelMap.addAttribute("subCategories", subCategories);
	    	modelMap.addAttribute("product",product);
			return "ad_editProduct";
		}
	 @PostMapping("editProduct")
	 public ModelAndView editProduct(ModelMap modelMap,@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("price") long price,
			 @RequestParam("soluong")int soluong,@RequestParam("namesc") String namesc,@RequestParam("describes") String describes) {
	    	Product pro = productRepository.findByIdProduct(id);
	    	pro.setNameProduct(name);
	    	pro.setSoluongtrongkho(soluong);
	    	pro.setIdSubCategories(namesc);
	    	pro.setPrice(price);
	    	pro.setDescribes(describes);
	    	productRepository.save(pro);
			return new ModelAndView("redirect:/manage_product",modelMap);
		}
	 @GetMapping("CancelEditAndAddPro")
	 public ModelAndView cancelEdit() {
		 return new ModelAndView("redirect:/manage_product");
	 }
	 @GetMapping("manage_user")
	 public String showPageQLUSER(ModelMap modelMap) {
		 List<Users> listUser = new ArrayList<>();
		 List<Users> list = userRepository.findAll();
		 for(Users u: list) {
			 if(u.getIsAdmin()==0) {
				 listUser.add(u);
			 }
		 }
		 modelMap.addAttribute("list",listUser);
		 return "quanLyTaiKhoan";
	 }
	 @PostMapping("deleteUser")
	 public ModelAndView deleteUser(@RequestParam("idUser")String id) {
		 Users user = userRepository.getReferenceById(id);
		 userRepository.delete(user);
		 return new ModelAndView("redirect:/manage_user");
	 }
	 @GetMapping("manage_invoiceDetail")
	 public String show_page_QLDH(ModelMap modelMap) {
		 List<InvoiceDetail> listInvoice = invoiceDetailRepository.findAll();
		 modelMap.addAttribute("listInvoice", listInvoice);
		 return "quanLyDonHang";
	 }
	 @PostMapping("DeleteOrder")
	 public ModelAndView deleteOrder(@RequestParam("id") String id) {
		 InvoiceDetail invoiceDetail = invoiceDetailRepository.findByIdOrder(id);
		 invoiceDetailRepository.delete(invoiceDetail);
		 return new ModelAndView("redirect:/manage_invoiceDetail");
	 }
	 @GetMapping("show_page_editInvoice")
	 public String show_page_editinvoice(@RequestParam("id")String id,ModelMap modelMap) {
		 InvoiceDetail invoice = invoiceDetailRepository.findByIdOrder(id);
		 modelMap.addAttribute("invoice",invoice);
		 
	 return "ad_editOrder";
	 }
	 @PostMapping("editoder")
	 public ModelAndView editInvoice(@RequestParam("idHd")String idHd,@RequestParam("tinhtrang")String status) {
			 InvoiceDetail invoic = invoiceDetailRepository.findByIdOrder(idHd);
			 invoic.setStatuss(status);
			 invoiceDetailRepository.save(invoic);
			 return new ModelAndView("redirect:/manage_invoiceDetail");
		 }
	 
	 @GetMapping("cancelEditInvoice")
	 public ModelAndView cancelEditInvoice() {
		 return new ModelAndView("redirect:/manage_invoiceDetail");
	 }
	 }
	 
//	@GetMapping("adminhome")
//	public String adHome(ModelMap modelMap) {
//		List<Category> categories = categoryRepository.findAll();
//		List<SubCategory> subCategories = subCategoryRepository.findAll();
//		List<Product> product1 = productRepository.findAll();
//		modelMap.addAttribute("categories", categories);
//		modelMap.addAttribute("subCategories", subCategories);
//
//		modelMap.addAttribute("product", product1);
//		return "ad_home";
//	}
//
//	@RequestMapping(value = "Deletepr",method = RequestMethod.GET)
//	public ModelAndView deletePr(ModelMap modelMap, @RequestParam("idDetailProduct") Integer id ) {
//		 productRepository.deleteById(id);
//		return new ModelAndView("redirect:/adminhome",modelMap);
//	}
//	@RequestMapping(value = "Deletepr",method = RequestMethod.GET)
//	    public ResponseEntity<String> deletePr(@RequestParam("idDetailProduct") Integer id ) {
//	        // Xóa người dùng từ CSDL
//	        // ...
//	
//	        return ResponseEntity.ok("Người dùng đã được xóa thành công");
//	    }


