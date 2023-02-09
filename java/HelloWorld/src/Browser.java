import javax.print.attribute.Size2DSyntax;

public class Browser {

	private static String[] history;

	public int arrayIndex = 0;
	public static int size;

	public Browser() {};

	public static void setHistory(String[] newHistory, int length) {
		size = length;
		history = new String[size];
		System.arraycopy(newHistory, 0, history, 0, size);
	}

	public Browser(String[] newHistory, int length) {

		size = length;
		history = new String[size];
		System.arraycopy(newHistory, 0, history, 0, size);

	}

}
