package com.example.furniture.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.furniture.model.Category;
import com.example.furniture.model.Product;
import com.example.furniture.model.SubCategory;
import com.example.furniture.repositories.CategoryRepository;
import com.example.furniture.repositories.ProductRepository;
import com.example.furniture.repositories.SubCategoryRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SearchByAjaxController {
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private CategoryRepository categoryRepository;
	@Autowired
	private SubCategoryRepository subCategoryRepository;
	@Autowired //inject ="categoryRepository"==>kỹ thuật Dependency injection
	private ProductRepository productRepository;
	
	@GetMapping("search")
	public void search(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

		String search = request.getParameter("txt");
		System.out.println(search);
		//ModelMap là để gửi dữ liệu từ database lên
		List<Category> categories = categoryRepository.findAll();
		List<SubCategory> subCategories = subCategoryRepository.findAll();
		
		List<Product> list = productRepository.findByNameProductContainingIgnoreCase(search);
		
		System.out.println("List search" +list.size());
		PrintWriter out = response.getWriter();
        for (Product o : list) {
            out.println("<div class=\"col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women\">"
            		+ "					<!-- Block2 -->"
            		+ "					"
            		+ "					<div class=\"block2\">"
            		+ "					"
            		+ "						<div class=\"block2-pic hov-img0\">"
            		+ "						"
            		+ "						<a href=\"DetailProductController?idDetailProduct="+o.getIdProduct()+"\"><img src=\"images/img/"+o.getImages()+"\" alt=\"IMG-PRODUCT\"></a>"
            		+ ""
            		+ "							<a href=\"Cart?command=insertItem&product_id="+o.getIdProduct()+"\" class=\"block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04\">"
            		+ "								Add To Cart"
            		+ "							</a>"
            		+ "						</div>"
            		+ ""
            		+ "						<div class=\"block2-txt flex-w flex-t p-t-14\">"
            		+ "							<div class=\"block2-txt-child1 flex-col-l \">"
            		+ "								<a href=\"product-detail.html\" class=\"stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6\">"
            		+ "									"+o.getNameProduct()+""
            		+ "								</a>"
            		+ ""
            		+ "								<span class=\"stext-105 cl3\">"
            		+ "									"+o.getPrice()+""
            		+ "								</span>\r\n"
            		+ "							</div>\r\n"
            		+ ""
            		+ "							<div class=\"block2-txt-child2 flex-r p-t-3\">"
            		+ "								<a href=\"#\" class=\"btn-addwish-b2 dis-block pos-relative js-addwish-b2\">"
            		+ "									<img class=\"icon-heart1 dis-block trans-04\" src=\"images/icons/icon-heart-01.png\" alt=\"ICON\">"
            		+ "									<img class=\"icon-heart2 dis-block trans-04 ab-t-l\" src=\"images/icons/icon-heart-02.png\" alt=\"ICON\">"
            		+ "								</a>"
            		+ "							</div>"
            		+ "						</div>"
            		+ "						"
            		+ "					</div>"
            		+ "					"
            		+ "								</div>");
        }

		modelMap.addAttribute("categories",categories);
		modelMap.addAttribute("subCategories",subCategories);
		modelMap.addAttribute("product",list);

	}
}
