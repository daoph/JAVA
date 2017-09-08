import java.util.Scanner;

public class ConsoleIO implements UserIO {

	Scanner sc;

	@SuppressWarnings("resource")

	public ConsoleIO() {
		sc = new Scanner(System.in);

	}

	@Override
	public int getInt(String prompt) {
		System.out.print(prompt);
		int nbr = sc.nextInt();
		return nbr;
	}

	@Override
	public int getInt(String prompt, int min, int max) {
		int nbr = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.print(prompt);
			nbr = sc.nextInt();

			if (nbr < min) {
				System.out.println("Error! Number must be greater than " + min);
			} else if (nbr > max) {
				System.out.println("Error! Number must be less than " + max);
			} else {
				isValid = true;
			}
			sc.nextLine();
		}
		return nbr;
	}

	@Override
	public double getdouble(String prompt) {
		System.out.print(prompt);
		double nbr = sc.nextInt();
		return nbr;
	}

	@Override
	public double getdouble(String prompt, double min, double max) {
		double nbr = 0;
		boolean isValid = false;

		while (!isValid) {
			System.out.print(prompt);
			nbr = sc.nextDouble();

			if (nbr < min) {
				System.out.println("Error! Number must be greater than " + min);
			} else if (nbr > max) {
				System.out.println("Error! Number must be less than " + max);
			} else {
				isValid = true;
			}
			sc.nextLine();
		}
		return nbr;
	}

	@Override
	public String getString(String prompt) {

		String x = "";
		boolean isValid = false;

		while (!isValid) {

			System.out.print(prompt);

			x = sc.nextLine();

			if (x.equals("")) {
				System.out.println("Error! This entry is required. Try again");
			} else {
				isValid = true;
			}

		}

		return x;
	}

	@Override
	public String getString(String prompt, String s1, String s2) {

		String x = "";
		boolean isValid = false;

		while (!isValid) {

			System.out.print(prompt);

			x = sc.nextLine();

			if (!x.equalsIgnoreCase(s1) && !x.equalsIgnoreCase(s2)) {
				System.out.print("Error! This entry must be x or y. Try again!\n");

			} else {
				isValid = true;
			}

		}
		return x;
	}

	@Override
	public void print(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void println() {
		// TODO Auto-generated method stub

	}

	@Override
	public void println(String s) {
		// TODO Auto-generated method stub

	}

	public static void greeting() {
		System.out.println("Welcome to the Console Tester application");
		System.out.println();

	}

}
