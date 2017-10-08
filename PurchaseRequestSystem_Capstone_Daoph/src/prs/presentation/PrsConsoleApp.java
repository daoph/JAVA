package prs.presentation;

import java.util.ArrayList;


import prs.business.Product;
import prs.db.PRSFactory;
import prs.db.ProductDAO;


public class PrsConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("THIS IS THE CONSOLE TEST APP");
		
		
		ProductDAO dao = PRSFactory.getProductDAO();
		ArrayList<Product> product = dao.listAllProducts();
		
		String s = populateList(product);
		
		System.out.print(s);
		
	
	}
	
	
	public static String populateList(ArrayList<Product>products) {
		StringBuilder sb = new StringBuilder();
		for (Product p: products) {
			sb.append(p.getId() + "\t");
			sb.append(p.getVendorID() + "\t");
			sb.append(p.getVendorPartNumber() + "\t");
			sb.append(p.getName() + "\t");
			sb.append(p.getPrice() + "\t");
			sb.append(p.getUnit() + "\t");
			sb.append(p.getPhotoPath() + "\t");
			sb.append("\n");
		}
		return sb.toString();
	}
	
	

}
