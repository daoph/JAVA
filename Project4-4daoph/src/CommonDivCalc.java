import java.util.Scanner;

public class CommonDivCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// say hello
		System.out.println("Greatest Common Divisor Finder");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		int firstNbrX = 0;
		int secondNbrY = 0;

		while (choice.equalsIgnoreCase("y")) {
			System.out.println();

			// ask for input with validation
			boolean isValid = false;
			while (!isValid) {
				System.out.print("Enter first number: ");

				if (sc.hasNextInt()) {
					secondNbrY = sc.nextInt();
					isValid = true;
				} else {
					System.out.println("---Invalid Enter a valid first number!---");
				}
				sc.nextLine();
			}

			isValid = false;
			while (!isValid) {
				System.out.print("Enter second number: ");

				if (sc.hasNextInt()) {
					firstNbrX = sc.nextInt();
					isValid = true;
				} else {
					System.out.println("---Invalid! Enter a valid second number!---");
				}
				sc.nextLine();
			}

			// logic
			int counter = 0;
			while (secondNbrY != firstNbrX) {

				int newY = yMinusX(secondNbrY, firstNbrX); // method
				secondNbrY = firstNbrX; // swap X
				firstNbrX = newY; // and y values to check while statement.
				counter += 1;
				System.out.println("loop " + counter);
			}

			// display results
			System.out.println("Greatest common divisor: " + firstNbrX);
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
		}
	}

	private static int yMinusX(int y, int x) {

		while (y > x) {
			y = y - x;
			System.out.println("Y=" + y + " X=" + x);

		}
		return y;
	}

}
