package murach.db;

import murach.business.Customer;
import murach.business.CustomerNotFoundException;

public class CustomerDB {

	public static Customer getCustomer(int number) throws CustomerNotFoundException {
		Customer c = new Customer();
		switch (number) {
		case 1000:
			c.setName("Andrew Antosca");
			c.setAddress("485 Duane Terrace");
			c.setCity("Ann Arbor");
			c.setState("MI");
			c.setPostalCode("48108");
			return c;
		case 1001:
			c.setName("Barbara White");
			c.setAddress("3400 Richmond Parkway #3423");
			c.setCity("Bristol");
			c.setState("CT");
			c.setPostalCode("06010");
			return c;
		case 1002:
			c.setName("Karl Vang");
			c.setAddress("327 Franklin Street");
			c.setCity("Edina");
			c.setState("MN");
			c.setPostalCode("55435");
			return c;
		case 1003:
			c.setName("Ronda Chavan");
			c.setAddress("518 Comanche Dr.");
			c.setCity("Greensboro");
			c.setState("NC");
			c.setPostalCode("27410");
			return c;
		case 1004:
			c.setName("Sam Carol");
			c.setAddress("9379 N. Street");
			c.setCity("Long Beach");
			c.setState("CA");
			c.setPostalCode("90806");
			return c;
		default:

			throw new CustomerNotFoundException("No customer found for number " + number);
			
		}

	}

}