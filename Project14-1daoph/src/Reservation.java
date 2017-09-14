import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Reservation {
	
public static LocalDate arrivalDate;
public static LocalDate departureDate;
	
public static double nightlyRate = 145.00;




public static LocalDate getArrivalDate() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter arrival month (1-12): ");
	Month month = Month.of(sc.nextInt());
	 
	System.out.print("Enter arrival day (1-31): ");
	int dayOfMonth = sc.nextInt();
	
	System.out.print("Enter arrival year: ");
	int year = sc.nextInt();
	
	
	LocalDate date = LocalDate.of(year, month, dayOfMonth);
	return date;
}

public static String getArrivalDateFormatted() {

	arrivalDate = getArrivalDate();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
	String arrivalDateFormatted = dtf.format(arrivalDate);
	return arrivalDateFormatted;

	
}
//public setArrivalDate(LocalDate arrivalDate) {
//	
//}
public static LocalDate getDepartureDate() {
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter departure month (1-12): ");
	Month month = Month.of(sc.nextInt());
	 
	System.out.print("Enter departure day (1-31): ");
	int dayOfMonth = sc.nextInt();
	
	System.out.print("Enter departure year: ");
	int year = sc.nextInt();
	
	
	LocalDate date = LocalDate.of(year, month, dayOfMonth);
	return date;
}
public static String getDepartureDateFormatted() {
	
	departureDate = getDepartureDate();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
	String departureDateFormatted = dtf.format(departureDate);
	return departureDateFormatted;
	
}
//public setDepartureDate(LocalDate departureDate) {
//	
//}
public static int getNumberOfNights() {
	int nights = (int) ChronoUnit.DAYS.between(arrivalDate, departureDate);
	return nights;
	
}
public static String getPricePerNightFormatted() {
	
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	String rate = formatter.format(nightlyRate);
	return rate;
	
}
public static double getTotalPrice() {
	
	double nights = getNumberOfNights();
	double totalPrice = nights * nightlyRate;
	return totalPrice;
	
}
public static String getTotalPriceFormatted() {
	NumberFormat formatter = NumberFormat.getCurrencyInstance();
	String rate = formatter.format(getTotalPrice());
	return rate;
	
}
}
