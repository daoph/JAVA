import java.util.Scanner;

public class TableOfPowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// say hello
		System.out.println("Welcome to the Squares and Cubes Table");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		String table = "";
		while (choice.equalsIgnoreCase("y")) {
			System.out.println();
			System.out.print("Enter an integer: ");
			int numberCtrl = sc.nextInt();

			System.out.println(numberCtrl);

			table = "Number	Squared	Cubed \r" 
					+ "======	=======	===== \r";

			for (int i = 1; i < (numberCtrl + 1); i++) {
				String tableRow = i + "\t" + i * i + "\t" + i * i * i + "\n";

				table += tableRow;
			}

			System.out.println(table);
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
		}
	}
}
