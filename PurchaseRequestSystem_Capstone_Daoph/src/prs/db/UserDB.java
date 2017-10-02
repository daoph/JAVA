package prs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prs.business.User;
import prs.utility.ConnectionManager;

public class UserDB implements UserDAO {

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public String loginValidator(String username, String password) {
		String url = "";
		String sql = "SELECT * FROM prs.User";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String dbUserName = rs.getString("UserName");
				String dbPassword = rs.getString("Password");

				if (username.equals(dbUserName) && password.equals(dbPassword)) {
					System.out.println("Authentication passed. Sending to Dashboard...");
					url = "/dashboard.jsp";
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
	public User getUserObject(String username) {

		String sql = "SELECT * FROM prs.User Where UserName = '" + username + "';";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
	
				int id = rs.getInt("ID");
				String userName = rs.getString("UserName");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String phone = rs.getString("Phone");
				String email = rs.getString("Email");
				boolean isReviewer = rs.getBoolean("IsReviewer");
				boolean isAdmin = rs.getBoolean("IsAdmin");
				
				User user = new User();
		
				user.setId(id);
				user.setUsername(userName);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setPhone(phone);
				user.setEmail(email);
				user.setReviewer(isReviewer);
				user.setAdmin(isAdmin);
				
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
}
