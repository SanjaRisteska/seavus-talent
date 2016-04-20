package presentation;

import service.LibraryService;

public class LibraryController {
	private LibraryService libraryService;

	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
	}
	
}


