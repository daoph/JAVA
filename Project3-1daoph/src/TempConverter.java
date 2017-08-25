import java.math.RoundingMode;
import java.util.Scanner;
import java.math.BigDecimal;

public class TempConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Say greeting!
		System.out.println("Welcome to the Temperature Converter!");

		Scanner sc = new Scanner(System.in);
		String choice = "y";
		double thirtyTwo = 32;
		double five = 5;
		double nine = 9;
		double fiveNine = five / nine;

		// while (choice.equalsIgnoreCase("y")) {
		//
		// System.out.print("Enter degrees in Farenheit: ");
		// String tempF = sc.next();
		//
		// BigDecimal partA = new BigDecimal(tempF);
		// partA = partA.subtract(new BigDecimal(thirtyTwo));
		// BigDecimal partB = new BigDecimal(fiveNine);
		// partA = partA.multiply(partB).setScale(2, RoundingMode.HALF_UP);
		//
		// System.out.println("Degrees in celsius: " + partA);
		//
		// System.out.print("Continue? (y/n): ");
		// choice = sc.next();
		// }

		while (choice.equalsIgnoreCase("y")) {
			
			System.out.println();
			System.out.print("Enter degrees in Farenheit: ");
			
			double tempF = sc.nextDouble();
			tempF = tempF - thirtyTwo;
			tempF = tempF * fiveNine;
			
			tempF = Math.round(tempF * 100.00)/100.00;


			System.out.println("Degrees in celsius: " + tempF);

			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
			sc.close();
		}
	}
}
