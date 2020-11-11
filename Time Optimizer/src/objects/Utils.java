package objects;

public class Utils {
	public static String digitFormatter(int num, int numDigs) {
		return digitFormatter(numDigs, Integer.toString(num));
	}
	
	private static String digitFormatter(int numDigs, String previous) {
		if (previous.length()>=numDigs) {
			return previous;
		}
		else {
			return digitFormatter(numDigs, "0"+previous);
		}
	}
}
