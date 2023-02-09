
public class Browser {
	
	private static String[] historyURL;
	
	Browser(){}//Empty Constructor
	
	
	//set method for static field - historyURL
	public static void setHistory(String[] newHistory) {
		
		if (Browser.historyURL == null) {
			
			Browser.historyURL = new String[newHistory.length];
			Browser.historyURL = newHistory.clone();
		}
		else {
			
			Browser.historyURL = new String[newHistory.length + Browser.historyURL.length];
			Browser.historyURL = newHistory.clone();
		}
	
	}
	
	//get method for static field - historyURL
	public static String[] getHistory(){
		
		return Browser.historyURL;
		
	}
	
	Browser(String[] newHistory){
		Browser.setHistory(newHistory);
	}
	
}
