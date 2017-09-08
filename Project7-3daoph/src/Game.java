
public class Game {
	
	public Game() {};
	
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println();
    }

   public int getRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

   
   
   public void displayPleaseGuessMessage() {
       System.out.println("I'm thinking of a number from 1 to 100.");
       System.out.println("Try to guess it.");
       System.out.println();
   }
    
   
   
   public void displayCorrectGuessMessage(int counter) {
       System.out.println("You got it in " + counter + " tries.");
       if (counter <= 3) {
           System.out.println("Great work! You are a mathematical wizard.\n");
       } else if (counter > 3 && counter <= 7) {
           System.out.println("Not too bad! You've got some potential.\n");
       } else {
           System.out.println("What took you so long? Maybe you should take some lessons.\n");
       }
   }
   
   
   public void displayGuessAgainMessage(int number, int guessNumber) {
       int difference = guessNumber - number;
       if (guessNumber > number) {
           if (difference > 10) {
               System.out.println("Way too high! Guess again.\n");            
           } else {
               System.out.println("Too high! Guess again.\n");
           }
       } else {
           if (difference < -10) {
               System.out.println("Way to low! Guess again.\n");
           } else {
               System.out.println("Too low! Guess again.\n");
           }
       }
   }
}
