package gradeConvert;
import java.util.Scanner;

public class GradeConvert {
	public static void main(String[] args) {
		
	      // welcome the user to the program
	        System.out.println("Welcome to the Letter Grade Converter");
	      //created a scanner object
		    Scanner sc = new Scanner (System.in);
		    
		    String choice = "y";
		    
	while(choice.equalsIgnoreCase("y")) {
		    	
		
		     int numericalGrade = 0;
		    
		    System.out.print("Enter numerical grade: ");
		    numericalGrade = sc.nextInt();
		    
		    if (numericalGrade < 60) {
		    	System.out.println("F");
            }
		    if (numericalGrade >= 60 && numericalGrade <= 67) {
		    	System.out.println("D");
            }
		    if (numericalGrade >= 67 && numericalGrade <= 79) {
		    	System.out.println("C");
            }
		    if (numericalGrade >= 80 && numericalGrade <= 87) {
		    	System.out.println("B");
            }
		    if (numericalGrade >= 88 && numericalGrade <= 100) {
		    	System.out.println("A");
            }
		    
		
		
	
		    System.out.print("Continue? (y/n): ");
		    choice = sc.next();
           
	}    
		    
		
		    
		    
		    
		    
		    

	        
	        
	        
	        
	
	
	}
	
}
