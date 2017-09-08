import java.util.Scanner;

public class RotateLeft {

	public static void main(String[] args) {

		// import scanner
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "";

		System.out.println("Welcome to the Rotate Left App.\n");

		System.out.print("Type 'Start' to begin: ");
		choice = sc.nextLine();

		while (choice.equalsIgnoreCase("start")) {

			System.out.print("Specify Array Length: ");
			int arrayChoice = sc.nextInt();
			sc.nextLine();

			/**
			 * create and add random numbers to array @ rndmElement()
			 */
			int gameArray[] = new int[arrayChoice];

			for (int i = 0; i < gameArray.length; i++) {
				gameArray[i] += rndmElement();
			}
			// print array
			for (int i = 0; i < gameArray.length; i++)
				System.out.print(gameArray[i] + "  ");

			// get first array element
			int firstNbr = gameArray[0];

			System.out.println();

			// print array, shifted left, missing last array element
			for (int i = 1; i < gameArray.length; i++)
				System.out.print(gameArray[i] + "  ");

			// set last array element
			gameArray[gameArray.length - 1] = firstNbr;
			// print last array element
			System.out.print(gameArray[gameArray.length - 1] + "  ");

			// play again
			System.out.println();
			System.out.print("play again? (y/n): ");
			choice = sc.nextLine();
			System.out.println();
			if (choice.equalsIgnoreCase("y")) {
				choice = "start";
			}
		}
	}

	// method to create random integer
	public static int rndmElement() {
		int nbr = (int) (Math.random() * 10 + 1);
		return nbr;
	}
}
