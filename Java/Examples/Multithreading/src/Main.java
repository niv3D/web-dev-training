
public class Main {

	public static void main(String[] args) throws InterruptedException {

		CalculatePrimes calculator = new CalculatePrimes();

		calculator.start();
		Thread.sleep(1);
		calculator.finish();

		System.out.println(calculator.getPrimes());
	}

}
