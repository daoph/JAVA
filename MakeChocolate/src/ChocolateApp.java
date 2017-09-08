import java.util.Scanner;

public class ChocolateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Welcome to the Make Chocolate App");
		System.out.println();

		Calc calc = new Calc();
		Console console = new Console();

		
		while (choice.equalsIgnoreCase("y")) {
		int smallNumber = console.getInt("Please enter small value: ");
		int bigNumber = console.getInt("Please enter big value: ");
		int goalNumber = console.getInt("Please enter goal value: ");

		System.out.println(smallNumber);
		System.out.println(bigNumber);
		System.out.println(goalNumber);

		int theAnsr = calc.makeChocolate(smallNumber, bigNumber, goalNumber);

		System.out.println("You used " + theAnsr + " small bars.");
		System.out.print("Continue? (y/n): ");
		choice = sc.nextLine();
		
		}

	}

}
