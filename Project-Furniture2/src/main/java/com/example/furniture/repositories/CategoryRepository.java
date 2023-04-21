package com.example.furniture.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.furniture.model.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
	//trương khóa chính nên là String
	
}
