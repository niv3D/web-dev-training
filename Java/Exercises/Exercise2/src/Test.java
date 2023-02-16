
public class Test {

	public static void main(String[] args) {
		Browser tabOne = new GoogleChrome();
		Browser tabTwo = new Firefox();
		Browser tabThree = new Firefox();
		Browser tabFour= new GoogleChrome();
		Browser tabFive= new GoogleChrome();
		Browser[] allBrowsers = new Browser[5];
		
		allBrowsers[0] = tabOne;
		allBrowsers[1] = tabTwo;
		allBrowsers[2] = tabThree;
		allBrowsers[3] = tabFour;
		allBrowsers[4] = tabFive;
		
		int chromeTabs = 0;
		
		for(Browser tab: allBrowsers ) {
			
			if(tab instanceof GoogleChrome) chromeTabs++;
			
		}
		
		System.out.println("Chrome tabs open : " + chromeTabs);
		
		
		GoogleChrome.setPermissions("camera","microphone");
		
	}

}
