import java.util.Scanner;

public class FactorialCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Factorial Calculator");
		System.out.println();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		long factOne = 1;

		while (choice.equalsIgnoreCase("y")) {

			System.out.print("Enter an integer that's greater than 0 and less than 10: ");
			int intCtrl = sc.nextInt();

			for (int idx = 1; idx <= intCtrl; idx++) {
				factOne = factOne * idx;
			}
			
			System.out.println("The factorial of " + intCtrl + " is " + factOne);
			System.out.println();
			factOne = 1;
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
}
