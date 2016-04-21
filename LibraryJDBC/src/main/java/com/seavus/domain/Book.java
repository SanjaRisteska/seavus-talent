package com.seavus.domain;

public class Book {
	private String isbn;
	private String title;

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public String toString(){
		return isbn+"\t"+title;
		
	}

}
