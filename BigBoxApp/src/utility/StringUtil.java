package utility;

public class StringUtil {

    public static String pad(String s, int length) {
    	return pad(s," ",length);
    }
    
    public static String pad(String s, String p, int length) {
        if (s.length() < length) {
            // append the pad variable until the string is length
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length) {
                sb.append(p);
            }
            return sb.toString();
        } else {
            // truncate the string to the specified length
            return s.substring(0, length);
        }
    }
}
