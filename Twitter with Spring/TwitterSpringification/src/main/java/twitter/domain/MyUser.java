package twitter.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MyUser {

	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String nickName;
	@OneToMany(mappedBy = "user")
	private Set<Tweet> tweets;

	public MyUser() {
	}

	public MyUser(String nickName) {
		super();
		this.nickName = nickName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
