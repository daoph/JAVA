import java.util.Scanner;

public class StringBitsApp {

	public static void main(String[] args) {
		// scanner in
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// welcome
		System.out.println("Welcome to the String Bits App");
		// get the string
		System.out.print("Enter a string: ");
		String strInput = sc.nextLine();

		// logic
		for (int i = 0; i < strInput.length(); i += 2) {
		// print
			System.out.print(strInput.charAt(i));
		}
	}
}
