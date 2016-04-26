package com.seavus.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Loan extends EntityClass {

	@ManyToOne
	private Member member;
	@ManyToOne
	private Publication publication;
	private Date startDate;
	private Date endDate;

	public Loan() {
	}

	public Loan(Member member, Publication publication, Date startDate, Date endDate) {
		this.member = member;
		this.publication = publication;
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
