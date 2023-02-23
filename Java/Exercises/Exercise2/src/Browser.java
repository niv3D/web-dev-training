
public class Browser {
	
	private static String[] historyURL;
	private static int numberOftabsOpen;
	private static Integer numberOftabsOpenObj = 0;
	
	Browser() {
		Browser.numberOftabsOpen++;
		Browser.numberOftabsOpenObj++;
	}// Empty Constructor
	
	
	Browser(String[] newHistory) {
		Browser.setHistory(newHistory);
		Browser.numberOftabsOpen++;
		Browser.numberOftabsOpenObj++;
	}
	
	public static int getNumberOfTabs() {
		return Browser.numberOftabsOpen;
	}
	
	public static Integer getNumberOfTabsObj() {
		return Browser.numberOftabsOpenObj;
	}
	
	
	
	// set method for static field - historyURL
	public static void setHistory(String[] newHistory) {

		if (Browser.historyURL == null) {

			Browser.historyURL = new String[newHistory.length];
			Browser.historyURL = newHistory.clone();
			
		} else {

			String[] tempURL = new String[newHistory.length + Browser.historyURL.length];

			System.arraycopy(Browser.historyURL, 0, tempURL, 0, Browser.historyURL.length);
			System.arraycopy(newHistory, 0, tempURL, Browser.historyURL.length, newHistory.length);

			Browser.historyURL = tempURL;

		}

	}

	// get method for static field - historyURL
	public String[] getHistory() {

		return Browser.historyURL;

	}

	public void whoAmI() {
		
		System.out.println("I am a Browser");
	}

}
