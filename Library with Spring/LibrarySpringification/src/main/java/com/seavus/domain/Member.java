package com.seavus.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Member extends EntityClass{
	
	@OneToOne(mappedBy= "member")
	private Membership membership;
	@OneToMany(mappedBy= "member")
	private Set<Loan> loans;
	private String email;
	private String name;
	
	
	public Member(){}

	public Member(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
