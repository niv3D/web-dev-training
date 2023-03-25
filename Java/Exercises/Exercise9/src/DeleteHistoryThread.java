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
		for(int i=1;i<6;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i + "delete" + Thread.currentThread().getId());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("write");
		int index  = historyArrayList.lastIndexOf(item);
		if (index>-1) {
			historyArrayList.remove(index);
		}
	}
}
