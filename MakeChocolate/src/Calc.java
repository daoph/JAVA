
public class Calc {

	private int small;
	private int big;
	private int goal;

	public Calc() {
	}

	public int getSmall() {
		return small;
	}

	public void setSmall(int small) {
		this.small = small;
	}

	public int getBig() {
		return big;
	}

	public void setBig(int big) {
		this.big = big;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int makeChocolate(int sM, int bG, int gL) {
		int leftOver;
		bG = bG * 5;
		leftOver = gL - bG;

		if (leftOver > sM) {
			leftOver = -1;
		}
		return leftOver;
	}
}
