
public class MultiThreadMain {

	public static void main(String[] args) {
		Task task1 = new Task(0);
		Task task2 = new Task(1);
				
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		thread1.start();
		thread2.start();
	}

}
