import java.io.IOException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dataaccess.TweetPostgreRepository;
import domain.Tweet;
import presentation.TweetController;
import service.TweetService;

public class TwitterApplication {

	public static void main(String[] args) throws IOException {
		Configuration configuration = new Configuration();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.addAnnotatedClass(Tweet.class).buildSessionFactory(serviceRegistry);
		
		TweetController tweetController=new TweetController(new TweetService(new TweetPostgreRepository(sessionFactory)));
		tweetController.run();
		
		sessionFactory.close();
	
	}

}
