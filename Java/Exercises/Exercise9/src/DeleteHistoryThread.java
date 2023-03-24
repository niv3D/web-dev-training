import java.util.List;

public class DeleteHistoryThread extends Thread{
	private List<String> historyArrayList;
	private String item;
	
	public DeleteHistoryThread(List<String> history,String string) {
		historyArrayList = history;
		item = string;
	}
	
	@Override
	public void run() {
//		for(int i=1;i<6;i++) {
//			try {
//				Thread.sleep(1000);
//				System.out.println(i);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		int index  = historyArrayList.lastIndexOf(item);
		if (index>-1) {
			historyArrayList.remove(index);
		}
	}
}
