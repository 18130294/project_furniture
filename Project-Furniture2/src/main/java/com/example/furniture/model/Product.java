package com.example.furniture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="product")
public class Product implements Comparable<Product> {
	@Id
	@Column(name ="idProduct")
	private int idProduct;
	private String idCategory;
	private String idSubCategories;
	private String nameProduct;
	private long price;
	private String images;
	private int soluongtrongkho;
	private String describes;
	
	public Product() {
		
	}
	public Product(int idProduct, String idCategory, String idSubCategories, String nameProduct, long price,
			String images, int soluongtrongkho, String describes) {
		super();
		this.idProduct = idProduct;
		this.idCategory = idCategory;
		this.idSubCategories = idSubCategories;
		this.nameProduct = nameProduct;
		this.price = price;
		this.images = images;
		this.soluongtrongkho = soluongtrongkho;
		this.describes = describes;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}
	public String getIdSubCategories() {
		return idSubCategories;
	}
	public void setIdSubCategories(String idSubCategories) {
		this.idSubCategories = idSubCategories;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public int getSoluongtrongkho() {
		return soluongtrongkho;
	}
	public void setSoluongtrongkho(int soluongtrongkho) {
		this.soluongtrongkho = soluongtrongkho;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", idCategory=" + idCategory + ", idSubCategories=" + idSubCategories
				+ ", nameProduct=" + nameProduct + ", price=" + price + ", images=" + images + ", soluongtrongkho="
				+ soluongtrongkho + ", describes=" + describes + "]";
	}
	@Override
	public int compareTo(Product o) {
		return this.idProduct-o.idProduct;
	}
	
	
}
