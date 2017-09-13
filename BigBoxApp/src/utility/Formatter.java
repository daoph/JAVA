package utility;

import java.text.NumberFormat;

public class Formatter {
	public static String getFormattedDouble(double d) {
		String str = "";
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		str = currency.format(d);
		return str;
	}
}
