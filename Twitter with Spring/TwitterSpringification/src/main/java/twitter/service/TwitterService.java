package twitter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter.dataaccess.TweetRepository;
import twitter.dataaccess.UserRepository;
import twitter.domain.MyUser;
import twitter.domain.Tweet;

@Component
public class TwitterService {

	TweetRepository tweetRepository;
	UserRepository userRepository;

	@Autowired
	public TwitterService(TweetRepository tweetRepository, UserRepository userRepository) {
		this.tweetRepository = tweetRepository;
		this.userRepository = userRepository;
	}

	public void registerTweet(MyUser user, String message) {
		Tweet tweet = new Tweet(user, message);
		tweetRepository.save(tweet);
	}

	public ArrayList<Tweet> listAllTweets() {

		ArrayList<Tweet> tweets = new ArrayList<Tweet>();
		tweets = (ArrayList<Tweet>) tweetRepository.list();
		return tweets;
	}
	
	public Tweet findTweet(Long id){
		return tweetRepository.find(id);
	}
	
	public void registerUser(String nickName){
		MyUser user = new MyUser(nickName);
		userRepository.save(user);
	}
	
	public ArrayList<MyUser> listAllUsers(){
		return (ArrayList<MyUser>)userRepository.list();
	}
	
	public MyUser findUser(Long id){
		return userRepository.find(id);
	}

	public MyUser findUserByNick(String user) {
		return userRepository.findByNick(user);
	}

	public List<Tweet> listMyTweets(String nickName) {
		return tweetRepository.listByUser(nickName);
	}

	public void deleteTweet(Long id) {
		 tweetRepository.delete(id);
		
	}

	public void updateTweet(Tweet tweet) {
		tweetRepository.update(tweet);		
	}

}
