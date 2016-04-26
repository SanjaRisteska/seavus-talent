package com.seavus.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Membership extends EntityClass{
	@OneToOne
	private Member member;
	private Date startDate;
	private Date endDate;
	private String membershipType;
	
	public Membership(){}

	public Membership(Member member, Date startDate, Date endDate, String membershipType) {
		this.member = member;
		this.startDate = startDate;
		this.endDate = endDate;
		this.membershipType = membershipType;
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

	public String getMembershipType() {
		return membershipType;
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

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	
	

}
