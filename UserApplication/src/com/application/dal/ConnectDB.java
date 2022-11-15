package com.application.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//The Database class defines the `getInstance` method that lets
//clients access the same instance of a database connection
//throughout the program.
public class ConnectDB {

	// The field for storing the singleton instance declared static.
	private static ConnectDB instance;
	private Connection connection;
	private String url = "jdbc:mysql:///UserApp";
	private String username = "root";
	private String password = "Think@1234";

	// The singleton's constructor is private to
	// prevent direct construction calls with the `new`
	// operator.
	private ConnectDB() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException ex) {
			System.out.println("Something is wrong with the DB connection String : " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	// The static method that controls access to the singleton
	// instance.
	public static ConnectDB getInstance() throws SQLException {
		if (instance == null) {
			instance = new ConnectDB();
		} else if (instance.getConnection().isClosed()) {
			instance = new ConnectDB();
		}
		return instance;
	}
}