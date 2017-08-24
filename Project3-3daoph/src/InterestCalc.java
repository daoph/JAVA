import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the Interest Calculator");
		Scanner sc = new Scanner(System.in);

		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			// receive user inputs
			System.out.print("Enter loan amount: ");
			double loanCtrl = sc.nextDouble();
			System.out.print("Enter interest rate: ");
			double interestRate = sc.nextDouble();

			// calculate!
			BigDecimal loanBig = new BigDecimal(loanCtrl);
			BigDecimal interestBig = new BigDecimal(interestRate);
			BigDecimal interestCalcBig = loanBig.multiply(interestBig).setScale(2, RoundingMode.HALF_UP);

			// format and display result
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMinimumFractionDigits(3);
			System.out.println();
			System.out.println("Loan amount: " + currency.format(loanCtrl));
			System.out.println("Interest rate: " + percent.format(interestRate));
			System.out.println("Interest: " + currency.format(interestCalcBig));

			System.out.println();
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();

		}
	}
}
