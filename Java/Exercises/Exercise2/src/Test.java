//import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

//		Browser tabOne = new GoogleChrome();
//		Browser tabTwo = new Firefox();
//		Browser tabThree = new Firefox();
//		Browser tabFour = new GoogleChrome();
//		Browser tabFive = new GoogleChrome();
//		Browser[] allBrowsers = new Browser[5];
//
//		allBrowsers[0] = tabOne;
//		allBrowsers[1] = tabTwo;
//		allBrowsers[2] = tabThree;
//		allBrowsers[3] = tabFour;
//		allBrowsers[4] = tabFive;
//
//		int chromeTabs = 0;
//
//		for (Browser tab : allBrowsers) {
//
//			if (tab instanceof GoogleChrome)
//				chromeTabs++;
//
//		}
//
//		System.out.println("Chrome tabs open : " + chromeTabs);
//
//		GoogleChrome.setPermissions(AccessKeys.CAMERA, AccessKeys.LOCATION);
//
//		GoogleChrome.showAccess();
//
//		Firefox browserFirefox = (Firefox) tabTwo;
//
//		browserFirefox.addContainer("facebookContainer");
//		browserFirefox.addContainer("Mails");
//		browserFirefox.addContainer("PrivateBrowsing");
//
//		String[] containers = browserFirefox.viewAllContainers();
//
//		System.out.print(Arrays.toString(containers));
//
//		browserFirefox.leaveContainer("PrivateBrowsing");
//
//		System.out.println();
//
//		containers = browserFirefox.viewAllContainers();
//
//		System.out.println(Arrays.toString(containers));
//
//		Integer numberOftabsInteger = Browser.getNumberOfTabs();
//		System.out.println("number of tabs open :" + numberOftabsInteger);
//
//		int numberOftabs = Browser.getNumberOfTabsObj();
//		System.out.println("number of tabs open :" + numberOftabs);
//
//		GoogleChrome newTabChrome = new GoogleChrome();
//
//		newTabChrome.visitUrl("www.twitter.com");
//		newTabChrome.viewHistory();
//
//		newTabChrome.visitUrl("www.facebook.com");
//		newTabChrome.viewHistory();
//
//		newTabChrome.visitUrl("www.twitter.com");
//		newTabChrome.viewHistory();
//
//		Browser.BookMarks newBookMarks = tabOne.new BookMarks();
//
//		newBookMarks.addBookMark("facebook", "www.facebook.com");
//		newBookMarks.addBookMark("twitter", "www.twitter.com");
//
//		newBookMarks.viewBookMarks();
//
//		newBookMarks.removeBookMark("twitter");
//		newBookMarks.viewBookMarks();
//
//		Browser tab6 = new Browser() {
//
//			@Override
//			public void whoAmI() {
//				System.out.println("Im an Anonymous inner class !");
//			}
//		};
//		
//		tab6.whoAmI();
		
		
		BrowserUI userInterface = new BrowserUI();
		
		userInterface.run();
		
		
		
	}
}
