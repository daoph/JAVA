package prs.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PurchaseRequestLineItem implements Serializable {

	// the instance variables
	private int id;
	private int purchaseRequestID;
	private int productID;
	private int quantity;
	private Product product;

	// the constructors
	public PurchaseRequestLineItem() {
	}

	public PurchaseRequestLineItem(int id, int purchaseRequestID, int productID, int quantity) {
		this.id = id;
		this.purchaseRequestID = purchaseRequestID;
		this.productID = productID;
		this.quantity = quantity;
	}

	// the set and get methods
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	// custom methods

}
