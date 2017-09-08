import java.util.Scanner;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator");
		Scanner sc = new Scanner(System.in);
		
		String input = Console.getString("Calculate the area of a circle, square or rectangle?(c,s,r)");
		Shape s;
		if (input.equalsIgnoreCase("c")) {
			int r = Console.getInt("Enter radius");
			s = new Circle (r);
		} else if (input.equalsIgnoreCase("s")) {
			int w = Console.getInt("Enter width");
		} else {\\
			int w = Console.getInt("Enter width");
			int h = Console.getInt("Enter height");
			s = new Rectangle(h,w);
		}
		
		
		Class c = s.getClass();
		
		System.out.println("The area for your" + c.getName() + " is: " + s.getArea());
		
		System.out.println("Goodbye");

	}

}
