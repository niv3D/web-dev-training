
public class ExerciseMain {
	
	public static void main(String[] args) throws InterruptedException {
		
		Browser chrome = new Browser();
		
		chrome.read("a.com");
		chrome.delete("a.com");
		
		chrome.list();
		
	}

}
