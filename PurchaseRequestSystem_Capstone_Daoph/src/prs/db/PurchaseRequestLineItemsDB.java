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
	public ArrayList<PurchaseRequestLineItem> getLineItems() {
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

}
