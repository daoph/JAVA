import java.util.Scanner;

public class MyConsole extends Console {
	
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
   
	public MyConsole() {super();}
   
   @Override
	public String getString(String prompt) {
		
		 System.out.print(prompt);
		 String s = sc.next(); 
		 sc.nextLine(); 
		if(s == null) {System.out.println("There is no value!");
		}	
	else {return super.getString(prompt);}
		return s;
	}

	
	
	
}
