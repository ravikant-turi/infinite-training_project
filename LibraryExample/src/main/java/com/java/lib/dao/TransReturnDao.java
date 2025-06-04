package com.java.lib.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.lib.model.TransReturn;

public interface TransReturnDao {

	
	 List<TransReturn> getAllTransactionHistory() throws SQLException, ClassNotFoundException;
	 }
