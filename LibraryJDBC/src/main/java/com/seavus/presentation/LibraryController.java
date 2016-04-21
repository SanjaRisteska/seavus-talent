package com.seavus.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import com.seavus.domain.Book;
import com.seavus.service.LibraryService;


public class LibraryController {
	private LibraryService libraryService;
	private BufferedReader in;

	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public void printMenu() {
		System.out.println("1. Insert new book.");
		System.out.println("2. List all books.");
		System.out.println("3. Update a book.");
		System.out.println("4. Delete a book.");
		System.out.println("5. Exit.");
	}

	public void run() throws IOException {
		while (true) {
			
			printMenu();
			
			String input = in.readLine();
			if (input.equals("1")) {
				System.out.println("Enter book isbn: ");
				String isbn = in.readLine();
				System.out.println("Enter book title: ");
				String title = in.readLine();
				libraryService.registerBook(isbn, title);

			}

			else if (input.equals("2")) {
				System.out.println("List of all registered books: ");
				LinkedList<Book> books = libraryService.listBooks();
				for(Book book : books){
					System.out.println(book.toString());
				}

			} else if (input.equals("3")) {
				System.out.println("Enter isbn of the book you want to update: ");
				String isbn = in.readLine();
				System.out.println("Enter new title: ");
				String title = in.readLine();
				libraryService.updateBook(isbn, title);

			} else if (input.equals("4")) {
				System.out.println("Enter the isbn of the book you want to delete: ");
				String isbn = in.readLine();
				libraryService.deleteBook(isbn);

			} else if (input.equals("5")) {
				System.out.println("Goodbye.");
				System.exit(0);

			}
		}
	}

}
