package twitter.dataaccess;

import java.util.List;

import twitter.domain.Tweet;

public interface TweetRepository {
public void save(Tweet tweet);
public List<Tweet> list();
}
