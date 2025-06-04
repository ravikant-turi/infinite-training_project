package com.java.test;

import com.java.dao.UserDao;
import com.java.daoImpl.UserDaoImpl;
import com.java.model.Status;
import com.java.model.User;

public class UserTest {
	
	public static void main(String[] args) {
		
		UserDao lgDao=new UserDaoImpl();
		
		User login=new User();
		
		login.setEmail("nn@gmail.com");
		login.setName("nname");
		login.setPasscode("passs");
		login.setStatus(Status.ASSIGNED);
		
		
		
//		lgDao.signUp(login);
		
		System.out.println(lgDao.signIn("nname", "passs"));
	}

}
