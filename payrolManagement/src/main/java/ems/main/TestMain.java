package ems.main;

import java.sql.SQLException;

import ems.util.ConnectionHelper;

public class TestMain {
  public static void main(String[] args) {
	ConnectionHelper con=new ConnectionHelper();
	try {
		System.out.println("connection "+ con.getConnection());
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
