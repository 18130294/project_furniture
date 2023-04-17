package com.example.furniture.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name ="orders")
public class Invoice {
			@Id
			@Column(name ="idOrder")
			private String idOrder;
			private String idUser;
			private String address ;
			private String phoneNumber;
			private Timestamp invoiceDate;
			private String payForm;
			
			public Invoice() {
				
			}
			@Override
			public String toString() {
				return "Invoice [idOrder=" + idOrder + ", idUser=" + idUser + ", address=" + address + ", phoneNumber="
						+ phoneNumber + ", invoiceDate=" + invoiceDate + ", payForm=" + payForm + "]";
			}
			public Invoice(String idOrder, String idUser, String address, String phoneNumber, Timestamp invoiceDate,
					String payForm) {
				super();
				this.idOrder = idOrder;
				this.idUser = idUser;
				this.address = address;
				this.phoneNumber = phoneNumber;
				this.invoiceDate = invoiceDate;
				this.payForm = payForm;
			}
			public String getIdOrder() {
				return idOrder;
			}
			public void setIdOrder(String idOrder) {
				this.idOrder = idOrder;
			}
			public String getIdUser() {
				return idUser;
			}
			public void setIdUser(String idUser) {
				this.idUser = idUser;
			}
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getPhoneNumber() {
				return phoneNumber;
			}
			public void setPhoneNumber(String phoneNumber) {
				this.phoneNumber = phoneNumber;
			}
			public Timestamp getInvoiceDate() {
				return invoiceDate;
			}
			public void setInvoiceDate(Timestamp invoiceDate) {
				this.invoiceDate = invoiceDate;
			}
			public String getPayForm() {
				return payForm;
			}
			public void setPayForm(String payForm) {
				this.payForm = payForm;
			}
			
			
}
