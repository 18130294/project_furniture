package com.example.furniture.model;



import org.springframework.stereotype.Controller;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//POJO

@Entity
@Table(name ="categories")//Tên bảng trong csdl
public class Category {
	@Id
	@Column(name ="idCategories")//Khi nào tên cột khác với tên bảng thì thêm dòng này
	private String idCategories;
	private String nameCategories;
	
	public Category() {
		
	}
	public Category(String idCategories, String nameCategories) {
		this.idCategories = idCategories;
		this.nameCategories = nameCategories;
	}

	public String getIdCategories() {
		return idCategories;
	}
	
	public void setIdCategories(String idCategories) {
		this.idCategories = idCategories;
	}
	public String getNameCategories() {
		return nameCategories;
	}
	public void setNameCategories(String nameCategories) {
		this.nameCategories = nameCategories;
	}
	@Override
	public String toString() {
		return "Category [idCategories=" + idCategories + ", nameCategories=" + nameCategories + "]";
	}
	
	
}
