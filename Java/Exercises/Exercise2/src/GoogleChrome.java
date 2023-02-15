
public class GoogleChrome extends Browser{
	
	private static boolean isLocationAccessible;
	private static boolean isCameraAccessible;
	private static boolean isMicrophoneAccessible;
	
	public final String versionNumberString = "1.0";
	
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
	
	private static void setAccess(String access) {
		
		if(access.equals("camera")) isCameraAccessible = true;
		if(access.equals("microphone")) isMicrophoneAccessible = true;
		if(access.equals("location")) isLocationAccessible = true;
		
	}
	
	
	public static void setPermissions(String access1) {
		setAccess(access1);
	}
	
	public static void setPermissions(String access1,String access2) {
		
		setAccess(access1);
		setAccess(access2);
		
	}
	
	public static void setPermissions(String access1,String access2,String access3) {
		
		setAccess(access1);
		setAccess(access2);
		setAccess(access3);
		
	}
}
