package com.seavus.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("book")
public class Book extends Publication {

	private String isbn;

	public Book() {
	}

	public Book(String isbn, String title) {
		super(title);
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String toString() {
		return id+" "+isbn + "\t" + title;

	}
}
