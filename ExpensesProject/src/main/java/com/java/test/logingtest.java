package com.java.test;

import com.java.dao.LoginDao;
import com.java.daoImpl.LoginDaoImpl;
import com.java.model.Login;

public class logingtest {
	
	public static void main(String[] args) {
		
		LoginDao lgDao=new LoginDaoImpl();
		
		Login login=new Login();
		
		login.setEmail("n@gmail.com");
		login.setName("name");
		login.setPasscode("pass");
		
		
		
//		lgDao.signUp(login);
		
		System.out.println(lgDao.signIn("name", "pass"));
	}

}
