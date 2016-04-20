package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import domain.Book;

public class BookPostgreRepository implements BookRepository {

	@Override
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

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public LinkedList<Book> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
