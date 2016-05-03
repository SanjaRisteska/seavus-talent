package twitter.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter.domain.MyUser;
import twitter.domain.Tweet;
import twitter.service.TwitterService;

@Component
public class TweetController {

	TwitterService twitterService;

	@Autowired
	public TweetController(TwitterService twitterService) {
		this.twitterService = twitterService;
	}

	public static void printMenu() {
		System.out.println("----------------------");
		System.out.println("Please enter one of the following commands.");
		System.out.println("1 - Tweet a message");
		System.out.println("2 - List all messages");
		System.out.println("3 - Register new user");
		System.out.println("Type END to exit.");
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
				System.out.println("Enter your nickname");
				String nickName = readCommand();
				MyUser user = twitterService.findUserByNick(nickName);
				if (user == null) {
					System.out.println("There isn't a user with this nickname.");
				} else {
					System.out.println("Enter a message.");
					String message = readCommand();
					twitterService.registerTweet(user, message);
				}
			} else if (input.equals("2")) {
				System.out.println("List of all registered tweets: ");
				ArrayList<Tweet> tweets = twitterService.listAllTweets();
				if (tweets.isEmpty()) {
					System.out.println("There aren't any tweets registered");
				} else {
					for (Tweet tweet : tweets) {
						System.out.println(tweet.toString());
					}
				}
			} else if (input.equals("3")) {
				System.out.println("Enter a nickname");
				String nickname = readCommand();
				
				twitterService.registerUser(nickname);
				

			} else if (input.equals("END")) {
				System.out.println("Goodbye.");
				System.exit(0);

			}
		}
	}

}
