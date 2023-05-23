package com.example.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.furniture.model.Users;
import com.example.furniture.repositories.UserRepository;

import com.example.furniture.sendmail.EmailServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmailController {
	@Autowired
	EmailServiceImpl emailServiceImpl;
	 @Autowired 
	 private UserRepository userRepository;
    // Sending a simple Email
    @PostMapping("/sendMail")
    public ModelAndView sendMail(HttpSession session, HttpServletRequest request, ModelMap modelMap)
    {
    	String email = request.getParameter("emailDN");
    	//xử lý email đã đăng ký hay chưua
    	Users user = userRepository.findByEmail(email);
    	System.out.println("user "+user);
        String status= emailServiceImpl.sendSimpleMail(email,user.getPass(),"Your Pass For COZA STORE");
        System.out.println(status);
		modelMap.addAttribute("messDK", "Password đã gửi qua email của bạn");
        return new ModelAndView("redirect:/show_account_page",modelMap);
    }
 
//     Sending email with attachment
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(
//        @RequestBody EmailDetails details)
//    {
//        String status
//            = emailService.sendMailWithAttachment(details);
// 
//        return status;
//    }
}
