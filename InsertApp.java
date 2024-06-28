package com.vsics.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp {

	public static void main(String[] args) {
		// define all the local variables at the top of method
		Connection connection = null;
		Statement statement = null;
		String INSERT_STUDENT_RECORD = null;
		Scanner scanner = null;
		int id = 0, noOfRowsInserted = 0;
		String name = null, address = null;
		// step-1: Translator -->Load the Driver class [Oracle DB->OracleDriver]
		try {
			scanner = new Scanner(System.in);
			System.out.println("Please enter sid ");
			id = scanner.nextInt();

			System.out.println("Please student name ");
			name = scanner.next();
			name = "'" + name + "'";
			System.out.println("Please student address ");
			address = scanner.next();
			address = "'" + address + "'";
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step-2: Path ==>crate the Connection object (Interface)

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dams1", "dams1");
			System.out.println("ClassName of connection ref=" + connection.getClass().getName());

			// step-3: ==>create Vehicle ==>Statement object
			if (connection != null) {
				statement = connection.createStatement();
			}
			System.out.println("Statement interface impl class for oracle ::" + statement.getClass().getName());
			// Step-4 Requirement==?SQL query
			INSERT_STUDENT_RECORD = "insert into student values (" + id + " ," + name + " ," + address + ")";
			System.out.println("Query =" + INSERT_STUDENT_RECORD);

			// step-5: send and execute SQL query into db
			if (statement != null) {
				noOfRowsInserted = statement.executeUpdate(INSERT_STUDENT_RECORD);
			}

			if (noOfRowsInserted == 0) {
				System.out.println("Record not inserted for stduent id= " + id);
			} else {
				System.out.println("Record inserted for " + id);
			}

			// handling known exceptions
		} catch (ClassNotFoundException classNotFoundException) {
			classNotFoundException.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// handling unknown exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
		// close all the connections in reverse order
		finally {
			try {
				statement.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

			scanner.close();
		} // finally
	}// main

}// class
