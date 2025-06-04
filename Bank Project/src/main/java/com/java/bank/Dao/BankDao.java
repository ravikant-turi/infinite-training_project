package com.java.bank.Dao;

import java.sql.SQLException;

import com.java.model.Accounts;

public interface BankDao {

	String createAccount(Accounts accounts) throws ClassNotFoundException, SQLException;

	Accounts searchAccount(int accontNo) throws SQLException, ClassNotFoundException;
}
