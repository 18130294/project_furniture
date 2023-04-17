package com.example.furniture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping(path="Cart")
public class AddToCartController {
	@Autowired 
	private ProductRepository productRepository;
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@GetMapping
	public String addToCart(ModelMap modelMap,@RequestParam("product_id") Integer idProduct,HttpServletRequest request,HttpSession session,
			@RequestParam("command") String command) {
		
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		List<Product> product1 = productRepository.findAll();
		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("subCategories",subCategories);
	
		modelMap.addAttribute("product",product1);
		
		session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		ArrayList<Long> listBuy =null;
		String url ="cart";
		try {
			listBuy =(ArrayList<Long>)session.getAttribute("cartID");
			long idBuy =0;
			if(request.getParameter("cartID")!=null) {
				idBuy=Long.parseLong(request.getParameter("cartID"));
			}
			Product product =productRepository.getReferenceById(idProduct);
		switch (command) {
	
		case "insertItem": 
			if(listBuy==null) {
				listBuy=new ArrayList<Long>();
				session.setAttribute("cartID", listBuy);
				}
			if(listBuy.indexOf(idBuy)==-1) {
				cart.insertToCart(product, 1);
				listBuy.add(idBuy);
			}
			url="cart";
			break;
		case "addItem": //tang so luong
			if(listBuy==null) {
				listBuy=new ArrayList<Long>();
				session.setAttribute("cartID", listBuy);
				}
			if(listBuy.indexOf(idBuy)==-1) {
				cart.insertToCart(product, 1);
				listBuy.add(idBuy);
			}
			url="cart";
			break;
		case "subItem": 
			if(listBuy==null) {
				listBuy=new ArrayList<Long>();
				session.setAttribute("cartID", listBuy);
				}
			if(listBuy.indexOf(idBuy)==-1) {
				cart.removeToCart(product, 1);
				listBuy.add(idBuy);
			}
		url="cart";
		break;
		case "removeItem": 
				cart.removeCart(product);
		url="cart";
		break;
		default:
			url="cart";
			break;
		}
return url;

		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
		}



}
