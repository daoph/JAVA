package prs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import prs.business.Status;

import prs.utility.ConnectionManager;

public class StatusDB implements StatusDAO {

	@Override
	public ArrayList<Status> getStatus() {
		String sql = "SELECT * FROM prs.Status";
		ArrayList<Status> status = new ArrayList<>();

		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String description = rs.getString("Description");
				Status s = new Status(id, description);
				status.add(s);	
			}
			
			return status;

		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}
	}

}
