package presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.LibraryService;

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
			String input = in.readLine();
			if (input.equals("1")) {
				System.out.println("Enter book isbn: ");
				String isbn = in.readLine();
				System.out.println("Enter book title: ");
				String title = in.readLine();
				libraryService.registerBook(isbn, title);

			}

			else if (input.equals("2")) {

			} else if (input.equals("3")) {

			} else if (input.equals("4")) {

			} else if (input.equals("5")) {
				System.out.println("Goodbye.");
				System.exit(0);

			}
		}
	}

}
