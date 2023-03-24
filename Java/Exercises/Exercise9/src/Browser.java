import java.util.ArrayList;

public class Browser {
	
	private ArrayList<String> historyArrayList = new ArrayList<>();
	
	public synchronized void read(String url) {
		ReadHistoryThread read = new ReadHistoryThread(historyArrayList, url);
		read.start();
	}
	
	public synchronized void delete(String url) {
		DeleteHistoryThread delete = new DeleteHistoryThread(historyArrayList, url);
		delete.start();
	}
	
	public void list() {
		System.out.println(historyArrayList);
	}
}
