import java.util.Scanner;

public class TimeTravelCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Say greeting!
		System.out.println("Welcome to the Time Travel Calculator");
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		double oneHundred = 100;
		double timeUnit = 60;

		while (choice.equalsIgnoreCase("y")) {
			// receive user inputs
			System.out.print("Enter miles: ");
			double mileCtrl = sc.nextDouble();
			System.out.print("Enter miles per hour: ");
			double mphCtrl = sc.nextDouble();
			// process calculations

			int hours = (int) (mileCtrl / mphCtrl);
			double minutesMod = (mileCtrl % mphCtrl);

			double minutes = minutesMod * timeUnit;

			minutes = (minutes / oneHundred);

			int results = (int) minutes;

			// results
			System.out.println();
			System.out.println("Estimated Travel Time");
			System.out.println("---------------------");
			System.out.println("Hours: " + hours);
			System.out.println("Minutes: " + results);
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}

	}

}
