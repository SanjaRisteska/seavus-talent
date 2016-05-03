package twitter.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twitter.domain.MyUser;
import twitter.domain.Tweet;
import twitter.service.TwitterService;

@RestController
@RequestMapping("/api/twitter")
public class TwitterRestController {
	@Autowired
	TwitterService twitterService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Tweet> listTweets() {
		return twitterService.listAllTweets();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Tweet registerTweet(@RequestBody Tweet tweet) {
		MyUser user = twitterService.findUserByNick(tweet.getUser().getNickName());
		twitterService.registerTweet(user, tweet.getMessage());
		return tweet;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Tweet updateTweet(@RequestBody Tweet tweet, @PathVariable("id") Long id) {
		tweet.setId(id);
		twitterService.updateTweet(tweet);
		return tweet;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String unregisterTweet(@PathVariable("id") Long id) {
		twitterService.deleteTweet(id);
		return "Success";
	}
}
