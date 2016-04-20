package service;

import dataaccess.BookRepository;
import domain.Book;

public class LibraryService {
	BookRepository bookRepository;
	
	public LibraryService(BookRepository bookRepository){
		
	}
	
	public void registerBook(String isbn, String title){
		Book book=new Book(isbn,title);
		bookRepository.save(book);
	}
	
	public void updateBook(String isbn, String title){
		
	}
	
}
