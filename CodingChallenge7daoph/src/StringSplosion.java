import java.util.Scanner;

public class StringSplosion {

	public static void main(String[] args) {
		// scanner in
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		// welcome
		System.out.println("Welcome to the StringSplosion");
		// get the string
		System.out.print("Enter a string: ");
		String strInput = sc.nextLine();

		// logic

		for (int i = 0; i < strInput.length(); i++) {
			System.out.print(strInput.substring(0, i + 1));
		}
	}
}