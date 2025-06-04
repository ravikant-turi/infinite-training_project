package Infinte.EmployeServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class AddCookieServlet
 */
//@WebServlet("/AddCookieServlet")
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie ckPurnendu = new Cookie("Purnendu", "98");
		ckPurnendu.setMaxAge(1000 * 60 * 60 * 24);
		response.addCookie(ckPurnendu);

		Cookie ckPriyansu = new Cookie("Priyansu", "90");
		ckPriyansu.setMaxAge(1000 * 60 * 60 * 24);
		response.addCookie(ckPriyansu);

		Cookie ckSoumya = new Cookie("Soumya", "88");
		ckSoumya.setMaxAge(1000 * 60 * 60 * 24);
		response.addCookie(ckSoumya);

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<b> Cookies are created successfully </b>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
