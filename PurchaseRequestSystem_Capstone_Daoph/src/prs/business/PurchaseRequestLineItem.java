package prs.business;

public class PurchaseRequestLineItem {
	
	private int id;
	private int purchaseRequestID;
	private int productID;
	private int quantity;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPurchaseRequestID() {
		return purchaseRequestID;
	}
	public void setPurchaseRequestID(int purchaseRequestID) {
		this.purchaseRequestID = purchaseRequestID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
