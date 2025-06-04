package Infinte.EmployeServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.jdbc.dao.EmployDao;
import com.java.jdbc.dao.EmployDaoImpl;
import com.java.jdbc.util.EncryptPassword;

/**
 * Servlet implementation class AddUserServlet
 */
//@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user,pwd;
		user = request.getParameter("userName");
		pwd = request.getParameter("passCode");
		EmployDao employDao = new EmployDaoImpl();
		String ency = EncryptPassword.getCode(pwd);
		
		try {
			out.println(employDao.addUser(user, ency));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
