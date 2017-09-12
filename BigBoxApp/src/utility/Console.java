package utility;
import java.util.Scanner;

public class Console {

	Scanner sc;
	
	public Console() {
		sc = new Scanner(System.in);
	}
	
	public int getInt(String prompt) {
		int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
	}

	public int getInt(String prompt, int min, int max) {
		int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i <= min) {
                System.out.println("Error! Number must be greater than " + min);
            } else if (i >= max) {
                System.out.println("Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
	}

	public double getDouble(String prompt) {
		double d = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid double value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
	}

	public double getDouble(String prompt, double min, double max) {
		double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d <= min) {
                System.out.println("Error! Number must be greater than " + min);
            } else if (d >= max) {
                System.out.println("Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return d;
	}

	public String getString(String prompt) {
		String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            s = sc.nextLine();
            if (s.equals("")) {
                System.out.println("Error! This entry is required. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
	}

	public String getString(String prompt, String s1, String s2) {
		String s = "";
        boolean isValid = false;
        while (!isValid) {
            s = getString(prompt);
            if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
                System.out.println("Error! Entry must be '" + s1 + "' or '" +
                        s2 + "'. Try again.");
            } else {
                isValid = true;
            }
        }
        return s;
	}

	public void print(String s) {
		System.out.print(s);

	}

	public void println() {
		System.out.println();

	}

	public void println(String s) {
		System.out.println(s
				
				);

	}

}
