import java.util.Scanner;

public class FirstLast6 {

	public static void main(String[] args) {

		// import scanner
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "";

		System.out.println("Welcome to the First Last 6 Arrays App.\n");

		System.out.print("Type 'Start' to begin: ");
		choice = sc.nextLine();
		while (choice.equalsIgnoreCase("start")) {

			// generate random array size
			int rndmNbr = (int) (Math.random() * 10 + 1);

			/**
			 * create and add random numbers to array @ rndmElement()
			 */
			int gameArray[] = new int[rndmNbr];
			for (int i = 0; i < gameArray.length; i++) {
				gameArray[i] += rndmElement();
			}

			// print array
			for (int i = 0; i < gameArray.length; i++)
				System.out.print(gameArray[i] + "  ");

			// set first and last numbers
			int firstNbr = gameArray[0];
			int lastNbr = gameArray[gameArray.length - 1];

			// check for number 6
			if (firstNbr == 6 || lastNbr == 6) {
				System.out.print("--> true");
			} else {
				System.out.print("--> false");
			}

			// play again
			System.out.println();
			System.out.print("play again? (y/n): ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				choice = "start";
			}
		}
	}

	// method to create random number
	public static int rndmElement() {
		int nbr = (int) (Math.random() * 10 + 1);
		return nbr;
	}
}
