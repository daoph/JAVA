package prs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import java.sql.Date;
import prs.business.PurchaseRequest;
import prs.utility.ConnectionManager;

public class PurchaseRequestDB implements PurchaseRequestDAO {

	@Override
	public ArrayList<PurchaseRequest> getPurchaseRequests() {
		String sql = "SELECT * FROM prs.PurchaseRequest";
		ArrayList<PurchaseRequest> pr = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				int userID= rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				Date dateNeeded = rs.getDate("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				Date submittedDate = rs.getDate("SubmittedDate");	

				PurchaseRequest p = new PurchaseRequest(id,userID, description,justification,dateNeeded,deliveryMode,status,total,submittedDate);
				pr.add(p);	
			}
			
			return pr;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}	
	}

	@Override
	public int writePRToDatabase(String userID, String description, String justification, String dateneeded, String deliveryMode, String status, double total) {
		
		int generatedKeyInt = 0;
		
		int useriD = (int) Double.parseDouble(userID);
		
		LocalDate currentDate = LocalDate.now();
		Date sqlCurrentDate = Date.valueOf(currentDate);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(dateneeded, dtf);
		Date dateNeeded = Date.valueOf(localDate);
		
			
		String sql = "INSERT INTO prs.PurchaseRequest "
				+ "(UserID, Description, Justification, DateNeeded, DeliveryMode, Status, Total, SubmittedDate) "
				+ "VALUES ('"+useriD+"', '"+description+"', '"+justification+"', '"+dateNeeded+"', '"+deliveryMode+"','"+status+"','"+total+"','"+sqlCurrentDate+"');";
		
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			
			ps.executeUpdate();
			System.out.println("Written to Purchase Request DB");
			
			//get the Generated Key
			
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
	public void writePRToDatabase(String description, double total) {
			
		String sql = "UPDATE prs.PurchaseRequest "
				+ "SET Total = "+ total +" "
				+ "WHERE Description ='"+description+"'" ;
		
		System.out.println(sql);
		
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.executeUpdate(sql);
			System.out.println("Written to PRLI DB");
		}

		catch (SQLException e) {
			System.err.println(e);

		}		
		
	}



	@Override
	public ArrayList<PurchaseRequest> getPendingRequests() {
		
		String sql = "SELECT * FROM prs.PurchaseRequest WHERE Status = 'submitted' ORDER BY DateCreated ASC;";
		
		
		ArrayList<PurchaseRequest> pr = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				
				int id = rs.getInt("ID");
				int userID= rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				Date dateNeeded = rs.getDate("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				Date submittedDate = rs.getDate("SubmittedDate");	
				String r4R = rs.getString("ReasonForRejection");

				PurchaseRequest p = new PurchaseRequest(id,userID, description,justification,dateNeeded,deliveryMode,status,total,submittedDate,r4R);
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
		
		String sql = "SELECT * FROM prs.PurchaseRequest WHERE ID = "+s+" ORDER BY DateCreated ASC;";
		
		
		ArrayList<PurchaseRequest> pr = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				
				int id = rs.getInt("ID");
				int userID= rs.getInt("UserID");
				String description = rs.getString("Description");
				String justification = rs.getString("Justification");
				Date dateNeeded = rs.getDate("DateNeeded");
				String deliveryMode = rs.getString("DeliveryMode");
				String status = rs.getString("Status");
				double total = rs.getDouble("Total");
				Date submittedDate = rs.getDate("SubmittedDate");	
				String r4R = rs.getString("ReasonForRejection");

				PurchaseRequest p = new PurchaseRequest(id,userID, description,justification,dateNeeded,deliveryMode,status,total,submittedDate,r4R);
				pr.add(p);	
			}
			
			return pr;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}	
	}

	@Override
	public void writePRApproved(int generatedKey) {
		
		String sql = "UPDATE prs.PurchaseRequest "
				+ "SET Status = 'APPROVED', IsActive = 0, ReasonForRejection = 'NA' "
				+ "WHERE ID = "+ generatedKey ;
		
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.executeUpdate(sql);
			System.out.println(sql);
		}

		catch (SQLException e) {
			System.err.println(e);

		}		

		
		
		
	}
	
	
	
	@Override
	public void writeManagerApproved(int id) {
		
		String sql = "UPDATE prs.PurchaseRequest "
				+ "SET Status = 'APPROVED', IsActive = 0, ReasonForRejection = 'NA' "
				+ "WHERE ID = "+ id ;
		
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.executeUpdate(sql);
			System.out.println(sql);
		}

		catch (SQLException e) {
			System.err.println(e);

		}		

		
		
		
		
	}

	@Override
	public void writeManagerDenied(int id, String s) {
		
		String sql = "UPDATE prs.PurchaseRequest "
				+ "SET Status = 'DENIED', IsActive = 0, ReasonForRejection = '"+s+"' "
				+ "WHERE ID = "+ id ;
		
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.executeUpdate(sql);
			System.out.println(sql);
		}

		catch (SQLException e) {
			System.err.println(e);

		}		

		
		
		
		
	}
}
