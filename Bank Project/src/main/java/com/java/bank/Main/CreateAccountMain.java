package com.java.bank.Main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.bank.Dao.BankDao;
import com.java.bank.Dao.BankDaoImpl;
import com.java.model.Accounts;

public class CreateAccountMain {
	public static void main(String[] args) {
		
		Accounts accounts = new Accounts();
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter FirstName: ");
		accounts.setFirstName(sc.next());
		System.out.println("Enter LastName: ");
		accounts.setLastName(sc.next());
		System.out.println("Enter City: ");
		accounts.setCity(sc.next());
		System.out.println("Enter State: ");
		accounts.setState(sc.next());
		System.out.println("Enter Amount: ");
		accounts.setAmount(sc.nextDouble());
		System.out.println("Enter CheqFacil(Yes/No): ");
		accounts.setCheqFacil(sc.next());
		System.out.println("Enter AccountType: ");
		accounts.setAccountType(sc.next());
		
		BankDao bankDao = new BankDaoImpl();
		
		try {
			System.out.println(bankDao.createAccount(accounts));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
