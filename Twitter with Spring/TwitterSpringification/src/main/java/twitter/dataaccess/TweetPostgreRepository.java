package twitter.dataaccess;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
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
		System.out.println(tweet.toString());
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(tweet);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tweet> list() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Tweet.class).addOrder(Order.desc("date"));
		Transaction transaction = null;
		List<Tweet> results = null;
		try {

			transaction = session.beginTransaction();
			results = criteria.list();
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}

		return results;
	}

	@SuppressWarnings("unused")
	@Override
	public Tweet find(Long id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Tweet.class);
		Transaction transaction = null;
		Tweet tweet = null;

		try {

			transaction = session.beginTransaction();

			tweet = (Tweet) session.load(Tweet.class, id);
			Hibernate.initialize(tweet);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}

		return tweet;
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "DELETE FROM Tweet WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
	}

	@Override
	public void update(Tweet tweet) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "UPDATE Tweet set message = :message WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("message", tweet.getMessage());
			query.setParameter("id", tweet.getId());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tweet> listByUser(String nickName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Tweet> results = null;
		try {
			transaction = session.beginTransaction();

			String hql = "FROM Tweet WHERE user.nickName = :nickName";
			Query query = session.createQuery(hql);
			query.setParameter("nickName", nickName);
			results = query.list();

			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
		return results;
	}
}
