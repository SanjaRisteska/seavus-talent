package com.seavus.dataaccess;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seavus.domain.Member;
import com.seavus.domain.Membership;

@Component
public class MembershipPostgreHibernateRepository implements MembershipRepository {
	
SessionFactory sessionFactory;
	
@Autowired
	public MembershipPostgreHibernateRepository(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	public void save(Member member, Membership membership) {
		Session session=sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(member);	
			session.save(membership);
			transaction.commit();

		} catch (RuntimeException e) {
		    if (transaction != null) { transaction.rollback(); }

		} finally {
		    session.close();
		}
	}
	

}
