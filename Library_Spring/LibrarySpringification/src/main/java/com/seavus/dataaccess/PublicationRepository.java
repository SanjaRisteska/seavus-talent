package com.seavus.dataaccess;

import java.util.List;

import com.seavus.domain.Book;
import com.seavus.domain.Magazine;
import com.seavus.domain.Publication;

public interface PublicationRepository {
	public void save(Publication publication);
	public void updateBook(Book book);
	public void updateMagazine(Magazine magazine);
	public void deleteBook(Long id);
	public void deleteMagazine(Long id);
	public List<Publication> list();
	public List<Book> listBooks();
	public List<Magazine> listMagazines();
	public Book findBook(Long id);
	public Magazine findMagazine(Long id);
	public Publication findPublication(Long id);
}
