import java.util.Arrays;
import java.util.Scanner;

public class BrowserUI {

	private BrowserHistory session;
	private String currentPage = "";

	private void mainMenu() {

		System.out.println(

				"Commands : \n\n" 
						+ "visit <url>      : visit the url \n"
						+ "back <i>         : goes i times back in history \n"
						+ "forward <i>      : goes i times forward in history \n"
						+ "get <i>          : goes to i position in history \n"
						+ "exit             : exit the console \n"
						+ "size             : display size of history \n"
						+ "fetch            : display all history \n"
						+ "sort             : display sorted history \n"
						+ "search <ext>     : list history with given extension\n"
						+ "update <i> <url> : update url at given position \n"
						+ "delete <i>       : delete history from the given position \n"
						+ "delete <url>     : delete given url from history \n"
						

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
				
			case "size":
				size();
				break;

			case "fetch":
				fetch();
				break;
				
			case "sort":
				sort();
				break;
				
			case "search":
				search(inputBuffer);
				break;
				
			case "update":
				update(inputBuffer);
				break;
				
			case "delete":
				delete(inputBuffer);
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

	private void delete(String[]  buffer) {
		if (!checkSession() || !checkArgs(buffer,2)) {
			return;
		}
		
		int argInt;
		
		try {
			
			argInt = Integer.parseInt(buffer[1]);
			session.deleteHistory(argInt);
			
		} catch (NumberFormatException e) {
			
			try {	
				session.deleteHistory(buffer[1]);
			} catch (InvalidURLException e2) {
				System.out.println(e2.getLocalizedMessage());
			}
			
		} catch (InvalidPositionException | IndexOutOfBoundsException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private void update(String[] buffer) {
		if (!checkSession() || !checkArgs(buffer,3)) {
			return;
		}
		try {
			session.updateHistory(Integer.parseInt(buffer[1]), buffer[2]);
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (InvalidURLException | InvalidPositionException | IndexOutOfBoundsException e) {
			System.out.println(e.getLocalizedMessage());
		} 
		
	}

	private void search(String[] buffer) {
		if (!checkSession() || !checkArgs(buffer,2)) {
			return;
		}
		String[] arg = buffer[1].split(".");
		String ext = arg[arg.length -1 ];
		
		try {
			System.out.println(Arrays.toString(session.searchByExtension(ext)) + "\n");
			
		} catch (InvalidURLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
	}

	private void sort() {
		if(!checkSession()) {
			return;
		}
		System.out.println(Arrays.toString(session.sort()) + "\n");
	}

	private void fetch() {
		if(!checkSession()) {
			return;
		}
		System.out.println(Arrays.toString(session.fetchHistory()) + "\n");
		
	}

	private void size() {
		if(!checkSession()) {
			return;
		}
		System.out.println(session.size() + "\n");
	}

	private void get(String[] buffer) {
		if (!checkSession() || !checkArgs(buffer,2)) {
			return;
		}

		try {
			currentPage = session.get(Integer.parseInt(buffer[1]));
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number as argument");
		} catch (InvalidPositionException | IndexOutOfBoundsException e) {
			System.out.println(e.getLocalizedMessage());
		} 
	}

	private void forward(String[] buffer) {
		if (!checkSession() || !checkArgs(buffer,2)) {
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
		if (!checkSession() || !checkArgs(buffer,2)) {
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
		if (!checkArgs(buffer,2)) {
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

	private boolean checkArgs(String[] args, int length) {
		if (args.length < length) {
			System.out.println("No argument");
			return false;
		} else {
			return true;
		}
	}

}
