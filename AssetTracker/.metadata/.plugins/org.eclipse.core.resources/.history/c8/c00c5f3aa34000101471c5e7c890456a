package com.java.test;

import com.java.dao.AdminDao;
import com.java.daoImpl.AdminDaoImpl;
import com.java.model.Admin;

public class AdminTest {
	
	public static void main(String[] args) {
		
		AdminDao admindao=new AdminDaoImpl();
		
		Admin admin=new Admin();
		
		admin.setEmail("admin@gmail.com");
		
		admin.setName("admin");
		
		admin.setPasscode("pass");
		
		
		
		
		
		
//		admindao.signUp(admin);
		System.out.println(admindao.signIn("admin", "pass"));
	}

}
