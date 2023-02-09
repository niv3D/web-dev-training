package Exercise1;
public class Test {

	public static void main(String[] args) {
		
		
		String[] urlSet1 = {"www.google.com","www.youtube.com","one.zoho.com"};
		String[] urlSet2 = {"www.github.com","dev.java","www.learncpp.com"};
		
		
		Browser chrome = new Browser();
		Browser.setHistory(urlSet1);
		
		
		
		for(String string: chrome.getHistory()) {
			System.out.print(string + ",");
		}
		
		
		System.out.println();
		
		
		Browser mozilla = new Browser(urlSet2);
		
		
		for(String string: mozilla.getHistory()) {
			System.out.print(string + ",");
		}
	
	}

}
