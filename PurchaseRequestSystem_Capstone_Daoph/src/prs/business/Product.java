package prs.business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {

	// instance variables
	private int id;
	private int vendorID;
	private String vendorPartNumber;
	private String name;
	private double price;
	private String unit;
	private String photoPath;
	//This instance variable is added to be able to set a Vendor object into the Product object
	//also added getters and setters.
	private Vendor vendor;

	// the constructors
	public Product() {
	}

	public Product(int id, int vendorID, String vendorPartNumber, String name, double price, String unit,
			String photoPath) {
		this.id = id;
		this.vendorID = vendorID;
		this.vendorPartNumber = vendorPartNumber;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.photoPath = photoPath;
	}

	// the set get methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVendorID() {
		return vendorID;
	}

	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}

	public String getVendorPartNumber() {
		return vendorPartNumber;
	}

	public void setVendorPartNumber(String vendorPartNumber) {
		this.vendorPartNumber = vendorPartNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	// custom methods
	
}
