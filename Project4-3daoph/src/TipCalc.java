import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// say hello
		System.out.println("Tip Calculator");
		System.out.println();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Cost of Meal: ");
			String mealCost = sc.next();
			System.out.println();

			// logic
			BigDecimal mealBigD = new BigDecimal(mealCost);
			BigDecimal mealTip15 = mealBigD.multiply(new BigDecimal("0.15"));
			BigDecimal mealTip20 = mealBigD.multiply(new BigDecimal("0.20"));
			BigDecimal mealTip25 = mealBigD.multiply(new BigDecimal("0.25"));
			BigDecimal mealTot15 = mealBigD.add(mealTip15);
			BigDecimal mealTot20 = mealBigD.add(mealTip20);
			BigDecimal mealTot25 = mealBigD.add(mealTip25);

			NumberFormat currency = NumberFormat.getCurrencyInstance();

			// display data
			System.out.print("15% \n" + "Tip Amount: " 
						+ currency.format(mealTip15) + "\n" + "Total amount: "
						+ currency.format(mealTot15) + "\n\n");
			System.out.print("20% \n" + "Tip Amount: " 
						+ currency.format(mealTip20) + "\n" + "Total amount: "
						+ currency.format(mealTot20) + "\n\n");
			System.out.print("25% \n" + "Tip Amount: " 
						+ currency.format(mealTip25) + "\n" + "Total amount: "
						+ currency.format(mealTot25) + "\n\n");
			// continue??
			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
	}
}
