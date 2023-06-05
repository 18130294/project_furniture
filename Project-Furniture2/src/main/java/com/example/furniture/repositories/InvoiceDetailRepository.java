package com.example.furniture.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.furniture.model.Invoice;
import com.example.furniture.model.InvoiceDetail;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
	public List<InvoiceDetail> findByNameUser(String nameUser);
	public InvoiceDetail findByIdOrder(String idOrder);
}
