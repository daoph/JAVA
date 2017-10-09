package prs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prs.business.PurchaseRequestLineItem;
import prs.utility.ConnectionManager;

public class PurchaseRequestLineItemsDB implements PurchaseRequestLineItemsDAO {

	@Override
	public ArrayList<PurchaseRequestLineItem> getPurchaseRequestLineItems() {
		String sql = "SELECT * FROM prs.PurchaseRequestLineItems";
		ArrayList<PurchaseRequestLineItem> prli = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				int purchaseRequestID = rs.getInt("PurchaseRequestID");
				int productID = rs.getInt("ProductID");
				int quantity = rs.getInt("Quantity");

				PurchaseRequestLineItem p = new PurchaseRequestLineItem(id,purchaseRequestID,productID,quantity);
				prli.add(p);	
			}
			
			return prli;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}	
	}
	
	@Override
	public ArrayList<PurchaseRequestLineItem> getPurchaseRequestLineItems(String s) {
		
		String sql = "SELECT * FROM prs.PurchaseRequestLineItems WHERE PurchaseRequestID = ?"; 
		ArrayList<PurchaseRequestLineItem> prli = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				int purchaseRequestID = rs.getInt("PurchaseRequestID");
				int productID = rs.getInt("ProductID");
				int quantity = rs.getInt("Quantity");

				PurchaseRequestLineItem p = new PurchaseRequestLineItem(id,purchaseRequestID,productID,quantity);
				prli.add(p);	
			}
			
			return prli;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}	
	}
	
	
	
	

	@Override
	public void writePrliToDatabase(int id, int productID, int quantity) {
		
		String sql = "INSERT INTO prs.PurchaseRequestLineItems"
				+ "(PurchaseRequestID, ProductID, Quantity) "
				+ "VALUES ('"+id+"','"+productID+"', '"+quantity+"');" ;
		
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);) {

			ps.setInt(1, id);
			ps.setInt(2, productID);
			ps.setInt(3, quantity);
			
			int rowCount = ps.executeUpdate();
			System.out.println(rowCount + " row(s) updated.");
		}

		catch (SQLException e) {
			System.err.println(e);

		}		
	}





}
