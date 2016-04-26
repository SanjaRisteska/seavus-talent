package twitter.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tweet {

	@Id
	@GeneratedValue
	private Long id;
	private Date date;
	private String message;

	public Tweet() {
	}

	public Tweet(String message) {
		this.message = message;
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
	
	public String toString(){
		return message+"\n Date: "+date+"\n\n";
	}
}
