package com.seavus.dataaccess;

import java.util.List;

import com.seavus.domain.Book;
import com.seavus.domain.Magazine;
import com.seavus.domain.Publication;

public interface PublicationRepository {
	public void save(Publication publication);
	public void updateBook(Book book);
	public void updateMagazine(Magazine magazine);
	public void deleteBook(String isbn);
	public void deleteMagazine(String issn);
	public List<Publication> list();
}
