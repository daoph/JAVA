package business;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountryIO {
	
	String fileString = "countries.txt";
	Path filePath = Paths.get(fileString);
	File countryFile = filePath.toFile();
	
	
	
	public ArrayList<String> getCountries(){
		
		ArrayList<String> array = new ArrayList<>();
		try(BufferedReader in = new BufferedReader(new FileReader(countryFile))){	
		} catch (IOException e) {System.out.println(e);}
		return array;
		
	}

	
	
	
	
	
	}




