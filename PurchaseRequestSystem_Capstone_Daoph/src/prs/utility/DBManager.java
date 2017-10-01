package prs.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prs.business.User;
import prs.db.UserDAO;

public class DBManager implements UserDAO{

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

	public static String loginValidator(String username, String password) {
		String url = "";
		String sql = "SELECT * FROM prs.User";

		try (Connection connection = DBManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String dbUserName = rs.getString("UserName");
				String dbPassword = rs.getString("Password");

				if (username.equals(dbUserName) && password.equals(dbPassword)) {
					System.out.println("Authentication passed. Sending to Dashboard...");
					url = "/dashboard.html";
					break;
				} else {
					System.out.println("Authentication failed");
					url = "/loginerror.html";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
