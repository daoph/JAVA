package prs.db;



public interface PurchaseRequestWriter {

	int writePRToDatabase(String userID, String description, String justification, String dateneeded, String deliveryMode,String status, double total);
	
	void writePRToDatabase(String description, double total);
	
	void writePRApproved(int generatedKey);
	
	void writeManagerApproved(int id);
	
	void writeManagerDenied(int id, String s);
}
