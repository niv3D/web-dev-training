
public class Browser {
	
	private static String[] historyURL;
	
	Browser(){}//Empty Constructor
		
	public static void setHistory(String[] newHistory) {
		
		Browser.historyURL = new String[newHistory.length];
		
		Browser.historyURL = newHistory.clone();
	
	}
	
	public static String[] getHistory(){
		
		return Browser.historyURL;
	}
	
}
