
public class GoogleChrome extends Browser{
	
	private static boolean isLocationAccessible;
	private static boolean isCameraAccessible;
	private static boolean isMicrophoneAccessible;
	
	
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
	
	public static void setPermissions(String access) {
		
		if(access.equals("camera")) isCameraAccessible = true;
		if(access.equals("Microphone")) isMicrophoneAccessible = true;
		if(access.equals("Location")) isLocationAccessible = true;
	}
	
	public static void setPermissions(String access1,String access2) {
		
		if(access1.equals("camera")) isCameraAccessible = true;
		if(access1.equals("Microphone")) isMicrophoneAccessible = true;
		if(access1.equals("Location")) isLocationAccessible = true;
		
		if(access2.equals("camera")) isCameraAccessible = true;
		if(access2.equals("Microphone")) isMicrophoneAccessible = true;
		if(access2.equals("Location")) isLocationAccessible = true;
	}
	
	public static void setPermissions(String access1,String access2,String access3) {
		
		if(access1.equals("camera")) isCameraAccessible = true;
		if(access1.equals("Microphone")) isMicrophoneAccessible = true;
		if(access1.equals("Location")) isLocationAccessible = true;
		
		if(access2.equals("camera")) isCameraAccessible = true;
		if(access2.equals("Microphone")) isMicrophoneAccessible = true;
		if(access2.equals("Location")) isLocationAccessible = true;
		
		if(access3.equals("camera")) isCameraAccessible = true;
		if(access3.equals("Microphone")) isMicrophoneAccessible = true;
		if(access3.equals("Location")) isLocationAccessible = true;
	}
}
