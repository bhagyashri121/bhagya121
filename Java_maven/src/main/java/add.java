import java.io.PrintWriter;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Properties;

public class  add extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{
    
    
    PrintWriter pw = response.getWriter();
    
String name=request.getParameter("name");
String ph_no=request.getParameter("ph_no");
String emp_id=request.getParameter("emp_id");
String speciality=request.getParameter("speciality");
String gender=request.getParameter("gender");
String qu_su=request.getParameter("qu_su");

int check = 0;

pw.println("trying to connect..");


// Declaring classes required for Database support 
Connection connection=null; 
 
try { 
    Properties prop = new Properties();

    	        InputStream input = null;
    	        String filename = "database_config.properties";
    		input = getClass().getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
                    pw.println("file not found");
    		    return;
                }
                
                //load a properties file from class path, inside static method
    		prop.load(input);
                
                //Setting connection Parameters 
String connectionURL=prop.getProperty("connectionURL");


// Mysql user name and password whichever you have given during installation 
String uname=prop.getProperty("uname");
String psword=prop.getProperty("psword");
String driver = prop.getProperty("driver");
                
// Loading the available driver for a Database communication 
Class.forName(driver); 


pw.println("Registering driver Success..");

//Creating a connection to the required database 
connection = DriverManager.getConnection (connectionURL, uname, psword); 


pw.println("Connection Success");

String queryCheck = "SELECT name from Emp WHERE emp_id = '"+emp_id+"'" ;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(queryCheck); // execute the query, and get a java resultset
            // if this ID already exists, we quit
            if(rs.absolute(1)) {
                connection.close();
                request.setAttribute("add_fail_message", "Employee with ID = '"+emp_id+"' already exists in Database");
                request.getRequestDispatcher("/add_new.jsp").forward(request, response);     
            }

//Add the data into the database 
String sql = "INSERT INTO Emp (name, sex, emp_id, speciality, ph_no, qualification_summary) VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE name=VALUES(name), sex=VALUES(sex), emp_id=VALUES(emp_id),speciality=VALUES(speciality),ph_no=VALUES(ph_no),qualification_summary=VALUES(qualification_summary);"; 

PreparedStatement prep = connection.prepareStatement(sql); 
// Setting the values which we got from JSP form 

  prep.setString(1, name);
  prep.setString(2, gender);
  prep.setString(3, emp_id);
  prep.setString(4,speciality );
  prep.setString(5,ph_no );
  prep.setString(6,qu_su );
  
  
  prep.executeUpdate();
  check = prep.executeUpdate();
  
  prep.close();
  
  pw.println("Values Inputted");
 
  
  
}catch(Exception E){
//Any Exceptions will be caught here 
pw.println("The error is=="+E.getMessage()); 
} 
finally{
    //After the entire execution this block will execute and the connection with database gets closed 
    try {
    connection.close(); 
    }
    catch(Exception e)
        {
     pw.println("The error is=="+e.getMessage());    
    }
} 
  //if sql query doesn't run successfully executeUpdate returns 0 for fail 
    if(check == 0){
                            request.setAttribute("add_fail_message", "Failed to Add new Employee.");
                            request.getRequestDispatcher("../view/add_new.jsp").forward(request, response); 
                            //response.sendRedirect("/Employee_Database/index.html");
                        }
                        
                        else{
                            request.setAttribute("add_success_message", "New Employee Added to Database.");
                            request.getRequestDispatcher("./view/add_new.jsp").forward(request, response); 
                           // response.sendRedirect("/Employee_Database/add_new.jsp");
                        }                   
}
}












