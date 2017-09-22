package presentation;
import java.util.ArrayList;

import business.CountryIO;

public class CountryListManagerApp {
	
public static ArrayList<String> countries = new ArrayList<>();

	public static void main(String[] args) {
		CountryIO countryIO = new CountryIO();
		
		
		
		countries = countryIO.getCountries();
		
		
		
	}

}
