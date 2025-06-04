package com.java.lib.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import com.java.lib.model.AdminLogin;
import com.java.lib.model.Books;
import com.java.lib.model.LibUsers;
import com.java.lib.model.TranBook;
import com.java.lib.util.ConnectionHelper;
import com.java.lib.util.EncryptPassword;

public class LibraryDaoImpl implements LibraryDao {

	static Connection connection;
	static PreparedStatement psmt;

	public int issueOrNot(String userName, int bookId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String sql = "select count(*) cnt from TranBook where UserName=? and BookId=?";
		psmt = connection.prepareStatement(sql);
		psmt.setString(1, userName);
		psmt.setInt(2, bookId);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

	public int totalBooksIssued(String username) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String sql = "SELECT COUNT(*) AS total FROM TranBook WHERE UserName = ?";
		psmt = connection.prepareStatement(sql);
		psmt.setString(1, username);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		return rs.getInt("total");
	}

	@Override
	public String createUser(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(libUsers.getPassWord());
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into LibUsers(UserName,Password) values(?,?)";
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, libUsers.getUserName());
		psmt.setString(2, encr);
		psmt.executeUpdate();
		return "User Account Created Successfully...";
	}

	@Override
	public int login(LibUsers libUsers) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(libUsers.getPassWord());
		connection = ConnectionHelper.getConnection();
		String cmd = "select count(*) cnt from LibUsers where UserName = ? AND " + " Password = ?";
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, libUsers.getUserName());
		psmt.setString(2, encr);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

	public int AdminLoginDao(AdminLogin adlog) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(adlog.getPasscode());
		connection = ConnectionHelper.getConnection();
		String sql = "select count(*) cnt from AdminLogin where Adminname = ? AND passcode = ?";
		psmt = connection.prepareStatement(sql);
		psmt.setString(1, adlog.getUsername());
		psmt.setString(2, encr);

		ResultSet rs = psmt.executeQuery();
		rs.next();
		int count = rs.getInt("cnt");
		return count;
	}

	@Override
	public List<Books> searchBooks(String searchType, String searchValue) throws ClassNotFoundException, SQLException {
		String cmd;
		boolean isValid = true;
		if (searchType.equals("id")) {
			cmd = " SELECT * FROM Books WHERE Id = ? ";
		} else if (searchType.equals("bookname")) {
			cmd = " SELECT * FROM Books Where Name = ?";
		} else if (searchType.equals("authorname")) {
			cmd = "SELECT * FROM Books where Author = ?";
		} else if (searchType.equals("dept")) {
			cmd = "select * from Books where Dept = ?";
		} else {
			isValid = false;
			cmd = "select * from Books";
		}
		connection = ConnectionHelper.getConnection();
		psmt = connection.prepareStatement(cmd);
		if (isValid == true) {
			psmt.setString(1, searchValue);
		}
		ResultSet rs = psmt.executeQuery();
		Books books = null;
		List<Books> booksList = new ArrayList<Books>();
		while (rs.next()) {
			books = new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setNoOfBooks(rs.getInt("TotalBooks"));
			booksList.add(books);
		}
		return booksList;
	}

	@Override
	public String issueBook(String username, int bookId) throws ClassNotFoundException, SQLException {
		int alreadyIssued = issueOrNot(username, bookId); // 0 or 1
		int totalIssued = totalBooksIssued(username); // MAx number of books

		connection = ConnectionHelper.getConnection();
		String sql = "SELECT TotalBooks FROM Books WHERE Id = ?";
		psmt = connection.prepareStatement(sql);
		psmt.setInt(1, bookId);
		ResultSet rs = psmt.executeQuery();

		if (rs.next()) {
			int availableCopies = rs.getInt("TotalBooks");

			if (availableCopies == 1) {
				return "This book is not available for issue as there is only 1 copy left.";
			}
		}

		if (alreadyIssued == 0 && totalIssued < 4) {
			String insertSql = "INSERT INTO TranBook(UserName, BookId) VALUES (?, ?)";
			psmt = connection.prepareStatement(insertSql);
			psmt.setString(1, username);
			psmt.setInt(2, bookId);
			psmt.executeUpdate();

			String updateSql = "UPDATE Books SET TotalBooks = TotalBooks - 1 WHERE Id = ?";
			psmt = connection.prepareStatement(updateSql);
			psmt.setInt(1, bookId);
			psmt.executeUpdate();

			return "Book with Id " + bookId + " issued successfully.";
		} else if (alreadyIssued > 0) {
			return "User already issued this book.";
		} else {
			return "User already issued 4 books. Cannot issue more.";
		}
	}

//	@Override
//	public String issueBook(String userName, int bookId) throws ClassNotFoundException, SQLException {
//		int count = issueOrNot(userName, bookId);
//		if (count == 0) {
//			connection = ConnectionHelper.getConnection();
//			String sql = "Insert into TranBook(UserName,BookId) values(?,?)";
//			psmt = connection.prepareStatement(sql);
//			psmt.setString(1, userName);
//			psmt.setInt(2, bookId);
//			psmt.executeUpdate();
//			sql = "Update Books set TotalBooks=TotalBooks-1 where id=?";
//			psmt = connection.prepareStatement(sql);
//			psmt.setInt(1, bookId);
//			psmt.executeUpdate();
//			return "Book with Id " + bookId + " Issued Successfully...";
//		} else {
//			return "Book Id " + bookId + " for User " + userName + " Already Issued...";
//		}
//	}

	@Override
	public List<TranBook> accountDetails(String userName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from tranbook where username = ?";
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, userName);
		ResultSet rs = psmt.executeQuery();
		List<TranBook> booksIssued = new ArrayList<TranBook>();
		TranBook tranBook = null;
		while (rs.next()) {
			tranBook = new TranBook();
			tranBook.setBookId(rs.getInt("BookId"));
			tranBook.setUserName(rs.getString("UserName"));
			tranBook.setFromDate(rs.getDate("FromDate"));
			tranBook.setFine(calculateFineFromDate(rs.getDate("FromDate")));
			booksIssued.add(tranBook);
		}
		return booksIssued;
	}

	@Override
	public String returnBook(String userName, int bookId) throws ClassNotFoundException, SQLException {
		String cmd = "SELECT * FROM TranBook WHERE Username = ? and BookId = ?";
		connection = ConnectionHelper.getConnection();
		psmt = connection.prepareStatement(cmd);
		psmt.setString(1, userName);
		psmt.setInt(2, bookId);
		ResultSet rs = psmt.executeQuery();
		rs.next();
		Date fromDate = rs.getDate("fromDate");

		String sql2 = " INSERT INTO TransReturn(UserName,BookId,FromDate) VALUES (?,?,?)";
		psmt = connection.prepareStatement(sql2);
		psmt.setString(1, userName);
		psmt.setInt(2, bookId);
		psmt.setDate(3, fromDate);
		psmt.executeUpdate();

		String sql1 = "DELETE FROM TranBook WHERE BookId = ? AND Username = ? ";
		psmt = connection.prepareStatement(sql1);
		psmt.setInt(1, bookId);
		psmt.setString(2, userName);
		psmt.executeUpdate();

		String sql3 = "Update Books set TotalBooks = TotalBooks + 1 where Id = ?";
		psmt = connection.prepareStatement(sql3);
		psmt.setInt(1, bookId);
		psmt.executeUpdate();
		return "Book with Id " + bookId + " For User " + userName + " Returned Successfully...";
	}

	@Override
	public String createAdminDao(AdminLogin adlog) throws ClassNotFoundException, SQLException {
		String encr = EncryptPassword.getCode(adlog.getPasscode());
		connection = ConnectionHelper.getConnection();
		String sql = "Insert into AdminLogin(Adminname, passcode) values(?,?)";
		psmt = connection.prepareStatement(sql);
		psmt.setString(1, adlog.getUsername());
		psmt.setString(2, encr);
		psmt.executeUpdate();
		return "Hey Admin Welcome to the Board";
	}

	@Override
	public String addBooksDao(Books book) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionHelper.getConnection();

		// Check for existing book with same name, author, and edition
		String checkSql = "SELECT Id, TotalBooks FROM Books WHERE Name = ? AND Author = ? AND Edition = ?";
		PreparedStatement checkStmt = conn.prepareStatement(checkSql);
		checkStmt.setString(1, book.getName());
		checkStmt.setString(2, book.getAuthor());
		checkStmt.setString(3, book.getEdition());
		ResultSet rs = checkStmt.executeQuery();

		if (rs.next()) {
			int existingBookId = rs.getInt("Id");
			int existingCount = rs.getInt("TotalBooks");

			String updateSql = "UPDATE Books SET TotalBooks = ? WHERE Id = ?";
			try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
				updateStmt.setInt(1, existingCount + book.getNoOfBooks());
				updateStmt.setInt(2, existingBookId);
				int updated = updateStmt.executeUpdate();
				return updated > 0 ? "Book count updated successfully." : "Failed to update book count.";
			}

		} else {
			String maxIdSql = "SELECT MAX(Id) AS maxId FROM Books";
			PreparedStatement maxStmt = conn.prepareStatement(maxIdSql);
			ResultSet maxRs = maxStmt.executeQuery();

			int newBookId = 1;
			if (maxRs.next() && maxRs.getInt("maxId") > 0) {
				newBookId = maxRs.getInt("maxId") + 1;
			}

			String insertSql = "INSERT INTO Books (Id, Name, Author, Edition, Dept, TotalBooks) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement insertStmt = conn.prepareStatement(insertSql);
			insertStmt.setInt(1, newBookId);
			insertStmt.setString(2, book.getName());
			insertStmt.setString(3, book.getAuthor());
			insertStmt.setString(4, book.getEdition());
			insertStmt.setString(5, book.getDept());
			insertStmt.setInt(6, book.getNoOfBooks());

			int inserted = insertStmt.executeUpdate();
			return inserted > 0 ? "New book added successfully." : "Failed to add new book.";
		}
	}

	public int calculateFineFromDatabase() throws ClassNotFoundException, SQLException {

		int fine = 0;
		String query = "SELECT Fromdate FROM tranbook "; // Replace with your condition to fetch relevant rows
		Connection connection = ConnectionHelper.getConnection();
		psmt = connection.prepareStatement(query);

		ResultSet rs = psmt.executeQuery();

		while (rs.next()) {
			Timestamp fromDate = rs.getTimestamp("Fromdate");
			LocalDate fromDateLocal = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate currentDate = LocalDate.now();

			long totalDays = ChronoUnit.DAYS.between(fromDateLocal, currentDate);
			fine = (totalDays > 21) ? (int) ((totalDays - 21) * 5) : 0;
			System.out.println("total Days " + totalDays + "fine is : " + fine);
		}

		return fine;
	}

	public int calculateFineFromDate(Date fromDate) {
		LocalDate fromDateLocal = fromDate.toLocalDate();
		LocalDate currentDate = LocalDate.now();

		long totalDays = ChronoUnit.DAYS.between(fromDateLocal, currentDate);
		int fine = (totalDays > 21) ? (int) ((totalDays - 21) * 5) : 0;

		System.out.println("Days: " + totalDays + ", Fine: ₹" + fine);
		return fine;
	}

}
