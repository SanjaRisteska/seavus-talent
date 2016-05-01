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
public class BookMvcController {
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
	
	@ModelAttribute("bookToDelete")
	public Book bookToDelete() {
		return new Book();
	}

	@ModelAttribute("books")
	public List<Book> books() {
		return libraryService.listBooks();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerBook(@ModelAttribute("book") Book book) {
		if (book.getId() == null) {
			libraryService.registerBook(book);
		} else {
			libraryService.updateBook(book);
		}
		return "redirect:/books";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long id, Model model) {
		final Book book = libraryService.findBook(id);
		model.addAttribute("book", book);
		return "books";
	}
	
	@RequestMapping(value = "/unregister/{id}", method = RequestMethod.GET)
	public String unregisterBook(@PathVariable("id") Long id, Model model){
		final Book book = libraryService.findBook(id);
		model.addAttribute("bookToDelete",book);
		//libraryService.deleteBook(id);
		return "books";
	}
	
	@RequestMapping(value = "/unregister", method = RequestMethod.POST)

	public String deleteBook(@ModelAttribute("book") Book book){
		if (book.getId() != null) {
			libraryService.deleteBook(book.getId());
			
		}
		else{
			System.out.println("There isn't a book with this id.");
		}
		
		return "redirect:/books";
	}


}
