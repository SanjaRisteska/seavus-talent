package com.seavus.dataaccess;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seavus.domain.Book;
import com.seavus.domain.Magazine;
import com.seavus.domain.Publication;

@Component
public class PublicationPostgreHibernateRepository implements PublicationRepository {

	SessionFactory sessionFactory;

	@Autowired
	public PublicationPostgreHibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Publication publication) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(publication);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
	}

	public void updateBook(Book book) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "UPDATE Book set title = :title WHERE isbn = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("title", book.getTitle());
			query.setParameter("isbn", book.getIsbn());
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

	public void deleteBook(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "DELETE FROM Book WHERE id = :id";
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

	@SuppressWarnings("unchecked")
	public List<Publication> list() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Publication.class);
		Transaction transaction = null;
		List<Publication> results = null;
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

	public void updateMagazine(Magazine magazine) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "UPDATE Magazine set title = :title WHERE issn = :issn";
			Query query = session.createQuery(hql);
			query.setParameter("title", magazine.getTitle());
			query.setParameter("issn", magazine.getIssn());
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

	public void deleteMagazine(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "DELETE FROM Magazine WHERE id = :id";
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		Transaction transaction = null;
		List<Book> results = null;
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
	public Book findBook(Long id) {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Book.class);
		Transaction transaction = null;
		Book book = null;

		try {

			transaction = session.beginTransaction();

			book = (Book) session.load(Book.class, id);
			Hibernate.initialize(book);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}

		return book;
	}
	
	@SuppressWarnings("unused")
	public Magazine findMagazine(Long id){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Magazine.class);
		Transaction transaction = null;
		Magazine magazine = null;

		try {

			transaction = session.beginTransaction();

			magazine = (Magazine) session.load(Magazine.class, id);
			Hibernate.initialize(magazine);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}

		return magazine;
	}
	
	
	@SuppressWarnings("unused")
	public Publication findPublication(Long id){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Publication.class);
		Transaction transaction = null;
		Publication publication = null;

		try {

			transaction = session.beginTransaction();

			publication = (Publication) session.load(Publication.class, id);
			Hibernate.initialize(publication);
			transaction.commit();

		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw (e);

		} finally {
			session.close();
		}

		return publication;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Magazine> listMagazines() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Magazine.class);
		Transaction transaction = null;
		List<Magazine> results = null;
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

}
