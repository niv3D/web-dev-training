import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatePrimes extends Thread {

	private boolean finished = false;

	public synchronized void finish() {
		finished = true;
	}

	private ArrayList<Integer> primes = new ArrayList<>(Arrays.asList(2));

	public synchronized List<Integer> getPrimes() {
		return primes;
	}

	@Override
	public void run() {

		for (int i = primes.get(primes.size() - 1) + 1; !finished; i++) {
			boolean prime = true;
			for (int j = 0; primes.get(j) * primes.get(j) <= i; j++) {
				if (i % primes.get(j) == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				primes.add(i);
			}
		}
	}

}
