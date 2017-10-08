package junit.pirate;
public class Pirate {

	protected String name;
	protected int limbsRemaining;
	protected static int numPirates = 0;
	protected static int totalLimbsLost = 0;

	public Pirate(String name) {
		this.name = name;
		limbsRemaining = 4;
		numPirates++;
	}

	public Pirate(String name, int limbs) {
		this.name = name;
		limbsRemaining = limbs;
		numPirates++;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public int getLimbsRemaining() {
		return limbsRemaining;
	}

	public boolean isDead() {
		return (limbsRemaining < 1);
	}

	public void loseALimb() {
		if (limbsRemaining == 0) {
			System.out.println(name + " has no limbs left to lose!");
		} else {
			limbsRemaining--;
			totalLimbsLost++;
			System.out.println("AAAARGH! " + name + " says, \"I lost me limb!\"");
		}
	}

	public static int getNumPirates() {
		return numPirates;
	}

	public static int getTotalLimbsLost() {
		return totalLimbsLost;
	}
}
