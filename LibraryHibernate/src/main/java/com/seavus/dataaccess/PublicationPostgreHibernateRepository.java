package com.seavus.dataaccess;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seavus.domain.Book;
import com.seavus.domain.Magazine;
import com.seavus.domain.Publication;

public class PublicationPostgreHibernateRepository implements PublicationRepository{

SessionFactory sessionFactory;
	
	public PublicationPostgreHibernateRepository(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	public void save(Publication publication) {
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(publication);			
			transaction.commit();

		} catch (RuntimeException e) {
		    if (transaction != null) { transaction.rollback(); }

		} finally {
		    session.close();
		}
	}

	public void updateBook(Book book) {
		Session session=sessionFactory.openSession();
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
		    if (transaction != null) { transaction.rollback(); }

		} finally {
		    session.close();
		}		
	}

	public void delete(String isbn) {
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			String hql = "DELETE FROM Book WHERE isbn = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("isbn", isbn);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			
			transaction.commit();

		} catch (RuntimeException e) {
		    if (transaction != null) { transaction.rollback(); }

		} finally {
		    session.close();
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Publication> list() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Publication.class);
		Transaction transaction = null;
		List<Publication> results=null;
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

	public void updateMagazine(Magazine magazine) {
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			String hql = "UPDATE Book set title = :title WHERE isbn = :isbn";
			Query query = session.createQuery(hql);
			query.setParameter("title", magazine.getTitle());
			query.setParameter("isbn", magazine.getIssn());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			
			transaction.commit();

		} catch (RuntimeException e) {
		    if (transaction != null) { transaction.rollback(); }

		} finally {
		    session.close();
		}				
	}

}
