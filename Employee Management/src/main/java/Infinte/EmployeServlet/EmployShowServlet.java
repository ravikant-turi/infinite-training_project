package Infinte.EmployeServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.jdbc.dao.EmployDao;
import com.java.jdbc.dao.EmployDaoImpl;
import com.java.jdbc.model.Employ;

/**
 * Servlet implementation class EmployShowServlet
 */
//@WebServlet("/EmployShowServlet")
public class EmployShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployShowServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher disp = request.getRequestDispatcher("Menu.html");
		out.println();
		EmployDao dao = new EmployDaoImpl();
		
		try {
			List<Employ> employelist = dao.showEmployDao();
			
			for (Employ employ : employelist) {
				out.println("Employ no: "+employ.getEmpno() + "</br>");
				out.println("Name: "+employ.getName() + "</br>");
				out.println("Gender: "+employ.getGender() + "</br>");
				out.println("Department: "+employ.getDept() + "</br>");
				out.println("Designation: "+employ.getDesig() + "</br>");
				out.println("Basic: "+employ.getBasic() + "</br><hr>");

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
