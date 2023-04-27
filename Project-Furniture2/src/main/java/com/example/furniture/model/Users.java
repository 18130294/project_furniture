package com.example.furniture.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="users")
public class Users {
	@Id
	private String idUser;
	private String email;
	private String sdt;
	private String pass;
	private String nameUser;
	private int isAdmin;
	private String diachi;
	public Users(String idUser, String email, String sdt, String pass, String nameUser, int isAdmin, String diachi) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.sdt = sdt;
		this.pass = pass;
		this.nameUser = nameUser;
		this.isAdmin = isAdmin;
		this.diachi = diachi;
	}
	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", email=" + email + ", sdt=" + sdt + ", pass=" + pass + ", nameUser="
				+ nameUser + ", isAdmin=" + isAdmin + ", diachi=" + diachi + "]";
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	
	public Users checkUser(List<Users> list,String email ) {
		for(Users user:list) {
		if(user.getEmail().equalsIgnoreCase(email)) {
			return user;
		}
			
			}
		return null;
	
}
	public Users checkUserAccount(List<Users> list,String email,String pass ) {
		for(Users user:list) {
		if(user.getEmail().equalsIgnoreCase(email)&&user.getPass().equalsIgnoreCase(pass)) {
			return user;
		}
			
			}
		return null;
	
}
	public Users() {
		
	}
	public static void main(String[] args) {
		List<Users> list = new ArrayList<>();
		Users a1 = new Users("123","saurieng1166@gmail.com","0342500003","123456","Nguyễn Thị Như Ý",0,"Bình Thạnh");
		list.add(a1);
		Users a = new Users();
		
//		System.out.println(a.checkUser(list, "saurieng1166@gmail.com"));
		
		System.out.println(a.checkUserAccount(list, "saurieng1166@gmail.com", "123476"));
		
		
		
		
		
		
		
	}
}
