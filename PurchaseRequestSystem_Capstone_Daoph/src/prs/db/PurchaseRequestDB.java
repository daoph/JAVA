package prs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import java.sql.Date;
import prs.business.PurchaseRequest;
import prs.utility.ConnectionManager;

public class PurchaseRequestDB implements PurchaseRequestDAO {

	@Override
	public ArrayList<PurchaseRequest> getPurchaseRequests() {
		String sql = "SELECT * FROM prs.PurchaseRequest ORDER BY DateUpdated DESC;";
		ArrayList<PurchaseRequest> pr = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("ID");
				int userID = rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				Date dateNeeded = rs.getDate("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				Date submittedDate = rs.getDate("SubmittedDate");
				String r4R = rs.getString("ReasonForRejection");

				PurchaseRequest p = new PurchaseRequest(id, userID, description, justification, dateNeeded,
						deliveryMode, status, total, submittedDate, r4R);
				pr.add(p);
			}

			return pr;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<PurchaseRequest> getPurchaseRequests(int i) {

		String sql = "SELECT * FROM prs.PurchaseRequest WHERE UserID = ? ORDER BY DateUpdated DESC";
		ArrayList<PurchaseRequest> pr = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				int userID = rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				Date dateNeeded = rs.getDate("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				Date submittedDate = rs.getDate("SubmittedDate");
				String r4R = rs.getString("ReasonForRejection");

				PurchaseRequest p = new PurchaseRequest(id, userID, description, justification, dateNeeded,
						deliveryMode, status, total, submittedDate, r4R);
				pr.add(p);
			}

			return pr;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<PurchaseRequest> getPendingRequests() {

		String sql = "SELECT * FROM prs.PurchaseRequest WHERE Status = 'submitted' ORDER BY DateUpdated DESC;";

		ArrayList<PurchaseRequest> pr = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {

				int id = rs.getInt("ID");
				int userID = rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				Date dateNeeded = rs.getDate("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				Date submittedDate = rs.getDate("SubmittedDate");
				String r4R = rs.getString("ReasonForRejection");

				PurchaseRequest p = new PurchaseRequest(id, userID, description, justification, dateNeeded,
						deliveryMode, status, total, submittedDate, r4R);
				pr.add(p);
			}

			return pr;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<PurchaseRequest> getPendingRequests(String s) {

		String sql = "SELECT * FROM prs.PurchaseRequest WHERE ID = ? ORDER BY DateUpdated DESC;";

		ArrayList<PurchaseRequest> pr = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("ID");
				int userID = rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				Date dateNeeded = rs.getDate("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				Date submittedDate = rs.getDate("SubmittedDate");
				String r4R = rs.getString("ReasonForRejection");

				PurchaseRequest p = new PurchaseRequest(id, userID, description, justification, dateNeeded,
						deliveryMode, status, total, submittedDate, r4R);
				pr.add(p);
			}

			return pr;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<PurchaseRequest> getPendingRequests(int i) {

		String sql = "SELECT * FROM prs.PurchaseRequest WHERE UserID = ? AND IsActive = 1 ORDER BY DateUpdated DESC;";

		ArrayList<PurchaseRequest> pr = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("ID");
				int userID = rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				Date dateNeeded = rs.getDate("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				Date submittedDate = rs.getDate("SubmittedDate");
				String r4R = rs.getString("ReasonForRejection");

				PurchaseRequest p = new PurchaseRequest(id, userID, description, justification, dateNeeded,
						deliveryMode, status, total, submittedDate, r4R);
				pr.add(p);
			}

			return pr;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public void writePRToDatabase(String description, double total) {

		String sql = "UPDATE prs.PurchaseRequest " + "SET Total = ?" + "WHERE Description = ?";

		System.out.println(sql);

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setDouble(1, total);
			ps.setString(2, description);

			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) updated.");
		}

		catch (SQLException e) {
			System.err.println(e);

		}

	}

	@Override
	public int writePRToDatabase(String userID, String description, String justification, String dateneeded,
			String deliveryMode, String status, double total) {

		int generatedKeyInt = 0;

		int useriD = (int) Double.parseDouble(userID);

		LocalDate currentDate = LocalDate.now();
		Date sqlCurrentDate = Date.valueOf(currentDate);

		LocalDate localDate = LocalDate.parse(dateneeded);
		Date dateNeeded = Date.valueOf(localDate);

		String sql = "INSERT INTO prs.PurchaseRequest "
				+ "(UserID, Description, Justification, DateNeeded, DeliveryMode, Status, Total, SubmittedDate) "
				+ "VALUES (?,?,?,?,?,?,?,?);";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			ps.setInt(1, useriD);
			ps.setString(2, description);
			ps.setString(3, justification);
			ps.setDate(4, dateNeeded);
			ps.setString(5, deliveryMode);
			ps.setString(6, status);
			ps.setDouble(7, total);
			ps.setDate(8, sqlCurrentDate);

			ps.executeUpdate();
			System.out.println("Written to Purchase Request DB");

			// get the Generated Key

			try (ResultSet generatedKey = ps.getGeneratedKeys()) {
				if (generatedKey.next()) {
					generatedKeyInt = generatedKey.getInt(1);
				}
			}

		}

		catch (SQLException e) {
			System.err.println(e);

		}
		return generatedKeyInt;
	}

	@Override
	public void writePRApproved(int generatedKey) {

		String sql = "UPDATE prs.PurchaseRequest "
				+ "SET Status = 'APPROVED', IsActive = 0, ReasonForRejection = '$$$approved$$$' " + "WHERE ID = ?";


		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {
			
			ps.setInt(1, generatedKey);
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) updated.");
		}

		catch (SQLException e) {
			System.err.println(e);

		}

	}

	@Override
	public void writeManagerApproved(int id) {

		String sql = "UPDATE prs.PurchaseRequest "
				+ "SET Status = 'APPROVED', IsActive = 0, ReasonForRejection = '$$$approved$$$' " + "WHERE ID = ?";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setInt(1, id);

			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) updated.");
		}

		catch (SQLException e) {
			System.err.println(e);

		}

	}

	@Override
	public void writeManagerDenied(int id, String s) {

		String sql = "UPDATE prs.PurchaseRequest SET Status = 'DENIED', IsActive = 0, ReasonForRejection = ? WHERE ID = ?";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setString(1, s);
			ps.setInt(2, id);
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) updated.");
		}

		catch (SQLException e) {
			System.err.println(e);

		}

	}

	@Override
	public void userRemoveRequest(int i) {

		String sql = "UPDATE prs.PurchaseRequest SET Status = 'user-removed', IsActive = 0 WHERE ID = ?";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setInt(1, i);
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) updated.");
		}

		catch (SQLException e) {
			System.err.println(e);

		}
	}

	@Override
	public void userWriteSubmit(int i) {

		String sql = "UPDATE prs.PurchaseRequest SET Status = 'submitted', IsActive = 1 WHERE ID = ?";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setInt(1, i);
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) updated.");
		}

		catch (SQLException e) {
			System.err.println(e);

		}
	}

	@Override
	public void userWriteCancel(int i) {

		String sql = "UPDATE prs.PurchaseRequest SET Status = 'user-canceled', IsActive = 0 WHERE ID = ?";

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setInt(1, i);
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) updated.");
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
