
public class Task implements Runnable{
	
	private int number;
	
	public Task(int value) {
		number = value;
	}
	
	@Override
	public void run() {
		
		for(int i = 0; i < 20;i++) {
			if(i%2 == number) {
				System.out.println(i);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
