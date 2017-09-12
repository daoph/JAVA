package business;

public class Division extends Facility {

	public static String divisionNumber;

	public Division() {
		super();
		divisionNumber = null;	
	}

	public static String getDivisionNumber() {
		return divisionNumber;
	}

	public static void setDivisionNumber(String divisionNumber) {
		Division.divisionNumber = divisionNumber;
	}
}
