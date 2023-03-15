import java.util.Scanner;

public class BrowserUI {

	private BrowserHistory session = new BrowserHistory();
	private String currentPage = "";

	private void mainMenu() {

		System.out.println(

				"commands : \n\n" + "visit <url> \n" + "fetch <extension> \n" + "delete <extension> \n"
						+ "size <extension> \n" + "search <keyWord> \n" + "exit \n");

	}

	public void run() {

		Scanner input = new Scanner(System.in);
		boolean exitStatus = false;
		mainMenu();

		do {

			System.out.print(currentPage + "\n>");

			String[] inputBuffer = input.nextLine().split(" ");
			String command = inputBuffer[0];

			switch (command) {

			case "visit":
				visit(inputBuffer);
				break;

			case "fetch":
				fetch(inputBuffer);
				break;

			case "delete":
				delete(inputBuffer);
				break;

			case "size":
				size(inputBuffer);
				break;

			case "search":
				search(inputBuffer);
				break;

			case "exit":
				exitStatus = true;
				break;

			default:
				System.out.println("invalid command !");
				break;
			}

		} while (!exitStatus);
	}

	private void visit(String[] buffer) {

		if (!checkArgs(1, buffer)) {
			return;
		}

		try {
			session.visit(buffer[1]);
			currentPage = buffer[1];
		} catch (InvalidUrlException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

	private void fetch(String[] buffer) {
		if (!checkSession() || !checkArgs(0, buffer)) {
			return;
		}
		try {
			System.out.println(session.fetchHistory(buffer[1]));
		} catch (InvalidUrlException | NoHistoryFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void delete(String[] buffer) {
		if (!checkSession() || !checkArgs(0, buffer)) {
			return;
		}
		try {
			session.deleteHistory(buffer[1]);
		} catch (InvalidUrlException | NoHistoryFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void size(String[] buffer) {
		if (!checkSession() || !checkArgs(0, buffer)) {
			return;
		}
		try {
			System.out.println(session.size(buffer[1]));
		} catch (InvalidUrlException | NoHistoryFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void search(String[] buffer) {
		if (!checkSession() || !checkArgs(0, buffer)) {
			return;
		}
		System.out.println(session.search(buffer[1]));
	}

	private boolean checkSession() {

		if (session != null) {
			return true;
		} else {
			System.out.println("start by visiting a url !");
			return false;
		}
	}

	private boolean checkArgs(int number, String[] buffer) {
		if (buffer.length < number + 1) {
			System.out.println("no arguments");
			return false;
		} else {
			return true;
		}
	}

}
