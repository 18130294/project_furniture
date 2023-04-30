package com.example.furniture.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.furniture.model.Cart;
import com.example.furniture.model.Invoice;
import com.example.furniture.model.InvoiceDetail;
import com.example.furniture.model.Product;
import com.example.furniture.model.Users;
import com.example.furniture.repositories.InvoiceDetailRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class CheckOutController {
	@Autowired
	private InvoiceDetailRepository invoiceDetailRepository;
	@PostMapping("check_out")
	public ModelAndView checkout(ModelMap modelMap,HttpSession session,@RequestParam("diachi") String diachi) {
		Users user = (Users) session.getAttribute("account");
		Cart cart =(Cart) session.getAttribute("cart");
		InvoiceDetail invoiceDetail ;
		if(user==null) {
			modelMap.addAttribute("mess", "Vui lòng đăng nhập");
			return new ModelAndView("redirect:/show_account_page",modelMap);
		}
		else {
			if(diachi==null||diachi=="") {
				modelMap.addAttribute("mess", "Vui lòng nhập địa chỉ");

				return new ModelAndView("redirect:/DisplayCart",modelMap);
			}
			Date date = new Date();
			String maHD =""+(date.getTime()/99);
			Invoice invoice = new Invoice(maHD,user.getIdUser() ,diachi, user.getSdt(), new Timestamp(new Date().getTime()), "Thanh toán khi nhận hàng");
			TreeMap<Product, Integer> list =cart.getListProduct();
			System.out.println("List cart"+list.size());
			for(Map.Entry<Product, Integer> ds:list.entrySet()) {
				invoiceDetail = new InvoiceDetail((int)(date.getTime()/100), invoice.getIdOrder(), ds.getKey().getIdProduct(), ds.getValue(), ds.getKey().getPrice(), "Đang xử lý",ds.getKey().getPrice()*ds.getValue(), user.getNameUser());
				invoiceDetailRepository.save(invoiceDetail);
				
			}

			
		}
		session.removeAttribute("cart");
		return new ModelAndView("redirect:/home");
	}

}
