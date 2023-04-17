package com.example.furniture.model;





import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ordersDetail")
public class InvoiceDetail {
	@Id
	private Integer idOrderDetail;
	private String idOrder;
	private Integer idProduct ;
	private int quantity ;
	private double price ;
	private String statuss;
	private double total;
	private String nameUser;
	
	public InvoiceDetail() {
		
	}
	public InvoiceDetail(Integer idOrderDetail, String idOrder, Integer idProduct, int quantity, double price,
			String statuss, double total, String nameUser) {
		super();
		this.idOrderDetail = idOrderDetail;
		this.idOrder = idOrder;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
		this.statuss = statuss;
		this.total = total;
		this.nameUser = nameUser;
	}
	@Override
	public String toString() {
		return "InvoiceDetail [idOrderDetail=" + idOrderDetail + ", idOrder=" + idOrder + ", idProduct=" + idProduct
				+ ", quantity=" + quantity + ", price=" + price + ", statuss=" + statuss + ", total=" + total
				+ ", nameUser=" + nameUser + "]";
	}
	public Integer getIdOrderDetail() {
		return idOrderDetail;
	}
	public void setIdOrderDetail(Integer idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatuss() {
		return statuss;
	}
	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
	
	
}
