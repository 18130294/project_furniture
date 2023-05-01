package com.example.furniture.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
	
//		@Query("select*from product where idSubcategory =: idSubCate")
	//@Param("idSubCate") String idSubCate
		public List<Product> findAllByIdSubCategories(String idSubcate);
		public Product findByIdProduct(Integer idProduct);
		public List<Product> findByNameProductContainingIgnoreCase(String txt);
//		@Query("SELECT * FROM product LIMIT 3")
//		public List<Product> find();




	
		

}
