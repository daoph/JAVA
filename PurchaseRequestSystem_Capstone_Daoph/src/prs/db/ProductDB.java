package prs.db;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import prs.business.Product;
import prs.utility.DBManager;

public class ProductDB implements ProductDAO{


	@Override
	public ArrayList<Product> listAllProducts() {
		
		String sql = "SELECT * FROM prs.Product";
		ArrayList<Product> products = new ArrayList<>();

		try (Connection connection = DBManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				int ID = rs.getInt("ID");
				int vendorID = rs.getInt("VendorID");
				String vendorPartNumber = rs.getString("PartNumber");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				String unit = rs.getString("Unit");
				String photoPath = rs.getString("PhotoPath");

				Product s = new Product(ID, vendorID, vendorPartNumber, name, price, unit, photoPath);

				products.add(s);
			}
			
			return products;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}	
	}
}
