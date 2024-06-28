package com.dams.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginApp {

	public static void main(String[] args) {
		// declare all local variables at the top

		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;

		String LOGIN_CREDENTIALS = null;
		// load the driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// create the connection object

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dams1", "dams1");

			// step-3:: create the Statemeny object
			statement = connection.createStatement();

			// step-4: prepare the sql query
			LOGIN_CREDENTIALS = "select count(*)  from login_user where username='raja'  --and password='rani1'";

			// step-5:-send and execute the sql query and the get ResultSet object

			rs = statement.executeQuery(LOGIN_CREDENTIALS);
			int result = 0;
			if (rs.next()) {
				result = rs.getInt(1);
			}
			if (result == 0) {
				System.out.println("Invalid credentials");
			} else {
				System.out.println("valid credentials");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// close the connections

		finally {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

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

		}

	}

}
