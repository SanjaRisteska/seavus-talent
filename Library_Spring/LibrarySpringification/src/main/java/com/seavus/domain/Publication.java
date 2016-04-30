package com.seavus.domain;

import java.util.Set;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class Publication extends EntityClass{

	@OneToMany(mappedBy = "publication")
	private Set<Loan> loans;
	protected String title;

	public Publication() {
	}

	public Publication(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
