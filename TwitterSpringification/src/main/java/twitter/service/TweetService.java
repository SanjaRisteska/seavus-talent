package twitter.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter.dataaccess.TweetRepository;
import twitter.domain.Tweet;

@Component
public class TweetService {
	TweetRepository tweetRepository;
	
	@Autowired
	public TweetService(TweetRepository tweetRepository){
		this.tweetRepository=tweetRepository;
	}

	public void registerTweet(String message){
		Tweet tweet=new Tweet(message);
		tweetRepository.save(tweet);
	}
	
	public ArrayList<Tweet> listAllTweets(){

		ArrayList<Tweet> tweets=new ArrayList<Tweet>();
		tweets=(ArrayList<Tweet>) tweetRepository.list();
		return  tweets;
	}
}
