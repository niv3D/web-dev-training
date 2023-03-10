import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BrowserHistory {

	private ArrayList<String> historyArrayList = new ArrayList<>();
	private HashSet<String> historyHashSet = new HashSet<>();
	private int currentIndex;

	public BrowserHistory(String homepageUrl) throws InvalidURLException {

		verifyUrl(homepageUrl);
		historyArrayList.add(homepageUrl);
		historyHashSet.add(homepageUrl);
		currentIndex = 0;

	}

	private void verifyUrl(String url) throws InvalidURLException {

		boolean isValid = url.endsWith(".com") || url.endsWith(".in") || url.endsWith(".org");
		if (!isValid) {
			throw new InvalidURLException("Invalid Url extension");
		}
	}

	public String visit(String url) throws InvalidURLException {
		verifyUrl(url);
		historyArrayList.add(url);
		historyHashSet.add(url);
		currentIndex++;
		return url;
	}

	public String back(int steps) throws NoHistoryFoundException {

		try {

			String url = historyArrayList.get(currentIndex - steps);
			currentIndex -= steps;
			return url;

		} catch (IndexOutOfBoundsException e) {
			throw new NoHistoryFoundException("No History Found");
		}

	}

	public String forward(int steps) throws NoHistoryFoundException {

		try {

			String url = historyArrayList.get(currentIndex + steps);
			currentIndex += steps;
			return url;

		} catch (IndexOutOfBoundsException e) {
			throw new NoHistoryFoundException("No History Found");
		}

	}

	public String get(int position) throws InvalidPositionException, IndexOutOfBoundsException {

		if (position < 0) {
			throw new InvalidPositionException("Provide only positive values");
		}

		try {

			String url = historyArrayList.get(position);
			currentIndex = position;
			return url;

		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Invalid position");
		}

	}

	//////////////////////

	public String[] sort() {

		String[] historyArray = historyArrayList.toArray(new String[0]);

		Arrays.sort(historyArray);

		return historyArray;

	}

	public void deleteHistory(int index) throws InvalidPositionException, IndexOutOfBoundsException {

		if (index < 0) {
			throw new InvalidPositionException("Provide only positive values");
		}

		try {

			String element = historyArrayList.remove(index);

			if (!historyArrayList.contains(element)) {
				historyHashSet.remove(element);
			}

		} catch (IndexOutOfBoundsException e) {

			throw new IndexOutOfBoundsException("Invalid position");
		}

	}

	public void deleteHistory(String url) throws InvalidURLException {
		verifyUrl(url);
		int index = historyArrayList.lastIndexOf(url);
		if (index < 0) {
			throw new InvalidURLException("No such url");
		}

		String element = historyArrayList.remove(index);
		if (!historyArrayList.contains(element)) {
			historyHashSet.remove(element);
		}
	}

	public String[] fetchHistory() {
		return historyHashSet.toArray(new String[0]);
	}

	public String[] searchByExtension(String extension) throws InvalidURLException {

		verifyUrl(extension);
		ArrayList<String> filter = new ArrayList<>();

		for (String string : historyHashSet) {
			if (string.endsWith(extension)) {
				filter.add(string);
			}
		}

		return filter.toArray(new String[0]);
	}

	public int size() {
		return historyArrayList.size();
	}

	public void updateHistory(int index, String url) throws InvalidURLException, InvalidPositionException ,IndexOutOfBoundsException {
		if (index < 0) {
			throw new InvalidPositionException("Provide only positive values");
		}
		verifyUrl(url);
		try {

			String element = historyArrayList.remove(index);
			if (!historyArrayList.contains(element)) {
				historyHashSet.remove(element);
			}

			historyArrayList.set(index, url);
			historyHashSet.add(url);

		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Invalid Position");
		}

	}
}
