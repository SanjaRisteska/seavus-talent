package twitter;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import twitter.presentation.TweetController;

@SpringBootApplication
public class TwitterApplication implements CommandLineRunner, ApplicationContextAware {

	private ApplicationContext applicationContext;

	public static void main(String[] args) throws IOException {

		SpringApplication.run(TwitterApplication.class, args);

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}

	@Override
	public void run(String... arg0) throws Exception {
		applicationContext.getBean(TweetController.class).run();
	}

}
