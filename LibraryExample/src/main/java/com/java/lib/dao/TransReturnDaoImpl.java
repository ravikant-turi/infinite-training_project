package com.java.lib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.java.lib.model.TransReturn;
import com.java.lib.util.ConnectionHelper;

public class TransReturnDaoImpl  implements TransReturnDao{
	

	Connection connection;
	PreparedStatement pst;
	

	public List<TransReturn> getAllTransactionHistory() throws SQLException, ClassNotFoundException {
        List<TransReturn> historyList = new ArrayList<>();
        String sql = "SELECT * FROM TransReturn";

        try (
            Connection conn = ConnectionHelper.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()
        ) {
            while (rs.next()) {
                TransReturn tr = new TransReturn();
                tr.setUsername(rs.getString("Username"));
                tr.setBookId(rs.getInt("BookId"));
                tr.setFromDate(rs.getDate("Fromdate"));
                tr.setToDate(rs.getDate("Todate"));
                historyList.add(tr);
            }
        }

        return historyList;
    
	}

}
