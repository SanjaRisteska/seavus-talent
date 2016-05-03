package twitter.dataaccess;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter.domain.MyUser;
import twitter.domain.Tweet;

@Component
public class UserPostgreRepository implements UserRepository {

	SessionFactory sessionFactory;
	
	
	@Autowired
	public UserPostgreRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(MyUser user) {
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);			
			transaction.commit();

		} catch (RuntimeException e) {
		    if (transaction != null) { transaction.rollback(); }

		} finally {
		    session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyUser> list() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Tweet.class);
		Transaction transaction = null;
		List<MyUser> results=null;
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

	@SuppressWarnings("unused")
	@Override
	public MyUser find(Long id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(MyUser.class);
		Transaction transaction = null;
		MyUser user = null;

		try {

			transaction = session.beginTransaction();

			user = (MyUser) session.load(MyUser.class, id);
			Hibernate.initialize(user);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public MyUser findByNick(String nick) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(MyUser.class);
		Transaction transaction = null;
		MyUser user = null;

		try {

			transaction = session.beginTransaction();

			user = (MyUser) criteria.add(Restrictions.eq("nickName", nick)).uniqueResult();
			Hibernate.initialize(user);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}

		return user;
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "DELETE FROM MyUser WHERE id = :id";
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
	public void update(MyUser user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "UPDATE MyUser set nickName = :nickName WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("nickName", user.getNickName());
			query.setParameter("id", user.getId());
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

}
