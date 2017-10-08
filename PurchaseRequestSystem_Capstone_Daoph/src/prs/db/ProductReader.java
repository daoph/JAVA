package prs.db;

import java.util.ArrayList;
import prs.business.Product;


public interface ProductReader {
	
	ArrayList<Product> listAllProducts();
	
	double getSum(String productCode, int vendorID, int quantity);

}
