
public class Main {

	public static void main(String[] args) throws InterruptedException {

		CalculatePrimes calculator1 = new CalculatePrimes();
		
//		CalculatePrimes calculator2 = new CalculatePrimes();
		
		calculator1.start();
		Thread.sleep(1);
		calculator1.finish();
		
		System.out.println(CalculatePrimes.getPrimes());
		
//		calculator2.start();
//		Thread.sleep(1);
//		calculator2.finish();
		
//		System.out.println(CalculatePrimes.getPrimes());
		
		
	}

}
