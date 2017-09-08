
public class ContactList {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact List Application");
		//new Contact object
		Contact contact = new Contact();
		
		//add object data
		String firstN = Console.getString("Enter first name: ");
		contact.setFirstName(firstN);
		
		String lastN = Console.getString("Enter last name: ");
		contact.setLastName(lastN);
		
		String emailCtrl = Console.getString("Enter email: ");
		contact.setEmail(emailCtrl);
		
		String phoneN = Console.getString("Enter phone: ");
		contact.setPhone(phoneN);

		//create string
		
		System.out.println("--------------------------------------------");
		System.out.println("---- Current Contact -----------------------");
		System.out.println("--------------------------------------------");
		System.out.println("Name:					"+ contact.getFirstName() +" "+ contact.getLastName());
		System.out.println("Email Address:				" + contact.getEmail());
		System.out.println("Phone Number:				"+ contact.getPhone());
		
	}

}
