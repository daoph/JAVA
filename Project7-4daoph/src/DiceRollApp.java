import java.util.Scanner;

public class DiceRollApp {

	public static void main(String[] args) {
		// Welcome
		System.out.println("Welcome to the Dice Roller!");
		System.out.println();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		Dice dice = new Dice();
		
		System.out.print("Roll the Dice? (y/n): ");	
		String choice = sc.nextLine();
		
		
		while (choice.equalsIgnoreCase("y")) {

			dice.roll();
			dice.printRoll();


			System.out.print("Roll the Dice? (y/n): ");	
			choice = sc.nextLine();

		}

	}

}
