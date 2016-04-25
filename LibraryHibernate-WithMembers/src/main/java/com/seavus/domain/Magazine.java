package com.seavus.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Publication{
	
	private String issn;
	
	public Magazine(){}

	public Magazine(String issn, String title) {
		super(title);
		this.issn = issn;
	}
	
	public String getIssn(){
		return issn;
	}
	
	public String toString(){
		return issn+"\t"+title;
	}

}
