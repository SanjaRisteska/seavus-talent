package dataaccess;

import java.util.List;

import domain.Tweet;

public interface TweetRepository {
public void save(Tweet tweet);
public List<Tweet> list();
}
