package twitter.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import twitter.domain.MyUser;
import twitter.domain.Tweet;
import twitter.service.TwitterService;

@Controller
@RequestMapping("/tweets")
public class TweetMvcController {

	@Autowired
	private TwitterService twitterService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "tweets";
	}

	@ModelAttribute("tweets")
	public List<Tweet> tweets(Model model) {
		return twitterService.listAllTweets();
	}
	
	@ModelAttribute("tweet")
	public Tweet tweet(Model model){
		return new Tweet();
	}
	
	@ModelAttribute("tweetToDelete")
	public Tweet tweetToDelete(Model model){
		return new Tweet();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerTweet(@ModelAttribute("tweet") Tweet tweet) {
		if(tweet.getId()==null){
		MyUser user = twitterService.findUserByNick(tweet.getUser().getNickName());
			twitterService.registerTweet(user, tweet.getMessage());
		}
		else{
			twitterService.updateTweet(tweet);
		}
		return "redirect:/tweets";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		final Tweet tweet = twitterService.findTweet(id);
		model.addAttribute("tweet", tweet);
		return "tweets";
	}



	@RequestMapping(value = "/unregister/{id}", method = RequestMethod.GET)
	public String unregisterTweet(@PathVariable("id") Long id, Model model) {
		final Tweet tweet = twitterService.findTweet(id);
		model.addAttribute("tweetToDelete", tweet);
		return "tweets";
	}

	@RequestMapping(value = "/unregister", method = RequestMethod.POST)
	public String deleteTweet(@ModelAttribute("tweet") Tweet tweet) {
		if (tweet.getId() != null) {
			twitterService.deleteTweet(tweet.getId());

		} else {
			System.out.println("There isn't a book with this id.");
		}

		return "redirect:/tweets";
	}

}
