package prs.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	// establishes MySQL connection and returns object.
	public static Connection getConnection() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String dbUrl = "jdbc:mysql://localhost:3306/prs";
		String username = "root";
		String password = "sesame";

		Connection connection = DriverManager.getConnection(dbUrl, username, password);
		return connection;

	}
}