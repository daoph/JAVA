package prs.business;

public class Product {

	private int id;
	private int vendorID;
	private String vendorPartNumber;
	private String name;
	private double price;
	private String unit;
	private String photoPath;
	
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
	
	
	
	
	
	
}
