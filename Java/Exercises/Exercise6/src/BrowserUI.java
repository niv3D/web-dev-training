import java.util.Scanner;

public class BrowserUI {

	private BrowserHistory session;
	private String currentPage = "";

	private void mainMenu() {

		System.out.println(

				"Commands : \n\n" + "visit <url>      : visit the url \n"
						+ "back <number>    : goes arg times back in history \n"
						+ "forward <number> : goes arg times forward in history \n"
						+ "get <number>     : goes to arg position in history \n"
						+ "exit             : exit the console"

		);

	}

	public void run() {

		Scanner input = new Scanner(System.in);
		boolean exitStatus = false;
		mainMenu();

		do {

			System.out.println(currentPage + "\n");
			System.out.print('>');

			String[] inputBuffer = input.nextLine().split(" ");
			String command = inputBuffer[0];

			switch (command) {

			case "visit":
				visit(inputBuffer);
				break;

			case "back":
				back(inputBuffer);
				break;

			case "forward":
				forward(inputBuffer);
				break;

			case "get":
				get(inputBuffer);
				break;

			case "exit":
				exitStatus = true;
				break;

			default:
				System.out.println("Invalid Command ");
				break;
			}

		} while (!exitStatus);

		input.close();
	}

	private void get(String[] buffer) {
		if (!checkSession() || !checkArgs(buffer)) {
			return;
		}

		try {
			currentPage = session.get(Integer.parseInt(buffer[1]));
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (InvalidPositionException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void forward(String[] buffer) {
		if (!checkSession() || !checkArgs(buffer)) {
			return;
		}

		try {
			currentPage = session.forward(Integer.parseInt(buffer[1]));
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (NoHistoryFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void back(String[] buffer) {
		if (!checkSession() || !checkArgs(buffer)) {
			return;
		}

		try {
			currentPage = session.back(Integer.parseInt(buffer[1]));
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (NoHistoryFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void visit(String[] buffer) {
		if (!checkArgs(buffer)) {
			return;
		}

		try {
			if (session == null) {
				session = new BrowserHistory(buffer[1]);
				currentPage = buffer[1];
			} else {
				currentPage = session.visit(buffer[1]);
			}
		} catch (InvalidURLException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private boolean checkSession() {
		if (session == null) {
			System.out.println("start by visiting a url");
			return false;
		} else {
			return true;
		}
	}

	private boolean checkArgs(String[] args) {
		if (args.length < 2) {
			System.out.println("No argument");
			return false;
		} else {
			return true;
		}
	}

}
