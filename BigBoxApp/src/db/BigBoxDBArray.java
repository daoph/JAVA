package db;

import business.Store;

public class BigBoxDBArray {

	Store[] stores;

	public BigBoxDBArray() {
		populateStores();

	}

	private void populateStores() {

		stores = new Store[5];

		stores[0] = new Store(1, "001", "00011", 25000, "Mason BigBox", "5711 Fields Ertel Rd.",
								"Mason", "OH", "45249");
		stores[1] = new Store(2, "001", "00255", 27500, "Downtown BigBox", "9330 Main St.", 
								"Cincinnati", "OH", "45202");
		stores[2] = new Store(3, "001", "00172", 32555.55, "Goshen BigBox", "6777 Goshen Rd.", 
								"Goshen", "OH", "45122");
		stores[3] = new Store(4, "001", "00075", 21425.37, "Bridgetown BigBox", "3888 Race Rd.", 
								"Cincinnati", "OH", "45211");
		stores[4] = new Store(5, "111", "00001", 14432.77, "Louisville BigBox", "1111 Washington St.", 
								"Louisville", "KY", "40206");
		stores[5] = new Store(6, "111", "00044", 17555.11, "Lawrenceburg BigBox", "8000 Liberty St.", 
								"Louisville", "KY", "40204");

	}
}
