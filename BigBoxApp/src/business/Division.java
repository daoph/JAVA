package business;

import business.Facility;

public class Division extends Facility {
	String divisionNumber;
	
	public Division() {
		super();
		divisionNumber = "";

	}
	
	public Division(int inId, String inDivNbr, String inFacName,
			String inFacAddress, String inFacCity, String inFacState, String inFacZip) {
		super();
		setId(inId);
		setDivisionNumber(inDivNbr);
		setName(inFacName);
		setAddress(inFacAddress);
		setCity(inFacCity);
		setState(inFacState);
		setZipCode(inFacZip);
	}
	public Division(String d) {
		setDivisionNumber(d);
	}

	public String getDivisionNumber() {
		return divisionNumber;
	}

	public void setDivisionNumber(String divisionNumber) {
		this.divisionNumber = divisionNumber;
	}
	
	@Override
	public String toString() {
		return ("Division:  [Div#: "+getDivisionNumber()+" ]\n" + super.toString());
	}
	
}