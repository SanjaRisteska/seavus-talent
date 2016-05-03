package twitter.dataaccess;

import java.util.List;

import twitter.domain.Tweet;

public interface TweetRepository {
public void save(Tweet tweet);
public void delete(Long id);
public void update(Tweet tweet);
public List<Tweet> list();
public Tweet find(Long id);
public List<Tweet> listByUser(String nickName);
}
