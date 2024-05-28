package com.vsics.fs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteEmployeeServlet extends HttpServlet {
	ServletContext servletContext = null;
	String driver = null, user = null, url = null, password = null;
	Connection con = null;
	String DELETE_EMP_BY_ID = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;

	@Override
	public void init() throws ServletException {
		// read technical values from web.xml
		// create ServletContext

		servletContext = getServletContext();
		driver = servletContext.getInitParameter("driver");
		url = servletContext.getInitParameter("url");
		user = servletContext.getInitParameter("user");
		password = servletContext.getInitParameter("pass");

		// load the driver class
		try {
			Class.forName(driver);
			// Create the Connection object
			con = DriverManager.getConnection(url, user, password);
			// prepare sql query
			DELETE_EMP_BY_ID = "delete from emp where eid=?";
			// get pre compiled query using PreparedStatement object

			if (con != null) {
				ps = con.prepareStatement(DELETE_EMP_BY_ID);
			}
			// Handling known exceptions
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} // handling unknown exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// set mime type
		resp.setContentType("text/html");
		// get PrintWriter object
		pw = resp.getWriter();
		// read form data

		String id = req.getParameter("id");
		int eid = Integer.parseInt(id);

		// set input values to place holder ?

		int result = 0;
		try {
			if (ps != null) {
				ps.setInt(1, eid);

				// execute sql query
				result = ps.executeUpdate();
			}

			if (result == 0) {
				pw.println("<h1> Record not deleted for :: " + eid + "</h1>");
			} else {
				pw.println("<h1> Record deleted for :: " + eid + "</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// handling unknown exception
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// write cleanup code | close the connections in reverse order
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pw.close();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
