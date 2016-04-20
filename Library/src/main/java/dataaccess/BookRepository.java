package dataaccess;

import java.util.LinkedList;

import domain.Book;

public interface BookRepository {
	public void save(Book book);
	public void update(Book book);
	public void delete(Book book);
	public LinkedList<Book> list();
	

}
