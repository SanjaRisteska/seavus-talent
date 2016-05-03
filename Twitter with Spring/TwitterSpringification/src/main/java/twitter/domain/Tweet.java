package twitter.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tweet {

	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private String message;
	@ManyToOne
	private MyUser user;

	public Tweet() {
	}

	public Tweet(MyUser user, String message) {
		this.message = message;
		this.user = user;
		date = new Date();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return user.getNickName()+": \n"+message + "\n Date: " + date + "\n\n";
	}
}
