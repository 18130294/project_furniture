package com.example.furniture.model;
import java.util.TreeMap;
import java.util.Map;

public class Cart {
	private TreeMap<Product, Integer> listProduct;
	public Cart() {
		listProduct = new TreeMap<Product, Integer>();
	}
	public Cart(TreeMap<Product, Integer> listProduct) {
		this.listProduct = listProduct;
	}
	
	public TreeMap<Product, Integer> getListProduct() {
		return listProduct;
	}
	public void setListProduct(TreeMap<Product, Integer> listProduct) {
		this.listProduct = listProduct;
	}
	
	
	//them 
	public void insertToCart(Product p,int quantity) {
		boolean check=listProduct.containsKey(p);
		if(check==true) {
			int old_quantity=listProduct.get(p);
			quantity+=old_quantity;
			listProduct.put(p, quantity);
		}else {
			listProduct.put(p, quantity);
		}
	}
	public void updateToCart(Product p, int quantity) {
		boolean check=listProduct.containsKey(p);
		if(check==true) {
			if(quantity<=0) {
				listProduct.remove(p);
			}
			else {
				listProduct.remove(p);
				listProduct.put(p, quantity);
			}
		}
	}
	public void removeToCart(Product p,int quantity) {
		boolean check=listProduct.containsKey(p);
		if(check==true) {
			int old_quantity=listProduct.get(p);
			quantity =old_quantity -quantity;
			if(quantity<=0) {
				listProduct.remove(p);
			}else {
				listProduct.remove(p);
				listProduct.put(p, quantity);
			}
		}
	}
	public void removeCart(Product p) {
		boolean check=listProduct.containsKey(p);
		if(check==true) {
			listProduct.remove(p);
		}
	}
	public int countItem() {
		int count=0;
		for(Map.Entry<Product, Integer> list:listProduct.entrySet()) {
			count+=list.getValue();
		}
		return count;
	}
	public long total() {
		int count =0;
		for(Map.Entry<Product, Integer> list:listProduct.entrySet()) {
		count+=list.getValue()*list.getKey().getPrice();
		}
		return count;
	}
}
