import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.LinkedList;

public class Messages {
	LinkedList<Message> allMessages;

	public Messages() {
		allMessages = new LinkedList<Message>();
	}

	public void addMessage(Message newMessage) {

		allMessages.add(newMessage);

	}

	public void listMessages() {
		if (allMessages.isEmpty()) {
			System.out.println("There are no messages");
		} else {

			System.out.println("Listing messages:");
			TweetComparator c = new TweetComparator();
			allMessages.sort(c);
			for (Message m : allMessages) {
				System.out.println(m.getMessage() + "\n");
			}
		}
	}

	public void saveMessages() {
		if (!allMessages.isEmpty()) {
			try {
				FileOutputStream fileOut = new FileOutputStream("messages.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);

				for (Message m : allMessages) {
					out.writeObject(m);
				}

				out.close();
				fileOut.close();
			} catch (IOException i) {
				i.printStackTrace();
			}

		}

	}

	public void loadMessages() {
		try {
			FileInputStream fileIn = new FileInputStream("messages.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Message m;
			do {
				m = (Message) in.readObject();
				allMessages.add(m);
			} while (m != null);
			in.close();
			fileIn.close();
		} catch (IOException i) {

		} catch (ClassNotFoundException c) {
		}
	}

	class TweetComparator implements Comparator<Message> {

		@Override
		public int compare(Message m1, Message m2) {
			if (m1.getDate().before(m2.getDate())) {
				return 1;
			} else {
				return -1;
			}
		}
	}

}
