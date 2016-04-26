package twitter.dataaccess;

import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter.domain.Tweet;

@Configuration
public class SessionFactoryConfiguration {
	SessionFactory sessionFactory;

	@Bean
	public SessionFactory getSessionFactory() {
		org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.addAnnotatedClass(Tweet.class).buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	@PreDestroy
	public void closeSessionFactory() {
		sessionFactory.close();
	}
}
