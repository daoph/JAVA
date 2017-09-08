
public class IOFactory {

	public IOFactory() {
	}
	public static UserIO getUserIO() {
		UserIO xx = new ConsoleIO();
		return xx;
	}
}
