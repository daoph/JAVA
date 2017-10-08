package prs.db;

public interface PurchaseRequestLineItemsWriter {

	void writePrliToDatabase(int id, int productID, int quantity);
	
	
}
