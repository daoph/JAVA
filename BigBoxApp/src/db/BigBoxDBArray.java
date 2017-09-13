package db;

import java.util.ArrayList;
import java.util.HashMap;
import business.Division;
import business.Store;

public class BigBoxDBArray implements BBDAO {

	private HashMap<String, Division> divisions = null;
	private ArrayList<Store> stores = null;

	public BigBoxDBArray() {
		setupArrays();
	}

	private void setupArrays() {
		divisions = new HashMap<String, Division>();
		divisions.put("001",
				new Division(1, "001", "Cincinnati Division", "1111 Division St.", "Cincinnati", "OH", "45555"));
		divisions.put("111",
				new Division(2, "111", "Louisville Division", "1222 Washtington St.", "Louisville", "KY", "40205"));
		stores = new ArrayList<Store>();
		stores.add(new Store(1, divisions.get("001"), "00011", 25000, "Mason BigBox", "5711 Fields Ertel Rd.", "Mason",
				"OH", "45249"));
		stores.add(new Store(2, divisions.get("001"), "00255", 27500, "Downtown BigBox", "9330 Main St.", "Cincinnati",
				"OH", "45202"));
		stores.add(new Store(3, divisions.get("001"), "00172", 32555.55, "Goshen BigBox", "6777 Goshen Rd.", "Goshen",
				"OH", "45122"));
		stores.add(new Store(4, divisions.get("001"), "00075", 21425.37, "Bridgetown BigBox", "3888 Race Rd.",
				"Cincinnati", "OH", "45211"));
		stores.add(new Store(5, divisions.get("111"), "00001", 14432.77, "Louisville BigBox", "1111 Washington St.",
				"Louisville", "KY", "40206"));
		stores.add(new Store(6, divisions.get("111"), "00044", 17555.11, "Lawrenceburg BigBox", "8000 Liberty St.",
				"Louisville", "KY", "40204"));
	}

	@Override
	public boolean addStore(Store s) {
		if (s.getId() == -1) {
			s.setId(getNextId());
		}
		boolean success = true;
		System.out.println("addStore(Store s) method not yet defined");
		return success;
	}

	private int getNextId() {
		int maxID = 1;
		for (Store s : stores) {
			maxID = Math.max(maxID, s.getId());
		}
		return maxID + 1;
	}

	@Override
	public ArrayList<Store> listAllStores() {
		return stores;
	}

	@Override
	public ArrayList<Store> listAllStores(String d) {
		ArrayList<Store> storesInDivision = new ArrayList<Store>();
		for (Store s : stores) {
			if (s.getDivisionNumber().equalsIgnoreCase(d)) {
				storesInDivision.add(s);
			}
		}

		return storesInDivision;
	}

	@Override
	public double getSalesSummary() {
		double sum = 0.0;
		for (Store s : stores) {
			sum += s.getSales();
		}
		return sum;
	}

	@Override
	public double getSalesSummary(String d) {
		double sum = 0.0;
		for (Store s : stores) {
			if (s.getDivisionNumber().equalsIgnoreCase(d))
				sum += s.getSales();
		}
		return sum;
	}

	@Override
	public boolean addDivision(String d) {
		System.out.println("addDivision(Division d) method not yet implemented");
		return true;
	}
}
