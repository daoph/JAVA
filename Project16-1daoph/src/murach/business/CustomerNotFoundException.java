package murach.business;


@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception{
	

	public CustomerNotFoundException() {}
	
	public CustomerNotFoundException(String message) {
		super(message);
		System.out.println(message);
	}
	
}
