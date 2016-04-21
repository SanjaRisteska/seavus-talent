package com.seavus.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.seavus.domain.Book;

public class BookPostgreRepository implements BookRepository{

	public void save(Book book) {
		PreparedStatement preparedStatement;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Library", "postgres",
					"Password1");
			preparedStatement = connection.prepareStatement("insert into book(isbn, title) values (?, ?)");
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Book is inserted!");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}		
	}

	public void update(Book book) {
		PreparedStatement preparedStatement;
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Library", "postgres",
					"Password1");
			preparedStatement = connection.prepareStatement("UPDATE book SET title = ? WHERE isbn = ?");
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getIsbn());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Update done!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}	
		
	}

	public void delete(String isbn) {
		PreparedStatement preparedStatement;
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Library", "postgres",
					"Password1");
			preparedStatement = connection.prepareStatement("DELETE FROM book WHERE isbn = ?");
			preparedStatement.setString(1, isbn);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			System.out.println("Book deleted!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}	
	}

	public LinkedList<Book> list() {
		Connection connection = null;
		LinkedList<Book> books = new LinkedList<Book>();
		try{
			
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Library", "postgres", "Password1");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from book");
			

			
			while (resultSet.next()) {
			    String isbn = resultSet.getString("isbn");
			    String title = resultSet.getString("title");
			    Book book=new Book(isbn,title);
			    books.add(book);
			}
			statement.close();
			
			}catch (SQLException e) {
				throw new RuntimeException(e);
				}
			finally{
				try {
					connection.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}	
		return books;
	}

}
