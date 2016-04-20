package com.seavus.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Library {

	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Library", "postgres",
				"Password1");
		return connection;
	}
	
	public String readInput() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input=in.readLine();
		return input;
	}

	public void menu() {
		System.out.println("Menu: ");
		System.out.println("1. Register new book.");
		System.out.println("2. List all books.");
		System.out.println("3. Update book.");
		System.out.println("4. Delete book.");
		System.out.println("Exit!");

	}

}
