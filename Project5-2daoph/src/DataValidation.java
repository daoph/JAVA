import java.util.Scanner;

public class DataValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcom to the Area and Perimeter Calculator!");
		System.out.println();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		boolean soTrue = false;
		double lengthCtrl = 0;
		double widthCtrl = 0;
		while (choice.equalsIgnoreCase("y")) {

			soTrue = false;

			while (soTrue != true) {
				System.out.print("Please enter length: ");
				if (sc.hasNextDouble()) {
					lengthCtrl = sc.nextDouble();
					double lengthX = getDoubleLengthWithinRange(lengthCtrl, 0, 1000000);
					System.out.println("checked length");
					soTrue = true;
					lengthCtrl = lengthX;
				} else {
					System.out.println("Please enter a valid number!");
					sc.nextLine();
					soTrue = false;
				}

			}

			soTrue = false;
			while (soTrue != true) {
				System.out.print("Please enter width: ");

				if (sc.hasNextDouble()) {
					widthCtrl = sc.nextDouble();
					double widthX = getDoubleWidthWithinRange(widthCtrl, 0, 1000000);
					System.out.println("checked width");
					soTrue = true;
					widthCtrl = widthX;
				} else {
					System.out.println("Please enter a valid number!");
					sc.nextLine();
					soTrue = false;
				}

			}

			double areaAns = lengthCtrl * widthCtrl;
			double areaPerimeter = (2.0 * lengthCtrl) + (2.0 * widthCtrl);
			System.out.println("Area: " + areaAns);
			System.out.println("Perimeter: " + areaPerimeter);
			lengthCtrl = 0.0;
			widthCtrl = 0.0;
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();

		}
	}

	public static double getDoubleLengthWithinRange(double lengthCtrlX, double min, double max) {
		Scanner sc = new Scanner(System.in);

		if (lengthCtrlX > max) {
			System.out.print("Please Enter a length value less than " + max + ": ");
			lengthCtrlX = sc.nextDouble();
			sc.nextLine();
		} else if (lengthCtrlX < min) {
			System.out.print("Please Enter a length value more than " + min + ": ");
			lengthCtrlX = sc.nextDouble();
			sc.nextLine();
		}
		return lengthCtrlX;

	}

	public static double getDoubleWidthWithinRange(double widthCtrlX, double min, double max) {
		Scanner sc = new Scanner(System.in);

		if (widthCtrlX > max) {
			System.out.print("Please Enter a width value less than " + max + ": ");
			widthCtrlX = sc.nextDouble();
			sc.nextLine();
		} else if (widthCtrlX < min) {
			System.out.print("Please Enter a width value more than " + min + ": ");
			widthCtrlX = sc.nextDouble();
			sc.nextLine();
		}
		return widthCtrlX;

	}
};
