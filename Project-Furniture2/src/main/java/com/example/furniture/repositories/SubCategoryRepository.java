package com.example.furniture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.model.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, String> {
	

}
