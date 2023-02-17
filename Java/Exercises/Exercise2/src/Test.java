
public class Test {

	public static void main(String[] args) {
		Browser tabOne = new GoogleChrome();
		Browser tabTwo = new Firefox();
		Browser tabThree = new Firefox();
		Browser tabFour = new GoogleChrome();
		Browser tabFive = new GoogleChrome();
		Browser[] allBrowsers = new Browser[5];

		allBrowsers[0] = tabOne;
		allBrowsers[1] = tabTwo;
		allBrowsers[2] = tabThree;
		allBrowsers[3] = tabFour;
		allBrowsers[4] = tabFive;

		int chromeTabs = 0;

		for (Browser tab : allBrowsers) {

			if (tab instanceof GoogleChrome)
				chromeTabs++;

		}

		System.out.println("Chrome tabs open : " + chromeTabs);

		AccessKeys camera = AccessKeys.CAMERA;
		AccessKeys location = AccessKeys.LOCATION;

		GoogleChrome.setPermissions(camera, location);

		GoogleChrome.showAccess();

		Firefox browserFirefox = (Firefox) tabTwo;

		browserFirefox.addContainer("facebookContainer");
		browserFirefox.addContainer("Mails");
		browserFirefox.addContainer("PrivateBrowsing");

		String[] containers = browserFirefox.viewAllContainers();

		for (String it : containers) {

			System.out.print(it + "; ");
		}

		browserFirefox.leaveContainer("PrivateBrowsing");

		System.out.println();

		containers = browserFirefox.viewAllContainers();

		for (String it : containers) {

			System.out.print(it + "; ");
		}
	}

}
