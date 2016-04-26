package com.seavus.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seavus.dataaccess.LoanRepository;
import com.seavus.dataaccess.MembershipRepository;
import com.seavus.dataaccess.PublicationRepository;
import com.seavus.domain.Book;
import com.seavus.domain.Loan;
import com.seavus.domain.Magazine;
import com.seavus.domain.Member;
import com.seavus.domain.Membership;
import com.seavus.domain.Publication;

@Component
public class LibraryService {
	PublicationRepository publicationRepository;
	MembershipRepository membershipRepository;
	LoanRepository loanRepository;

	@Autowired
	public LibraryService(PublicationRepository publicationRepository, MembershipRepository membershipRepository,
			LoanRepository loanRepository) {
		this.publicationRepository = publicationRepository;
		this.membershipRepository = membershipRepository;
		this.loanRepository = loanRepository;
	}

	public void registerBook(String isbn, String title) {
		Publication book = new Book(isbn, title);
		publicationRepository.save(book);
	}

	public void registerMagazine(String issn, String title) {
		Publication magazine = new Magazine(issn, title);
		publicationRepository.save(magazine);
	}

	public List<Publication> listPublications() {
		List<Publication> publication = publicationRepository.list();
		return publication;
	}

	public void updateBook(String isbn, String title) {
		Book book = new Book(isbn, title);
		publicationRepository.updateBook(book);
	}

	public void updateMagazine(String issn, String title) {
		Magazine magazine = new Magazine(issn, title);
		publicationRepository.updateMagazine(magazine);
	}

	public void deleteBook(String isbn) {

		publicationRepository.deleteBook(isbn);
	}

	public void deleteMagazine(String issn) {

		publicationRepository.deleteMagazine(issn);
	}

	public void registerMember(String name, String email) {
		Member member = new Member(name, email);
		Date startDate = new Date();
		long ltime = startDate.getTime() + 8 * 24 * 60 * 60 * 1000;
		Date endDate = new Date(ltime);

		Membership membership = new Membership(member, startDate, endDate, "");
		membershipRepository.save(member, membership);
	}

	public void registerLoan(Long memberId, Long publicationId) {
		Member member = new Member();
		Publication publication = new Book();
		Date startDate = new Date();
		long ltime = startDate.getTime() + 8 * 24 * 60 * 60 * 1000;
		Date endDate = new Date(ltime);
		Loan loan = new Loan(member, publication, startDate, endDate);
		loanRepository.registerLoan(loan);
	}

}
