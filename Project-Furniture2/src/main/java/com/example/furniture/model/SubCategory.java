package com.example.furniture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="subCategories")
public class SubCategory {
	@Id
	@Column(name ="idSubcategory")
		private String	idSubcategory;
		private String	idcategories ;
		private String	nameSubcategories;
		public SubCategory(String idSubcategory, String idcategories, String nameSubcategories) {
			super();
			this.idSubcategory = idSubcategory;
			this.idcategories = idcategories;
			this.nameSubcategories = nameSubcategories;
		}
		public SubCategory() {
			super();
		}
		public String getIdSubcategory() {
			return idSubcategory;
		}
		public void setIdSubcategory(String idSubcategory) {
			this.idSubcategory = idSubcategory;
		}
		public String getIdcategories() {
			return idcategories;
		}
		public void setIdcategories(String idcategories) {
			this.idcategories = idcategories;
		}
		public String getNameSubcategories() {
			return nameSubcategories;
		}
		public void setNameSubcategories(String nameSubcategories) {
			this.nameSubcategories = nameSubcategories;
		}
		@Override
		public String toString() {
			return "SubCategory [idSubcategory=" + idSubcategory + ", idcategories=" + idcategories
					+ ", nameSubcategories=" + nameSubcategories + "]";
		}
		
		
		
}
