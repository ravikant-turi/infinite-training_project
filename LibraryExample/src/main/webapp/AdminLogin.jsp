<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>

	<br>
	<form method="post" action="AdminLogin.jsp">
		<center>
			<h2>Admin Login:</h2>
			Username: <input type="text" name="username" size="50"><br>
			<br> Password: <input type="password" name="passcode" size="50"><br>
			<br> <input type="submit" value="Login">
		</center>
	</form>

	<jsp:useBean id="admin" class="com.java.lib.model.AdminLogin" />
	<jsp:setProperty property="*" name="admin" />
	<jsp:useBean id="adminDao" class="com.java.lib.dao.LibraryDaoImpl" />

	<%
	if (request.getParameter("username") != null && request.getParameter("passcode") != null) {
		String adminName = request.getParameter("username");
	%>


	<%
	int result = adminDao.AdminLoginDao(admin);
	if (result == 1) {
		session.setAttribute("admin", adminName);
	%>
	<jsp:forward page="AdminMenu.jsp" />
	<%
	} else {
	out.println("<center><h3 style='color:red;'>Invalid Admin Credentials</h3></center>");
	}
	}
	%>

</body>
</html>