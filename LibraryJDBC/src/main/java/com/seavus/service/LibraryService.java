package com.seavus.service;

import java.util.LinkedList;

import com.seavus.dataaccess.BookRepository;
import com.seavus.domain.Book;

public class LibraryService {
	BookRepository bookRepository;
	
	public LibraryService(BookRepository bookRepository){
		this.bookRepository=bookRepository;
	}
	
	public void registerBook(String isbn, String title){
		Book book=new Book(isbn,title);
		bookRepository.save(book);
	}
	
	public LinkedList<Book> listBooks(){
		LinkedList<Book> books=bookRepository.list();
		return books;
	}
	
	public void updateBook(String isbn, String title){
		Book book=new Book(isbn,title);
		bookRepository.update(book);
	}
	
	public void deleteBook(String isbn){
		
		bookRepository.delete(isbn);
	}
	
	
}
