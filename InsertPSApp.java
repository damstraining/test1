package com.dams.jdbc.ps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertPSApp {

	public static void main(String[] args) {

		Scanner scanner = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		// load the driver class
		try {
			// reading input at runtime from end user using scanner
			scanner = new Scanner(System.in);
			System.out.println("Please enter customer id");
			int id = scanner.nextInt();
			System.out.println("Please enter customer name");
			String name = scanner.next();
			System.out.println("Please enter amount");
			double amt = scanner.nextDouble();
			System.out.println("Please enter customer address");
			String add = scanner.next();

			// lading driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// creating Connection object
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dams1", "dams1");

			// preparing sql query using place holder
			String query = "insert into customer values(?,?,?,?)";
			if (connection != null) {
				// sending sql query to db and getting pre compiled sql query
				preparedStatement = connection.prepareStatement(query);
			}

			// set values to preparedStatement object (compiled query)
			if (preparedStatement != null) {
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setDouble(3, amt);
				preparedStatement.setString(4, add);
				// execute sql query
				result = preparedStatement.executeUpdate();
			}

			if (result == 0) {
				System.out.println("record not inserted");
			} else {
				System.out.println("Record inserted ");
			}

			// handling known exception
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

			// handling unknown exceptions
		} catch (Exception e) {
			e.printStackTrace();
			// closing all the connections
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			scanner.close();
		}

	}

}
