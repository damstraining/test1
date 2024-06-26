package com.dams.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class DeleteJDBCApp {

	public static void main(String[] args) {
		Scanner scanner = null;
		Connection connection = null;
		Statement statement = null;
		String query = null,name=null;

		// Step-1: Translator ==>load the driver class

		// Driver class-->
		try {
			scanner = new Scanner(System.in);
			System.out.println("Please enter customer name to delelet record from db");

			 name = scanner.next();
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step-2: Path==>create the Connection object
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dams1", "dams1");

			// step-3:-Vehicle ==>create the Statement object

			statement = connection.createStatement();

			// step-4: Requirement ==>prepare sql query
			
			System.out.println(name);
			
			name="'"+name+"'";
			
			System.out.println(name);
			

			query = "delete from customer where cname=" + name;
			
			System.out.println(query);

			// step-5:-send and execute the sql query
			int result = statement.executeUpdate(query);

			if (result == 0) {
				System.out.println("Record not deleted for customer name " + name);
			} else {
				System.out.println("Record deleted for customer id " + name);
			}

			// Handling known exceptions
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// step-6 close all connections in reverse order
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

		} // finally block

	}// main

}// class
