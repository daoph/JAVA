
public class Store extends Facility {
	
	double sales;
	String storeNumber;
	String division = Division.divisionNumber;
	
	
	public Store() {
		super();
	storeNumber = null;
	division = "";
	sales = 0;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public String getStoreNumber() {
		return storeNumber;
	}


	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}
	
	
	public void storeString() {};
	
	
	


	
	
}
