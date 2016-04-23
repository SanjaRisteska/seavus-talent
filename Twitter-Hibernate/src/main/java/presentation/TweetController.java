package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import domain.Tweet;
import service.TweetService;

public class TweetController {

	TweetService tweetService;

	public TweetController(TweetService tweetService) {
		this.tweetService = tweetService;
	}

	public static void printMenu() {
		System.out.println("----------------------");
		System.out.println("Please enter one of the following commands.");
		System.out.println("1 - Tweet a message");
		System.out.println("2 - List all messages");
		System.out.println("3 - Exit");
		System.out.println("----------------------");
	}

	public static String readCommand() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		return input;
	}

	public void run() throws IOException {

		while (true) {
			printMenu();
			String input = readCommand();

			if (input.equals("1")) {
				System.out.println("Enter a message.");
				String message = readCommand();
				tweetService.registerTweet(message);
			} else if (input.equals("2")) {
				System.out.println("List of all registered tweets: ");
				ArrayList<Tweet> tweets = tweetService.listAllTweets();
				if (tweets.isEmpty()) {
					System.out.println("There aren't any tweets registered");
				} else {
					for (Tweet tweet : tweets) {
						System.out.println(tweet.toString());
					}
				}
			} else if (input.equals("3")) {
				System.out.println("Goodbye.");
				System.exit(0);

			}
		}
	}

}
