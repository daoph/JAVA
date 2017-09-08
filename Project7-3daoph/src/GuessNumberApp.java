import java.util.Scanner;

public class GuessNumberApp {

	public static void main(String[] args) {
		Game newGame = new Game();

		newGame.displayWelcomeMessage();

		// create the Scanner object
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// generate the random number and invite user to guess it
			int number = newGame.getRandomNumber();
			newGame.displayPleaseGuessMessage();

			// continue until the user guesses the number
			int guessNumber = 0;
			int counter = 1;
			while (guessNumber != number) {
				// get a valid int from user
				guessNumber = Console.getIntWithinRange(sc, "Enter number: ", 0, 101);

				// display result of guess to user
				if (guessNumber == number) {
					newGame.displayCorrectGuessMessage(counter);
				} else {
					newGame.displayGuessAgainMessage(number, guessNumber);
				}
				counter++;
			}

			// see if the user wants to continue
			choice = Console.getChoiceString(sc, "Try again? (y/n): ", "y", "n");
			System.out.println();
		}
		System.out.println("Bye - Come back soon!");
		System.out.println();
	}

}