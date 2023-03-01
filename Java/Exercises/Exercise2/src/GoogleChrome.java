import java.util.ArrayList;
import java.util.List;

public class GoogleChrome extends Browser {

	private static List<String> historyStrings = new ArrayList<>();
	
	private static boolean isLocationAccessible;
	private static boolean isCameraAccessible;
	private static boolean isMicrophoneAccessible;

	public static final String VERSION_NUMBER = "1.0";

	GoogleChrome(String[] historyURL) {

		super(historyURL);
	}

	GoogleChrome() {

		super();
	}

	public static void showAccess() {

		System.out.println("Access Allowed for : ");
		System.out.println("Location : " + isLocationAccessible);
		System.out.println("Camera : " + isCameraAccessible);
		System.out.println("Microphone : " + isMicrophoneAccessible);

	}

	@Override
	public void whoAmI() {
		System.out.println("I am Google Chrome" + VERSION_NUMBER);
	}

	private static void setAccess(AccessKeys key) {

		if (key.equals(AccessKeys.CAMERA)) {
			isCameraAccessible = true;
		}
		if (key.equals(AccessKeys.MICROPHONE)) {
			isMicrophoneAccessible = true;
		}
		if (key.equals(AccessKeys.LOCATION)) {
			isLocationAccessible = true;
		}

	}

	public static void setPermissions(AccessKeys key1) {
		setAccess(key1);
	}

	public static void setPermissions(AccessKeys key1, AccessKeys key2) {

		setAccess(key1);
		setAccess(key2);

	}

	public static void setPermissions(AccessKeys key1, AccessKeys key2, AccessKeys key3) {

		setAccess(key1);
		setAccess(key2);
		setAccess(key3);

	}

	public void visitUrl(String url) {

		for(String content: historyStrings) {
			
			String urlContent[] = content.split(" ## ",2);
			
			if (url.equals(urlContent[0])) {
				
				String newUrlString = urlContent[0] + " ## " + Integer.valueOf(urlContent[1]);
				
				historyStrings.add(historyStrings.indexOf(url), newUrlString);
				
				
			}

		}

		historyStrings.add(url + " ## " + 1);

	}

	public void viewHistory() {

		System.out.println(historyStrings.toString());

	}
}
