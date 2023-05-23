
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.furniture.model.Cart;
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
		@Autowired
		private InvoiceDetailRepository invoiceDetailRepository;
		@Autowired
		private UserRepository userRepository;
		
		@RequestMapping(value = "home",method = RequestMethod.GET)
		//return name of jsp file
		
		public String getAllCategoriesAndProduct(ModelMap modelMap,HttpServletRequest request) {
			//ModelMap là để gửi dữ liệu từ database lên
			List<Category> categories = categoryRepository.findAll();
			List<SubCategory> subCategories = subCategoryRepository.findAll();
//			//tinh phan bao nhieu trang
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
//			List<Product> list = productRepository.findAll();
			List<Product> list = pagedResult.getContent();
			

			modelMap.addAttribute("endPage", endPage);
			modelMap.addAttribute("categories",categories);
			modelMap.addAttribute("subCategories",subCategories);
			modelMap.addAttribute("indexActive", index);
			modelMap.addAttribute("product",list);
			
			return "index";
		}
		@GetMapping("user_infor")
		public String userInfor(ModelMap modelMap,HttpSession session) {
			Users user = (Users) session.getAttribute("account");
			
			modelMap.addAttribute("user", user);
			
			return "user_infor";
		}
		@GetMapping("order_manage")
		public String order_manage(ModelMap modelMap,HttpSession session) {
			Users user = (Users) session.getAttribute("account");
			List<Product> listPro = new ArrayList<>();
			List<InvoiceDetail> listInvoiceByUser = invoiceDetailRepository.findByNameUser(user.getNameUser());
			for(InvoiceDetail p :listInvoiceByUser) {
				System.out.println("Invoice:" +p);
				Product a = productRepository.findByIdProduct(p.getIdProduct());
				listPro.add(a);
			}
			
			modelMap.addAttribute("listInvoiceByUser", listInvoiceByUser);
			modelMap.addAttribute("listPro", listPro);
			
			return "order_manage";
		}
		@PostMapping("update_infor")
		public ModelAndView update_Infor(ModelMap modelMap,HttpSession session,HttpServletRequest request) {
			String nameUser = request.getParameter("nameUser");
			String email = request.getParameter("email");
			String sdt = request.getParameter("sdt");
			String diachi = request.getParameter("diachi");

			Users user = (Users)session.getAttribute("account");
			user.setNameUser(nameUser);
			user.setEmail(email);
			user.setSdt(sdt);
			user.setDiachi(diachi);
			session.setAttribute("account", user);
			userRepository.save(user);
			return new ModelAndView("redirect:/user_infor");
		}
		@GetMapping("cancelOrder")
		public ModelAndView cancelOrder(ModelMap modelMap,HttpSession session,HttpServletRequest request,@RequestParam("idInvoice") Integer idInvoice) {
			
			invoiceDetailRepository.deleteById(idInvoice);
			return new ModelAndView("redirect:/order_manage");
		}
		
}
