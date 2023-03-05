import java.util.ArrayList;

public class BrowserHistory {

	private ArrayList<String> historyUrls = new ArrayList<>();
	private int currentIndex;

	public BrowserHistory(String homepageUrl) {

		historyUrls.add(homepageUrl);
		currentIndex = 0;

	}

	private void verifyUrl(String url) throws InvalidURLException {
		
		boolean isValid = url.endsWith(".com") || url.endsWith(".in") || url.endsWith(".org");
		if (!isValid) {
			throw new InvalidURLException("Invalid Url extension");
		}
	}

	public void visit(String url) throws InvalidURLException {
		verifyUrl(url);
		historyUrls.add(url);
		currentIndex++;

	}

	public String back(int steps) throws NoHistoryFoundException {

		try {

			String url = historyUrls.get(currentIndex - steps);
			currentIndex -= steps;
			return url;

		} catch (IndexOutOfBoundsException e) {
			throw new NoHistoryFoundException("No History Found");
		}

	}

	public String forward(int steps) throws NoHistoryFoundException {

		try {

			String url = historyUrls.get(currentIndex + steps);
			currentIndex += steps;
			return url;

		} catch (IndexOutOfBoundsException e) {
			throw new NoHistoryFoundException("No History Found");
		}

	}

	public String get(int position) throws InvalidPositionException{
		
		if(position<0) {
			throw new InvalidPositionException("Provide only positive values");
		}
		
		try {

			String url = historyUrls.get(position);
			currentIndex = position;
			return url;
			
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Invalid position");
		}

	}

}
