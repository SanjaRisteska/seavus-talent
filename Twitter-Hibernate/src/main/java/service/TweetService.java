package service;

import java.util.ArrayList;

import dataaccess.TweetRepository;
import domain.Tweet;

public class TweetService {
	TweetRepository tweetRepository;
	
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
