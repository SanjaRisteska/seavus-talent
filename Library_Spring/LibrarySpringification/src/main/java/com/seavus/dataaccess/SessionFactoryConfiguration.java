package com.seavus.dataaccess;

import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seavus.domain.Book;
import com.seavus.domain.Loan;
import com.seavus.domain.Magazine;
import com.seavus.domain.Member;
import com.seavus.domain.Membership;

@Configuration
public class SessionFactoryConfiguration {
	
	SessionFactory sessionFactory;
	
	@Bean
	public SessionFactory getSessionFactory(){
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		 sessionFactory = configuration.addAnnotatedClass(Book.class).addAnnotatedClass(Magazine.class)
				.addAnnotatedClass(Membership.class).addAnnotatedClass(Member.class).addAnnotatedClass(Loan.class)
				.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
	
	@PreDestroy
	public void closeSessionFactory(){
		sessionFactory.close();
	}

}
