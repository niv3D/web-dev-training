
public class Firefox extends Browser{
	
	Firefox(String[] historyURL) {
		
		super(historyURL);
	}
	
	Firefox() {
		
		super();
	}
		
	@Override
	public void whoAmI() {
		System.out.println("I am Firefox");
	}
}
