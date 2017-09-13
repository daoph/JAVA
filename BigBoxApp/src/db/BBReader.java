package db;

import java.util.ArrayList;

import business.Store;

public interface BBReader {

	ArrayList<Store> listAllStores();

	ArrayList<Store> listAllStores(String d);

	double getSalesSummary();

	double getSalesSummary(String d);
}
