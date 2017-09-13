package db;
import business.Store;

public interface BBWriter {
	boolean addStore(Store s);

	boolean addDivision(String d);
}
