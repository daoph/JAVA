
public class Circle extends Shape {

	int radius;
	
	
	
	public Circle(int r) {

		setRadius(r);
	}



	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}



	@Override
	double getArea() {
		return (int) ((Math.pow(radius, 2))*Math.PI);
	}
	
	
	

}
