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

		String sql = "SELECT * FROM prs.User";
		ArrayList<User> user = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("UserName");
				String password = rs.getString("Password");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String phone = rs.getString("Phone");
				String email = rs.getString("Email");
				boolean isReviewer = rs.getBoolean("IsReviewer");
				boolean isAdmin = rs.getBoolean("IsAdmin");

				User s = new User(id, userName, password, firstName, lastName, phone, email, isReviewer, isAdmin);
				user.add(s);
			}
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean loginValidator(String username, String password) {
		boolean isValid = false;
		String sql = "SELECT * FROM prs.User";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				String dbUserName = rs.getString("UserName");
				String dbPassword = rs.getString("Password");

				if (username.equals(dbUserName) && password.equals(dbPassword)) {
					System.out.println("User/password verified...");
					isValid = true;
					break;
				} else {
					System.out.println("User/password does not match...");
					isValid = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public User getUserObject(String username) {

		String sql = "SELECT * FROM prs.User Where UserName = ?";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

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

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
	}
}
