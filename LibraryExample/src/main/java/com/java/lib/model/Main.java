package com.java.lib.model;

import java.sql.SQLException;
import java.util.List;

import com.java.lib.dao.LibraryDao;
import com.java.lib.dao.LibraryDaoImpl;
import com.java.lib.dao.TransReturnDao;
import com.java.lib.dao.TransReturnDaoImpl;

public class Main {
 public static void main(String[] args) {
	
	 TransReturnDao t=new TransReturnDaoImpl();
	 
	try {
		List<TransReturn> list=t.getAllTransactionHistory();
		
		for(TransReturn tr:list)
		{	
			System.out.println(tr);
			
		} 
		
		
		LibraryDaoImpl l=new LibraryDaoImpl();
		l.calculateFineFromDatabase();
	}
		catch (ClassNotFoundException | SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
