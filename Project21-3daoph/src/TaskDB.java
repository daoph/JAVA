import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskDB {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:sqlite:./task_list.sqlite";
		Connection connection = DriverManager.getConnection(dbUrl);
		return connection;

	}

	public String viewTasks() {
		String sql = "SELECT * FROM Task \r\n" + "Where completed = 0";

		String tasks = "";
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				tasks += rs.getString(1) + " ";
				tasks += rs.getString(2) + "\n";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return tasks;

	}

	public boolean completeTask() {
		int number = Console.getInt("Number: ");
		String sql = "Update Task \r\n" + "SET completed = 1\r\n" + "Where taskID = " + number;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	public String viewCompleted() {
		String sql = "SELECT * FROM Task \r\n" + "Where completed = 1";
		String tasks = "";
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				tasks += rs.getString(1) + " ";
				tasks += rs.getString(2) + "\n";
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return tasks;

	}

	public boolean addTask() {
		String desc = Console.getString("Enter Description: ");
		String sql = "INSERT INTO Task(taskID, description, completed)\r\n" 
					+ "Values(" + nextNumber() + ", \"" + desc + "\" , 0)";
		try (Connection connection = getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;

		}

	}

	
	public boolean deleteTask() {
		int number = Console.getInt("Number: ");
		String sql = "DELETE FROM Task \r\n" + "Where taskID = " + number;
		try (Connection connection = getConnection(); 
				PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	
	public int nextNumber() {
		int number = 0;
		String sql = "Select taskID\r\n" + "FROM Task\r\n" + "ORDER by taskID Desc";

		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			number = rs.getInt(1);

		} catch (SQLException e) {
			System.err.println(e);
		}
		number++;
		return number;
	}
}
