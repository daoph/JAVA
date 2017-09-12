package db;

public interface BBReader {

	ArrayList<Store> listAllStores();
	ArrayList<Store> listAllStores(String d);
	double getSalesSummary();
	double getSalesSummary(Stringd);
}
