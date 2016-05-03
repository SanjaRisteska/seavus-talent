package com.seavus.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seavus.domain.Book;
import com.seavus.service.LibraryService;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

	@Autowired
	LibraryService libraryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Book> listBooks() {
		return libraryService.listBooks();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Book registerBook(@RequestBody Book book) {
		libraryService.registerBook(book);
		return book;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Book updateBookRegistration(@RequestBody Book book, @PathVariable("id") Long id) {
		book.setId(id);
		libraryService.updateBook(book);
		return book;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String unregisterBook(@PathVariable("id") Long id) {
		libraryService.deleteBook(id);
		return "Success";
	}
}
