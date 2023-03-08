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
				if (checkArgs(inputBuffer)) {
					visit(inputBuffer[1]);
				}
				break;

			case "back":
				if (checkSession() && checkArgs(inputBuffer)) {
					back(inputBuffer[1]);
				}
				break;

			case "forward":
				if (checkSession() && checkArgs(inputBuffer)) {
					forward(inputBuffer[1]);
				}
				break;

			case "get":
				if (checkSession() && checkArgs(inputBuffer)) {
					get(inputBuffer[1]);
				}
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

	private void get(String arg) {
		try {
			currentPage = session.get(Integer.parseInt(arg));
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (InvalidPositionException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void forward(String arg) {
		try {
			currentPage = session.forward(Integer.parseInt(arg));
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (NoHistoryFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void back(String arg) {
		try {
			currentPage = session.back(Integer.parseInt(arg));
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (NoHistoryFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void visit(String arg) {
		try {
			if (!checkSession()) {
				session = new BrowserHistory(arg);
			}
			currentPage = session.back(Integer.parseInt(arg));
		} catch (InvalidURLException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (NoHistoryFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
