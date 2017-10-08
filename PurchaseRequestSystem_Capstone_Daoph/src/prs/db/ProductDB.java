package prs.db;

import java.util.ArrayList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import prs.business.Product;
import prs.utility.ConnectionManager;

public class ProductDB implements ProductDAO {
	

	//create ArrayList instance
	ArrayList<Product> products = new ArrayList<>();
	
	@Override
	public ArrayList<Product> listAllProducts() {

		String sql = "SELECT * FROM prs.Product";
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("ID");
				int vendorID = rs.getInt("VendorID");
				String vendorPartNumber = rs.getString("PartNumber");
				String name = rs.getString("Name");
				double price = rs.getDouble("Price");
				String unit = rs.getString("Unit");
				String photoPath = rs.getString("PhotoPath");

				Product s = new Product(id, vendorID, vendorPartNumber, name, price, unit, photoPath);

				products.add(s);
			}
			return products;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public double getSum(String productCode, int vendorID, int quantity) {
		double sum = 0;

		for (Product p : products) {
			System.out.println("Checking product " +p+ "to match: " + productCode);
			
			if(p.getVendorPartNumber().equalsIgnoreCase(productCode) 
				&& p.getVendorID() == vendorID ) {
				System.out.println("product code and vendor match");
				
				sum += ( p.getPrice() * quantity);				
			}
		}
		return sum;
	}

	
	
}
