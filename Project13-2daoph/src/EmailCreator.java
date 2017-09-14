
public class EmailCreator {

	private static String[] csv = { "james,butler,jbutler@gmail.com", "Josephine,Darakjy,Josephine_Darakjy@darakjy.org",
			"ART,VENERE,ART@VENERE.ORG" };

	private static String template = "To:      {email}\n" + "From:    noreply@deals.com\n" + "Subject: Deals!\n\n"
			+ "Hi {first_name},\n\n" + "We've got some great deals for you. Check our website!";

	static String[] emailElements = new String[csv.length];

	public static void main(String[] args) {

		for (int i = 0; i < csv.length; i++) {

			emailElements = csv[i].split(",");
			String email = emailElements[2];
			String firstName = emailElements[0];
			String template2 = template;
			email = email.toLowerCase();
			firstName = firstName.toLowerCase();
		
			
			
			 template2 = template2.replace("{email}", email);
			 template2 = template2.replace("{first_name}", firstName);

			System.out.println(template2);
			System.out.println("================================================================\n");

			
		}

	}

}
