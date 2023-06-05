package com.example.furniture.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("show_account_page")
	public String addToCart(ModelMap modelMap) {
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		List<Product> product1 = productRepository.findAll();
		modelMap.addAttribute("categories", categories);
		modelMap.addAttribute("subCategories", subCategories);

		modelMap.addAttribute("product", product1);
		return "account";
	}
	@PostMapping("login")
	public ModelAndView loginSuccess(ModelMap modelMap, HttpServletRequest request,HttpServletResponse response,HttpSession session, @RequestParam("emailDN") String emailDN,
			@RequestParam("passDN") String passDN) {
		
		Users user = new Users();
		List<Users> list = userRepository.findAll();
		Users userAcc = user.checkUserAccount(list, emailDN, passDN);
		if(emailDN==null||passDN==null) {
			modelMap.addAttribute("messDN", "Không được bỏ trống");
			return new ModelAndView("redirect:/show_account_page",modelMap);
		}
		else if(userAcc==null) {
			modelMap.addAttribute("messDN", "Email hoặc mật khẩu sai");
			return new ModelAndView("redirect:/show_account_page",modelMap);

		}
		else if(userAcc.getIsAdmin()==1) {
			return new ModelAndView("redirect:/adminhome", modelMap);
		}
		else {
			String rememberme = request.getParameter("rememberme");
			 session = request.getSession();
			session.setAttribute("account", userAcc);
			//Set cookie cho dang nhap
			Cookie userC = new Cookie("userCookie", emailDN);
			Cookie passC = new Cookie("passCookie", passDN);
			if(rememberme!=null) {//neu co ckeck vao remember thi se dien mat khau trong 1 phut
				userC.setMaxAge(60);//1 phut
				passC.setMaxAge(60);
			}
			else {
				passC.setMaxAge(0);
			}
			
			response.addCookie(userC);//luu u va p len chrome
			response.addCookie(passC);
		return new ModelAndView("redirect:/home");

		}
}
	@PostMapping("signup")
	public ModelAndView signupSuccess(ModelMap modelMap, @RequestParam("email") String email, @RequestParam("userName") String userName, @RequestParam("phone") String phone,
			@RequestParam("pass") String pass,@RequestParam("re_pass") String re_pass) {
		Users user = new Users();
		List<Users> list = userRepository.findAll();
		Users userSignUp = user.checkUser(list, email);
		if(userSignUp!=null) {
			modelMap.addAttribute("messDK", "Email đã đăng ký tài khoản");
			return new ModelAndView("redirect:/show_account_page",modelMap);
		}
		else {
			if(!pass.equalsIgnoreCase(re_pass)) {
				modelMap.addAttribute("messDK", "Hai mật khẩu không khớp");
				return new ModelAndView("redirect:/show_account_page",modelMap);
			}
			else {
				Date date = new Date();
				long number = date.getTime();
				String idUser =list.get(list.size()-1).getIdUser()+(number/100);
				
				Users user1 = new Users(idUser, email, phone, pass, userName, 0, null);
				userRepository.save(user1);
				System.out.println("So tai khoan" +userRepository.count());
				modelMap.addAttribute("messDK", "Đăng ký thành công!!!Vui lòng đăng nhập");
				return new ModelAndView("redirect:/show_account_page",modelMap);
			}
		}
		
	}
	@GetMapping("logout")
	public ModelAndView signupSuccess(ModelMap modelMap,HttpSession session,HttpServletRequest request) {
			session = request.getSession();
			session.invalidate();
			return new ModelAndView("redirect:/home");
	}
	@GetMapping("forgetPass")
	public String showPageForgetPass(ModelMap modelMap) {
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		List<Product> product1 = productRepository.findAll();
		modelMap.addAttribute("product", product1);

		modelMap.addAttribute("categories", categories);
		modelMap.addAttribute("subCategories", subCategories);
		return "forgetPassword";
}

}