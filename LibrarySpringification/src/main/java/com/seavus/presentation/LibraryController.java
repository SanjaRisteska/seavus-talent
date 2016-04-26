package com.seavus.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seavus.domain.Publication;
import com.seavus.service.LibraryService;

@Component
public class LibraryController {
	private LibraryService libraryService;
	private BufferedReader in;

	@Autowired
	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public void printMenu() {
		System.out.println("----------------------");
		System.out.println("1. Insert new book.");
		System.out.println("2. Insert new magazine.");
		System.out.println("3. List all publications.");
		System.out.println("4. Update a book.");
		System.out.println("5. Update a magazine.");
		System.out.println("6. Delete a book.");
		System.out.println("7. Delete a magazine.");
		System.out.println("8. Register new member.");
		System.out.println("9. Borrow a publication.");
		System.out.println("Type END to exit.");
		System.out.println("----------------------");

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
				System.out.println("Enter magazine issn: ");
				String issn = in.readLine();
				System.out.println("Enter magazine title: ");
				String title = in.readLine();
				libraryService.registerMagazine(issn, title);
			}

			else if (input.equals("3")) {
				System.out.println("List of all registered publications: ");
				List<Publication> publications = libraryService.listPublications();
				for (Publication publication : publications) {
					System.out.println(publication.toString());
				}

			} else if (input.equals("4")) {
				System.out.println("Enter isbn of the book you want to update: ");
				String isbn = in.readLine();
				System.out.println("Enter new title: ");
				String title = in.readLine();
				libraryService.updateBook(isbn, title);

			} else if (input.equals("5")) {
				System.out.println("Enter issn of the magazine you want to update: ");
				String issn = in.readLine();
				System.out.println("Enter new title: ");
				String title = in.readLine();
				libraryService.updateMagazine(issn, title);

			}

			else if (input.equals("6")) {
				System.out.println("Enter the isbn of the book you want to delete: ");
				String isbn = in.readLine();
				libraryService.deleteBook(isbn);

			} else if(input.equals("7")){
				System.out.println("Enter the issn of the magazine you want to delete: ");
				String issn = in.readLine();
				libraryService.deleteMagazine(issn);
			} else if(input.equals("8")){
				System.out.println("Enter name: ");
				String name = in.readLine();
				System.out.println("Enter email: ");
				String email = in.readLine();
				libraryService.registerMember(name, email);
			} else if(input.equals("9")){
				System.out.println("Enter your id: ");
				Long memberId = (long) Integer.parseInt(in.readLine());
				System.out.println("Enter the id of the publication you wish to borrow: ");
				Long publicationId = (long) Integer.parseInt(in.readLine());
				libraryService.registerLoan(memberId, publicationId);
			}
			
			
			else if (input.equals("END")) {
				System.out.println("Goodbye.");
				System.exit(0);

			}
		}
	}
}
