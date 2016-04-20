package com.seavus.library;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryApplication {

	public static void main(String[] args) throws IOException {
		Library lib = new Library();

		lib.menu();
		String input = lib.readInput();

		while (!(input.equals("5"))) {
			switch (input) {
			case "1": {
				break;
			}
			case "2": {

			}
			case "3": {

			}
			case "4": {

			}

			}

			lib.readInput();

		}

		System.out.println("Insert new book: \n Enter the title: ");
		String title = lib.readInput();
		System.out.println("Enter ISBN: ");
		String isbn = lib.readInput();
		Connection con = null;
		PreparedStatement preparedStatement;

		try {
			con = lib.getConnection();
			preparedStatement = con.prepareStatement("insert into book(isbn, title) values (?, ?)");
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, isbn);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}

	}

}
