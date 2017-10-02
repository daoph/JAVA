package prs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prs.business.Vendor;
import prs.utility.ConnectionManager;

public class VendorDB implements VendorDAO {

	@Override
	public ArrayList<Vendor> listAllVendors() {
		String sql = "SELECT * FROM prs.Vendor";
		ArrayList<Vendor> vendors = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String code = rs.getString("Code");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zip = rs.getString("Zip");
				String phone = rs.getString("Phone");
				String email = rs.getString("Email");
				boolean isPreApproved = rs.getBoolean("IsPreApproved");

				Vendor v = new Vendor(id, code, name, address, city, state, zip, phone, email, isPreApproved);
				vendors.add(v);	
			}
			
			return vendors;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}	
	}



}
