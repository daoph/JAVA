package junit.pirate;
import java.awt.PageAttributes.PrintQualityType;

public class PirateApp {

	public static void main(String[] args) {
		Pirate p1 = new Pirate("Jack Black");
		System.out.println(p1.toString()+" # of pirates = "+Pirate.getNumPirates());
		Pirate p2 = new Pirate("Blackbeard");
		System.out.println(p2.toString()+" # of pirates = "+Pirate.getNumPirates());
		Pirate p3 = new Pirate("Stubby");
		System.out.println(p3.toString()+" # of pirates = "+Pirate.getNumPirates());
		
		printPirateStats();
		
		System.out.println("Pirate fight!!!");
		p1.loseALimb();
		p2.loseALimb();
		p2.loseALimb();
		p2.loseALimb();
		p2.loseALimb();
		p2.loseALimb();
		System.out.println(p1.getName() +" isDead? "+p1.isDead());
		System.out.println(p2.getName() +" isDead? "+p2.isDead());
		
		printPirateStats();
		
		System.out.println("Bye!");
	}

	private static void printPirateStats() {
		System.out.println("# of Pirates = "+Pirate.getNumPirates());
		System.out.println("# of limbs lost = "+Pirate.getTotalLimbsLost());		
	}
}
