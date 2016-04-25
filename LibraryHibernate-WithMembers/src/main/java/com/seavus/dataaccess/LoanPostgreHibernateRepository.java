package com.seavus.dataaccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.seavus.domain.Loan;

public class LoanPostgreHibernateRepository implements LoanRepository {

	SessionFactory sessionFactory;

	public LoanPostgreHibernateRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void registerLoan(Loan loan) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(loan);
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
