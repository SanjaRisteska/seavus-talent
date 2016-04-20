package com.seavus.library;

import java.io.IOException;
import java.sql.SQLException;

import dataaccess.BookPostgreRepository;
import presentation.LibraryController;
import service.LibraryService;

public class LibraryApplication {

	public static void main(String[] args) throws IOException, SQLException {

		LibraryController libraryController = new LibraryController(new LibraryService(new BookPostgreRepository()));
		libraryController.run();
	}

}
