
public class Sheep extends Animal {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void incrementCount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetCount() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCountString() {
		int sheep = 0;
		String s = name + String.valueOf(sheep);
		return s;
	}

}
