package com.seavus.dataaccess;

import java.util.LinkedList;

import com.seavus.domain.Book;



public interface BookRepository {
	public void save(Book book);
	public void update(Book book);
	public void delete(String isbn);
	public LinkedList<Book> list();
	

}
