package murach.presentation;
import murach.db.CustomerDB;
import utility.Console;
import murach.business.Customer;
import murach.business.CustomerNotFoundException;


public class CustomerViewerApp {

	public static void main(String[] args) throws CustomerNotFoundException {
		
		Console.displayString("Customer Viewer");
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {	
		
		Customer c = new Customer();
		int nbr = Console.getInt("Enter a customer number: ");
		
		c = CustomerDB.getCustomer(nbr);	
		
		System.out.println(c.getNameAndAddress());
		
		
		
		
		choice = Console.getString("Display another customer? (y/n): ");
		}
		Console.displayString("Bye!");
	}

}
