import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
	    String choice = "y";
		System.out.println("Welcome the Odd/Even Checker!");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
				
		//get input
		while (choice.equalsIgnoreCase("y")){
			
		MyConsole mc = new MyConsole();
		
		mc.getString("Enter an integer: ");
		
		
		
		
		//check data

		
		System.out.println("Continue? (y/n)");
		choice= sc.next();
		
		
		
		}

		
		
		
	}

}
