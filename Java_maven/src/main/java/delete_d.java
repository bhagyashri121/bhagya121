import java.io.PrintWriter;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Properties;

public class  delete_d extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String Emp_Id = request.getParameter("id"); // Emp iD to be deleted
		pw.println(Emp_Id);

		int check = 0;

		pw.println("trying to connect..");

		// Declaring classes required for Database support
		Connection connection = null;
		ResultSet rs;
		try {

			Properties prop = new Properties();

			InputStream input = null;
			String filename = "database_config.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				pw.println("file not found");
				return;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// Setting connection Parameters
			String connectionURL = prop.getProperty("connectionURL");

			// Mysql user name and password whichever you have given during
			// installation
			String uname = prop.getProperty("uname");
			String psword = prop.getProperty("psword");
			String driver = prop.getProperty("driver");

			// Loading the available driver for a Database communication
			Class.forName(driver);

			pw.println("Registering driver Success..");

			// Creating a connection to the required database
			connection = DriverManager.getConnection(connectionURL, uname,
					psword);

			pw.println("Connection Success");

			// Add the data into the database
			String sql = "DELETE FROM Emp WHERE emp_id = '" + Emp_Id + "' ";

			PreparedStatement prep = connection.prepareStatement(sql);
			// Setting the values which we got from JSP form

			check = prep.executeUpdate();
			prep.close();

			pw.println("Values Deleted");

		} catch (Exception E) {
			// Any Exceptions will be caught here
			pw.println("The error is==" + E.getMessage());
		} finally {
			// After the entire execution this block will execute and the
			// connection with database gets closed
			try {
				connection.close();
			} catch (Exception e) {
				pw.println("The error is==" + e.getMessage());
			}
		}
		// if sql query doesn't run successfully executeUpdate returns 0 for
		// fail
		if (check == 0) {
			request.setAttribute("delete_fail_message",
					"Failed to delete Employee Data");
			request.getRequestDispatcher("./view/display.jsp").forward(request,
					response);
			// response.sendRedirect("/Employee_Database/display.jsp");
		}

		else {

			request.setAttribute("delete_success_message",
					"Employee data Deleted Successfully.");
			request.getRequestDispatcher("./view/display.jsp").forward(request,
					response);
			// response.sendRedirect("/Employee_Database/display.jsp");
		}
	}
}












