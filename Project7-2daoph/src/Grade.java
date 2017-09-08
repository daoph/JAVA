
public class Grade {

	public int number;

	public Grade() {
		
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String showGrade() {
		String grade = "";
		
		if(number >= 88 && number <=100) {
			grade = "A";}
		else if(number >= 80 && number <=87) {
			grade = "B";}
		else if(number >= 67 && number <=79) {
			grade = "C";}
		else if(number >= 60 && number <=67) {
			grade = "D";}
		else {
			grade = "F";}
		
		return grade;
	}
	
	
	
}
