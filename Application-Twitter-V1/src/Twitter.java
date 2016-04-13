import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Twitter {

	public static void printMenu() {
		System.err.println("Please enter one of the following commands.");
		System.err.println("1 - Tweet a message");
		System.err.println("2 - List all messages");
		System.err.println("3 - Exit");
	}

	public static String readCommand() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		return input;
	}

	public static void main(String[] args) throws IOException {

		Messages listOfTweets = new Messages();
		listOfTweets.loadMessages();
		// TODO Auto-generated method stub
		printMenu();
		while (true) {

			int command;
			try {
				command = Integer.parseInt(readCommand());
			} catch (NumberFormatException e) {
				System.out.println("This is not a valid command.");
				continue;
			}

			if (command == 1) {
				System.out.println("Enter a new message:");
				String msg = readCommand();
				Message m = new Message(msg);
				listOfTweets.addMessage(m);

			} else if (command == 2) {
				listOfTweets.listMessages();
			} else if (command == 3) {
				listOfTweets.saveMessages();
				System.out.println("Goodbye");
				System.exit(0);
			} else {
				System.out.println("This is not a valid command.");
			}

		}

	}

}
