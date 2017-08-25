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
			System.out.print("Enter first number: ");
			secondNbrY = sc.nextInt();
			System.out.print("Enter second number: ");
			firstNbrX = sc.nextInt();

			// logic

			while (secondNbrY != firstNbrX) {

				int newY = yMinusX(secondNbrY, firstNbrX);
				secondNbrY = firstNbrX;
				firstNbrX = newY;
			}

			//display results
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
