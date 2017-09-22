package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import business.Division;
import business.Store;

public class BigBoxDB implements BBDAO {
	
	private HashMap <Integer, Division> divisionIdMap = new HashMap<>();

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:sqlite:C://repos//JAVA//DB//SQLite//big_box.sqlite";
		Connection connection = DriverManager.getConnection(dbUrl);
		return connection;
	}

	@Override
	public ArrayList<Store> listAllStores() {
		String sql = "SELECT * FROM Stores";
		ArrayList<Store> stores = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while(rs.next()) {
				int ID = rs.getInt("ID");
				Division divisionID = new Division(); //needs a hashMAP divisionIdMap.get()
				String storeNumber = rs.getString("StoreNumber");
				double sales = rs.getDouble("Sales");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String zipCode = rs.getString("ZipCode");	
			
				System.out.println(ID);
				System.out.println(divisionID);
				System.out.println(storeNumber);
				System.out.println(sales);
				System.out.println(name);
				System.out.println(address);
				System.out.println(city);
				System.out.println(state);
				System.out.println(zipCode);
				
		Store s = new Store(ID,divisionID,storeNumber, sales, name, address, city, state, zipCode);
				
		stores.add(s);
				
			}
			return stores;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<Store> listAllStores(String d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSalesSummary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getSalesSummary(String d) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addStore(Store s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDivision(String d) {
		// TODO Auto-generated method stub
		return false;
	}

}
