package twitter.dataaccess;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter.domain.Tweet;

@Component
public class TweetPostgreRepository implements TweetRepository {

	SessionFactory sessionFactory;

	@Autowired
	public TweetPostgreRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Tweet tweet) {
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(tweet);			
			transaction.commit();

		} catch (RuntimeException e) {
		    if (transaction != null) { transaction.rollback(); }

		} finally {
		    session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tweet> list() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Tweet.class).addOrder(Order.desc("date"));
		Transaction transaction = null;
		List<Tweet> results=null;
		try {
			
			transaction = session.beginTransaction();
			results = criteria.list();
			transaction.commit();

		} catch (RuntimeException e) {
		    if (transaction != null) { transaction.rollback(); }
		    	throw(e);

		} finally {
		    session.close();
		}
			
		return results;
	}
	}


