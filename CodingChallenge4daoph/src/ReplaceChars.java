import java.util.Scanner;

public class ReplaceChars {

	public static void main(String[] args) {

		// import scanner
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";

		System.out.println("Welcome to Replace Characters App.\n");

		while (choice.equalsIgnoreCase("y")) {
			
			System.out.print("Type a sentence: ");
			String sentenceInput = sc.nextLine();
			
			//Convert string to string array
			String[] ary = sentenceInput.split("");
			
			
			//check for vowels
			for (int i=0; i < ary.length; i++) {
				
				if(ary[i].equalsIgnoreCase("a")|| ary[i].equalsIgnoreCase("e") || ary[i].equalsIgnoreCase("i")
						|| ary[i].equalsIgnoreCase("o") ||  ary[i].equalsIgnoreCase("u")) {
					
					ary[i] = "_";			
				} 		
			}	
			//print new sentence
			for (int i=0; i < ary.length; i++) {
			System.out.print(ary[i]);
			}
		
			System.out.println();
			System.out.println("again? (y/n): ");
			choice = sc.nextLine();
		};

	}
}
