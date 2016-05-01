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

	public void registerBook(Book book) {
		publicationRepository.save(book);
	}

	public void registerMagazine(Magazine magazine) {
		publicationRepository.save(magazine);
	}

	public List<Publication> listPublications() {
		List<Publication> publications = publicationRepository.list();
		return publications;
	}

	public List<Book> listBooks() {
		List<Book> books = publicationRepository.listBooks();
		return books;
	}

	public List<Magazine> listMagazines() {
		List<Magazine> magazines = publicationRepository.listMagazines();
		return magazines;
	}

	public List<Member> listMembers() {
		List<Member> members = membershipRepository.listMembers();
		return members;
	}
	
	public List<Loan> listLoans(){
		return loanRepository.listLoans();
	}

	public void updateBook(Book book) {
		publicationRepository.updateBook(book);
	}

	public void updateMagazine(Magazine magazine) {
		publicationRepository.updateMagazine(magazine);
	}

	public void deleteBook(Long id) {

		publicationRepository.deleteBook(id);
	}

	public void deleteMagazine(Long id) {

		publicationRepository.deleteMagazine(id);
	}

	public void registerMember(Member member) {
		Date startDate = new Date();
		long ltime = startDate.getTime() + 8 * 24 * 60 * 60 * 1000;
		Date endDate = new Date(ltime);

		Membership membership = new Membership(member, startDate, endDate, "");
		membershipRepository.save(member, membership);
	}

	public void registerLoan(Long memberId, Long publicationId) {
		Member member = membershipRepository.findMember(memberId);
		Publication publication = publicationRepository.findPublication(publicationId);
		Date startDate = new Date();
		long ltime = startDate.getTime() + 8 * 24 * 60 * 60 * 1000;
		Date endDate = new Date(ltime);
		Loan loan = new Loan(member, publication, startDate, endDate);
		loanRepository.registerLoan(loan);
	}

	public Book findBook(Long id) {
		return publicationRepository.findBook(id);
	}

	public Magazine findMagazine(Long id) {
		return publicationRepository.findMagazine(id);
	}

}
