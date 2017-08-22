import java.util.Scanner;

public class RectangleCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	      // welcome the user to the program
	        System.out.println("Welcome to the Rectangle Calculator");
	      //created a scanner object
		    Scanner sc = new Scanner (System.in);
		    
		    String choice = "y";
		    
		    
	while(choice.equalsIgnoreCase("y")){
		    
		    int length = 0;
		    int width = 0;
		    
		  System.out.print("Enter length: ");
		    length = sc.nextInt();
		    
		  System.out.print("Enter width: ");
		    width = sc.nextInt(); 
		    
		   int area = length * width;
		   
		   int perimiter = 2 * width + 2 * length;
		   
		   System.out.println("Area: " + area);
		   System.out.println("Width: " + width);
		   
		    
		   System.out.print("Continue? y or n ?: ");
		    choice = sc.next(); 
		
	}
	}

}
