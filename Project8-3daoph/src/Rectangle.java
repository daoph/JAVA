
public class Rectangle extends Square {

	double height;
	
	public Rectangle(double h, double w) {
		super(w);
		height = h;
		
	
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	double getArea() {
		return height * width;
	}
	
	
}
