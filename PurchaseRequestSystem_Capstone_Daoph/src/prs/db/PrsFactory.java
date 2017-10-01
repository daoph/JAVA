package prs.db;

public class PRSFactory {
	
	public static UserDAO getUserDAO() {
		UserDAO userDao = new UserDB();
		return userDao;
	}
	
	public static ProductDAO getProductDAO() {
		ProductDAO productDao = new ProductDB();
		return productDao;
	}
	
	public static VendorDAO getVendorDAO() {
		VendorDAO vendorDao = new VendorDB();
		return vendorDao;
	}
	
	public static PurchaseRequestDAO getPurchaseRequestDAO() {
		PurchaseRequestDAO purchaseRequestDao = new PurchaseRequestDB();
		return purchaseRequestDao;
	}
	
	public static PurchaseRequestLineItemsDAO getPurchaseRequestLineItemsDAO() {
		PurchaseRequestLineItemsDAO purchaseRequestLineItemsDao = new PurchaseRequestLineItemsDB();
		return purchaseRequestLineItemsDao;
	}
	
	public static StatusDAO getStatusDAO() {
		StatusDAO statusDao = new StatusDB();
		return statusDao;
	}
	

}
