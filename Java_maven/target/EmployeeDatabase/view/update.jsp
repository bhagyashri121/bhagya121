<!DOCTYPE html>
<html>
    <head>
        
        <style>
            
                      form
{
   font-size: 1em !important;
   font-family: Arial !important;
   font-weight: bold !important;
}
   
            
        body {
               background-color: #f4f7f8;
           }
           
           a:link, a:visited {
  color: white;
  padding: 10px 20px;
  background-color: #f44336;
  text-decoration: none;
  border: 0;
  display: inline-block;
  
  font-size: 1em !important;
  font-family: Arial !important;
  font-weight: bold !important;
}


a:hover, a:active {
    background-color: red;
}
           </style>
           
      <%@ page import="java.io.*" %>
      <%@ page import="javax.servlet.*" %>
      <%@ page import="javax.servlet.http.*" %>
      <%@ page import="java.sql.*" %>
      <%@ page import="java.util.Properties"%>
      <%@ page import="java.io.InputStream"%>

       <% String clickedLinkId = request.getParameter("id"); %>
      
    </head>
    <body>
         <%
          try
{
Properties prop = new Properties();

    	        InputStream input = null;
    	        String filename = "database_config.properties";
    		input = getClass().getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
                    //pw.println("file not found");
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
Class.forName(driver);
String query="select * from Emp where emp_id = '"+clickedLinkId+"'";
Connection conn=DriverManager.getConnection(connectionURL,uname,psword);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
      
while(rs.next())
{


%>

      <h2 style="background-color: #606060;color: white; text-align: center; font-family: Sans-serif; font-size: 30px;">UPDATE EMPLOYEE RECORD</h2>
 
      
<FORM METHOD="POST" ACTION="update_d">



<TABLE cellspacing="40">
  <TR>
    <TD>Name :</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="name" SIZE="20" value= "<%=rs.getString("name")%>" required>
    </TD>
  </TR>

<TR>
    <TD>Gender :</TD>
    <TD>
 <select name="gender">
  <option value="Male">Male</option>
  <option value="Female">Female</option>
</select>
    </TD>
</TR>

  <TR>
    <TD>Employee ID :</TD>
    <TD><INPUT TYPE="TEXT" NAME="emp_id" SIZE="25" value= "<%=rs.getString("emp_id")%>" required></TD>
  </TR>


<TR>
    <TD>Contact Number :</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="ph_no" SIZE="20" value= "<%=rs.getString("ph_no")%>"  required>
    </TD>
  </TR>
  <TR>
    <TD>Speciality :</TD>
    <TD><INPUT TYPE="TEXT" NAME="speciality" SIZE="25" value= "<%=rs.getString("speciality")%>" required></TD>
  </TR>
  
    <TR>
    <TD>Qualification Summary :</TD>
    <TD><INPUT TYPE="TEXT" NAME="qu_su" SIZE="25" value= "<%=rs.getString("qualification_summary")%>" required></TD>
  </TR>


  
  <input type="hidden" name="ID_to_update" value= <%=clickedLinkId%>>

<TR>
<TD><INPUT TYPE="SUBMIT" VALUE="Submit" NAME="B1"></TD>
</TR>
<%
}
%>

</TABLE>

 

</FORM> 
     
<%   
rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }
          
     %> 

     
    <a  href="display.jsp" > Back to Employee List</a>
    <a href="index.html" > Go to Homepage </a>
    </body>
    
</html>
