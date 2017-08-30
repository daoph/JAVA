import java.util.Scanner;

public class DiceRoller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// say hello
		System.out.println("Dice Roller");
		System.out.println();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		double roll1 = 0;
		double roll2 = 0;

		System.out.print("Roll the dice? (y/n): ");
		choice = sc.next();

		while (choice.equalsIgnoreCase("y")) {

			roll1 = (int) (Math.random() * 6) + 1;
			roll2 = (int) (Math.random() * 6) + 1;
			;

			System.out.println("Die 1: " + roll1);
			System.out.println("Die 2: " + roll2);

			if (roll1 == 1.0 && roll2 == 1.0) {
				System.out.println("Snake Eyes!");
			} else if (roll1 == 6.0 && roll2 == 6.0) {
				System.out.println("Box Cars!");
			} 

				System.out.print("Roll again (y/n): ");
				choice = sc.next();
			
		}

	}
}
