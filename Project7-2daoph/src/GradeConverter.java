
public class GradeConverter {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter");
		System.out.println();

		// new class object
		Grade number = new Grade();

		// get input
		int numb = Console.getInt("Enter numerical grade: ");
		number.setNumber(numb);

		//display grade
		System.out.println("Letter Grade: " + number.showGrade());
	
	}

}
