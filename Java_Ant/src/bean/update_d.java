package bean;
import java.io.PrintWriter;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Properties;
import javax.servlet.http.*;  

public class  update_d extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException{
    
    
    PrintWriter pw = response.getWriter();
    
 String Emp_Id=request.getParameter("ID_to_update");   //Emp iD to be updated
 pw.println(Emp_Id); 
 
 int check = 0;
    
String name=request.getParameter("name");
String ph_no=request.getParameter("ph_no");
String emp_id=request.getParameter("emp_id");
String speciality=request.getParameter("speciality");
String gender=request.getParameter("gender");
String qu_su=request.getParameter("qu_su");


pw.println("trying to connect..");


// Declaring classes required for Database support 
Connection connection=null; 
ResultSet rs; 
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

//Add the data into the database 
String sql = "UPDATE Emp SET name = ?,sex = ?,emp_id = ?,speciality = ?,ph_no = ?,qualification_summary = ? WHERE emp_id = '"+Emp_Id+"' "; 

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
                            request.setAttribute("update_fail_message", "Failed to Update Employee Data");
                            request.getRequestDispatcher("./view/display.jsp").forward(request, response); 
                            //response.sendRedirect("/Employee_Database/update.jsp");
                        }
                        
                        else{
                            request.setAttribute("update_success_message", "Employee Data Updated Successfully");
                            request.getRequestDispatcher("./view/display.jsp").forward(request, response); 
                            //response.sendRedirect("/Employee_Database/display.jsp");
                        }
}
}












