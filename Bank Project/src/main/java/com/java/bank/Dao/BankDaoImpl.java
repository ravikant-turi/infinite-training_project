package com.java.bank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.model.Accounts;

import Demo.BankProject.util.ConnectionHelper;

public class BankDaoImpl implements BankDao{

	Connection connection;
	PreparedStatement pst;
	
	public int generateAccountNo() throws ClassNotFoundException, SQLException {
		String cmd ="select case when max(accountNo) IS NULL THEN 1 "
				+ " else max(accountNo)+1 end accno from accounts";
		
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt("accno");
         	}

	@Override
	public String createAccount(Accounts accounts) throws ClassNotFoundException, SQLException {

		int id = generateAccountNo();
		accounts.setAccountNo(id);
		String cmd = "Insert into Accounts(AccountNo, FirstName, LastName, City, State,"
				+ "Amount, CheqFacil, AccountType) values(?,?,?,?,?,?,?,?)";
		
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accounts.getAccountNo());
		pst.setString(2, accounts.getFirstName());
		pst.setString(3, accounts.getLastName());
		pst.setString(4, accounts.getCity());
		pst.setString(5, accounts.getState());
		pst.setDouble(6, accounts.getAmount());
		pst.setString(7, accounts.getCheqFacil());
		pst.setString(8, accounts.getAccountType());
		pst.executeUpdate();
		return "Account Created with Account No  " +id;
	}

	@Override
	public Accounts searchAccount(int accountNo) throws SQLException, ClassNotFoundException {

		Accounts accounts = null;
		String cmd = "select * from accounts where accountNo = ?";
		connection = ConnectionHelper.getConnection();
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, accountNo);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			accounts = new Accounts();
			accounts.setAccountNo(rs.getInt("accountNo"));
			accounts.setFirstName(rs.getString("firstName"));
			accounts.setLastName(rs.getString("lastName"));
			accounts.setCity(rs.getString("city"));
			accounts.setState(rs.getString("state"));
			accounts.setAmount(rs.getDouble("amount")); 
			accounts.setCheqFacil(rs.getString("cheqFacil"));
			accounts.setAccountType(rs.getString("accountType"));
		}
		return accounts;
	}

}
