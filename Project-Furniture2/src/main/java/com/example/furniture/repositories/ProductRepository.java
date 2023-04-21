package com.example.furniture.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.furniture.model.Product;

import jakarta.transaction.Transactional;
public interface ProductRepository  extends JpaRepository<Product, Integer> {
	
//		@Query("select*from product where idSubcategory =: idSubCate")
	//@Param("idSubCate") String idSubCate
		public List<Product> findAllByIdSubCategories(String idSubcate);

	
		

}
