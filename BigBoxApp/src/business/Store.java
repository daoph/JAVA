package business;

import java.io.Serializable;

import utility.Formatter;

@SuppressWarnings("serial")
public class Store extends Facility implements Serializable {
	private Division division;
	private String storeNumber;
	private double sales;

	public Store(int id, Division inDiv, String inStoreNbr, double inSales, String inFacName,
			String inFacAddress, String inFacCity, String inFacState, String inFacZip) {
		this(inDiv, inStoreNbr, inSales, inFacName, inFacAddress, inFacCity, inFacState, inFacZip);
		setId(id);
	}
	public Store(Division inDiv, String inStoreNbr, double inSales, String inFacName,
			String inFacAddress, String inFacCity, String inFacState, String inFacZip) {
		super();
		setDivision(inDiv);
		setStoreNumber(inStoreNbr);
		setSales(inSales);
		setName(inFacName);
		setAddress(inFacAddress);
		setCity(inFacCity);
		setState(inFacState);
		setZipCode(inFacZip);
	}
	public Store() {
		super();
	}
	
	public int getDivID() {
		return getDivision().getId();
	}
	
	public Division getDivision() {
		return division;
	}
	
	public String getDivisionNumber() {
		return getDivision().getDivisionNumber();
	}
	public void setDivision(Division d) {
		division = d;
	}
	
	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}

	public String toString() {
		return "[Store: div#="+getDivisionNumber()+", store#="+getStoreNumber()+", sales="+Formatter.getFormattedDouble(getSales())+"], "+ super.toString();
	}
	public String[] toStringArray() {
		String[] stringArray = new String[9];
		stringArray[0] = getDivisionNumber();
		stringArray[1] = getStoreNumber();
		stringArray[2] = Double.toString(getSales());
		stringArray[3] = Double.toString(getId());
		stringArray[4] = getName();
		stringArray[5] = getAddress();
		stringArray[6] = getCity();
		stringArray[7] = getState();
		stringArray[8] = getZipCode();
		
		return stringArray;
	}
}
