import java.util.List;

public class ReadHistoryThread extends Thread{
	
	private List<String> historyArrayList;
	private String item;
	
	public ReadHistoryThread(List<String> history,String string) {
		historyArrayList = history;
		item = string;
	}
	
	@Override
	public void run() {
		for(int i=1;i<6;i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i + "read" + Thread.currentThread().getId());
				
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
		
		historyArrayList.add(item);
	}
}
