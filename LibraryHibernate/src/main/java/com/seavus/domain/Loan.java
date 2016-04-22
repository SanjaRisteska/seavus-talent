package com.seavus.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Loan extends EntityClass {

	@ManyToOne
	private Member member;
	@OneToMany(mappedBy = "loan")
	private Set<Publication> publications;
	private Date startDate;
	private Date endDate;

	public Loan() {
	}

	public Loan(Member member, Date startDate, Date endDate) {
		super();
		this.member = member;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Member getMember() {
		return member;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
