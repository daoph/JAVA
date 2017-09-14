
public class ReservationCalc {

	public static void main(String[] args) {
		System.out.println("Reservation Calculator \n");
		
		String arrivalDate = Reservation.getArrivalDateFormatted();
		
		String departureDate = Reservation.getDepartureDateFormatted();
		System.out.println();

		System.out.println("Arrival Date: " + arrivalDate);
		System.out.println("Departure Date: " + departureDate);
		
		
		
		System.out.println("Price: " + Reservation.getPricePerNightFormatted() + " per night");
		System.out.println("Total price for " + Reservation.getNumberOfNights() 
		+ " nights is " + Reservation.getTotalPriceFormatted());
	}

}
