import java.util.Scanner;

public class ChangeCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Change Calculator");
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		int quart = 0;
		int dime = 0;
		int nickel = 0;
		int penny = 0;
		int numbMod = 0;
		int numbMod2 = 0;

		// accepts inputs
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter number of cents (0-99): ");
			int numberCents = sc.nextInt();

			if (numberCents / 25 != 0) {
				quart = numberCents / 25;
				numbMod = numberCents % 25;
			} else {
				numbMod = numberCents;
			}
			if (numbMod / 10 != 0) {
				dime = numbMod / 10;
				numbMod2 = numbMod % 10;
			} else {
				numbMod2 = numbMod;
			}
			if (numbMod2 / 5 != 0) {
				nickel = numbMod2 / 5;
				penny = numbMod2 % 5;
			} else {
				penny = numbMod2;
			}

			// display results
			System.out.println();
			System.out.println("Quarters: " + quart);
			System.out.println("Dimes:    " + dime);
			System.out.println("Nickels:  " + nickel);
			System.out.println("Pennies:  " + penny);
			System.out.println();
			numberCents = 0;
			quart = 0;
			dime = 0;
			nickel = 0;
			penny = 0;
			numbMod = 0;
			numbMod2 = 0;
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();

		}
	}

}
