package Infinte.EmployeServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.jdbc.dao.EmployDao;
import com.java.jdbc.dao.EmployDaoImpl;
import com.java.jdbc.model.Employ;
import com.java.jdbc.util.EncryptPassword;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("userName");
		String pwd = request.getParameter("passCode");
		EmployDao dao = new EmployDaoImpl();
		String encr = EncryptPassword.getCode(pwd);

		try {
			int count = dao.authenticate(user, encr);
			if (count == 1) {
//				RequestDispatcher disp = request.getRequestDispatcher("Menu.html");
//				disp.forward(request,response);
				response.sendRedirect("Menu.html");
				out.println("<p style='color:red'>Invalid Credentials....</p>");
			} else {
				RequestDispatcher disp = request.getRequestDispatcher("Login.html");

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
