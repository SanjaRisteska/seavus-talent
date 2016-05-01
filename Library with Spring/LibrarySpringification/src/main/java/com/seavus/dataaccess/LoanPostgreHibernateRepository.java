package com.seavus.dataaccess;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seavus.domain.Loan;

@Component
public class LoanPostgreHibernateRepository implements LoanRepository {

	SessionFactory sessionFactory;

	@Autowired
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> listLoans() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Loan.class);
		Transaction transaction = null;
		List<Loan> results = null;
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
