
public class UserIOTestApp {

	public static void main(String[] args) {
		
		
		
		ConsoleIO.greeting();
		
		UserIO consoleIO = IOFactory.getUserIO();
		
		
		consoleIO.getInt("Enter an integer between -100 and 100: ", -101, 101);
		
		consoleIO.getdouble("\nEnter any number between -100 and 100: ", -101, 101);
		
		consoleIO.getString("\nEnter your email address: ");
		
		consoleIO.getString("\nSelect one (x/y)", "x","y");

	}

}
