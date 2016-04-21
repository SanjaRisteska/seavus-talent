import java.io.IOException;

import com.seavus.dataaccess.BookPostgreRepository;
import com.seavus.presentation.LibraryController;
import com.seavus.service.LibraryService;

public class Library {

	public static void main(String[] args) throws IOException {
		LibraryController libraryController=new LibraryController(new LibraryService(new BookPostgreRepository()));
		libraryController.run();
	}

}
