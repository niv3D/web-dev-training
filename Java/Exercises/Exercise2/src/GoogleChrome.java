
public class GoogleChrome extends Browser{
	
	GoogleChrome(String[] historyURL) {
		
		super(historyURL);
	}
	
	GoogleChrome() {
		
		super();
	}
	
	
	@Override
	public void whoAmI() {
		System.out.println("I am Google Chrome");
	}
	
}
