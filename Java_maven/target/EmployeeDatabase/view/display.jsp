<html>
<head>
    
    
    
    <style>
        
                  form
{
   font-size: 1em !important;
   font-family: Arial !important;
   font-weight: bold !important;
}
   
        
        
 table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
        
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
</head>
<body>


<h2 style="background-color: #606060;color: white; text-align: center; font-family: Sans-serif; font-size: 30px;">EMPLOYEE DATABASE</h2>
<form action="update_delete" method="post">

    
    
<table  cellspacing="50">
    <tr style="background-color: yellow">
<td>Name</td>
<td>Gender</td>
<td>Employee ID</td>
<td>Contact Number</td>
<td>Speciality</td>
<td>Qualification Summary</td>
<td>Action</td>
    </tr>


<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Properties"%>
<%@ page import="java.io.InputStream"%>

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
String query="select * from Emp";
Connection conn=DriverManager.getConnection(connectionURL,uname,psword);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>

    <tr >
        <td><%=rs.getString("name") %></td>
        <td><%=rs.getString("sex") %></td>
        <td><%=rs.getString("emp_id") %></td>
        <td><%=rs.getString("ph_no") %></td>
        <td><%=rs.getString("speciality") %></td>
        <td><%=rs.getString("qualification_summary") %></td>
        
        <TD>
           <!-- <input type="radio" name="action" value="update"  > Update
           <input type="hidden" name="update_action" id=<%=rs.getString(1)%> >
           <input type="radio" name="action" value="delete"  > Delete
           <input type="hidden" name="delete_action" id=<%=rs.getString(1)%> >
       
        <INPUT TYPE="SUBMIT" VALUE="OK" NAME="submit"/>

 
         --> 
           
           
 
        <a href="update.jsp?id=<%=rs.getString(3) %>">Edit</a>
         
        <a href="delete_d?id=<%=rs.getString(3) %>" onclick="return confirm('Are you sure..?');">Delete</a>
        
        </TD> 
      
    </tr>
        <%

}
%>

    </table>


   
    
         </form>
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

    <div class="msg_position" style="color: #FF0000;">${update_fail_message}</div>  
     <div class="msg_position" style="color: #009933;;">${update_success_message}</div> 
    
     
     
     <div class="msg_position" style="color: #FF0000;">${delete_fail_message}</div> 
     <div class="msg_position" style="color: #009933;">${delete_success_message}</div> 

    <a href="add_new.jsp" > Add New Employee </a> 
    <a href="index.html" > Go to Homepage </a>  
 
</body>

  

</html> 