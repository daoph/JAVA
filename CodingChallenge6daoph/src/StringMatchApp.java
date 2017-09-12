import java.util.Scanner;

public class StringMatchApp {

	public static void main(String[] args) {
		// scanner in
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// welcome
		System.out.println("Welcome to the String Match App");
		// get the string
		System.out.print("Enter a string A: ");
		String strAInput = sc.nextLine();
		System.out.print("Enter a string B: ");
		String strBInput = sc.nextLine();

		// set Arrays A and B
		String[] aInput = new String[strAInput.length()];
		for (int i = 0; i < strAInput.length() - 1; i++) {
			aInput[i] = strAInput.substring(i, i + 2);
			System.out.println(aInput[i]); //console log
		}

		String[] bInput = new String[strBInput.length()];
		for (int i = 0; i < strBInput.length() - 1; i++) {
			bInput[i] = strBInput.substring(i, i + 2);
			System.out.println(bInput[i]); //console log
		}

		// compare array elements
		int count = 0;

		for (int i = 0; i < aInput.length-1; i++) {

			for (int j = 0; j < bInput.length-1; j++) {
				if (aInput[i].equalsIgnoreCase(bInput[j])) {
					count++;
					
				}	
			}
		}
		System.out.println("Pairs of letters equal: " + count);	
	}
}
