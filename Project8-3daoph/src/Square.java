
public class Square extends Shape {

	
	double width;
	
	
	
	
	public Square(double w) {
		width = w;
	}




	public double getWidth() {
		return width;
	}




	public void setWidth(double width) {
		this.width = width;
	}




	@Override
	double getArea() {
		return Math.pow(width, 2);
	}

}
