package com.seavus.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seavus.domain.Book;
import com.seavus.service.LibraryService;

@Controller
@RequestMapping("/books")
public class PublicationMvcController {

	@Autowired
	private LibraryService libraryService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "books";
	}

	@ModelAttribute("book")
	public Book book() {
		return new Book();
	}

	@ModelAttribute("books")
	public List<Book> books() {
		return libraryService.listBooks();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerBook(@ModelAttribute("book") Book book) {
		if (book.getId() == null) {
			libraryService.registerBook(book.getIsbn(), book.getTitle());
		} else {
			libraryService.updateBook(book.getIsbn(), book.getTitle());
		}
		return "redirect:/books";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
	final Book book= libraryService.findBook(id);
	return "redirect:/books";
	}

}
