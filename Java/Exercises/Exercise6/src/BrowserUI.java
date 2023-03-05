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

				try {
					if (inputBuffer.length < 2) {
						System.out.println("No argument");
						break;
					}
					String arg = inputBuffer[1];
					if (session == null) {
						session = new BrowserHistory(arg);
						currentPage = arg;
						break;
					} else {
						currentPage = session.visit(arg);
					}
				} catch (InvalidURLException e) {
					System.out.println(e.getLocalizedMessage());
				}
				break;

			case "back":
				if (session == null) {
					System.out.println("start by visiting a url");
					break;
				}
				try {
					if (inputBuffer.length < 2) {
						System.out.println("No argument");
						break;
					}

					String arg = inputBuffer[1];
					currentPage = session.back(Integer.parseInt(arg));

				} catch (NumberFormatException e) {
					System.out.println("Enter valid number as argument");
					break;
				} catch (NoHistoryFoundException e) {
					System.out.println(e.getLocalizedMessage());
				}
				break;

			case "forward":
				if (session == null) {
					System.out.println("start by visiting a url");
					break;
				}
				try {
					if (inputBuffer.length < 2) {
						System.out.println("No argument");
						break;
					}

					String arg = inputBuffer[1];
					currentPage = session.forward(Integer.parseInt(arg));

				} catch (NumberFormatException e) {
					System.out.println("Enter valid number as argument");
					break;
				} catch (NoHistoryFoundException e) {
					System.out.println(e.getLocalizedMessage());
				}
				break;

			case "get":
				if (session == null) {
					System.out.println("start by visiting a url");
					break;
				}
				try {
					if (inputBuffer.length < 2) {
						System.out.println("No argument");
						break;
					}

					String arg = inputBuffer[1];
					currentPage = session.get(Integer.parseInt(arg));

				} catch (NumberFormatException e) {

					System.out.println("Enter valid number as argument");

				} catch (InvalidPositionException e) {

					System.out.println(e.getLocalizedMessage());

				} catch (IndexOutOfBoundsException e) {
					System.out.println(e.getLocalizedMessage());
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
}
