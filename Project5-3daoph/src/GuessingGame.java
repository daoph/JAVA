import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nbrLimit = 100;
		int rndmNbr = 0;
		boolean isValid = false;
		int guessNbr = 0;
		String choice = "y";
		int guessCounter = 0;

		System.out.println("Welcome to the Guess Number Name");
		System.out.println("++++++++++++++++++++++++++++++++");
		System.out.println("I'm thinking of a number from one to " + nbrLimit + ". \nTry to guess it.");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (choice.equalsIgnoreCase("y")) {
			rndmNbr = (int) Math.round(Math.random() * nbrLimit);
			System.out.println(rndmNbr);
			isValid = false;

			while (isValid != true) {

				guessNbr = getIntWithinRange(sc, "Enter a number: ", 1, 100);
				guessCounter++;

				if (guessNbr + 10 < rndmNbr) {
					System.out.println("This is way too low");
					isValid = false;
				} else if (guessNbr < rndmNbr) {
					System.out.println("This is too low");
					isValid = false;
				} else if

				(guessNbr > rndmNbr + 10) {
					System.out.println("This is way too high");
					isValid = false;
				} else if (guessNbr > rndmNbr) {
					System.out.println("This is too high");
					isValid = false;
				} else {
					System.out.println("Yay! You got it in " + guessCounter + " tries!");
					if (guessCounter < 3) {
						System.out.println("Great work! You are a mathematical wizard!");
					} else if (guessCounter > 3 && guessCounter < 7) {
						System.out.println("Not too bad! You've got some potential!");
					} else {
						System.out.println("You have some work to do...");
					}

				}

			}

			System.out.println(guessCounter);

			System.out.print("Continue? y/n: ");
			choice = sc.next();

		}

	}
//method validates Integer and within range.
	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt(sc, prompt);//uses getInt method
			if (i <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (i >= max) {
				System.out.println("Error! Number must be less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return i;
	}

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}
}
