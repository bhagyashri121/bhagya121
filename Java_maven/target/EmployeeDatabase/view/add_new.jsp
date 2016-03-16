<%-- 
    Document   : add_new
    Created on : Feb 17, 2016, 11:08:25 AM
    Author     : 32588
--%>

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
    </head>
    <body>
      <h2 style="background-color: #606060;color: white; text-align: center; font-family: Sans-serif; font-size: 30px;">ADD EMPLOYEE PROFILE</h2>


<FORM METHOD="POST" ACTION="add">



<TABLE cellspacing="40">
  <TR>
    <TD>Name :</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="name" SIZE="20" required>
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
    <TD><INPUT TYPE="TEXT" NAME="emp_id" SIZE="25" required></TD>
  </TR>


<TR>
    <TD>Contact Number :</TD>
    <TD>
      <INPUT TYPE="TEXT" NAME="ph_no" SIZE="20" required>
    </TD>
  </TR>
  <TR>
    <TD>Speciality :</TD>
    <TD><INPUT TYPE="TEXT" NAME="speciality" SIZE="25" required></TD>
  </TR>
  
  <TR>
    <TD>Qualification Summary :</TD>
    <TD><INPUT TYPE="TEXT" NAME="qu_su" SIZE="25" required></TD>
  </TR>


<TR>
<TD><INPUT TYPE="SUBMIT" VALUE="Submit" NAME="B1"></TD>
</TR>

</TABLE>

  
</FORM> 
      <div class="msg_position" style="color: #FF0000;">${add_fail_message}</div> 
      <div class="msg_position" style="color: #009933;">${add_success_message}</div> 
      
<a  href="display.jsp" > Back to Employee List</a>
    <a href="index.html" > Go to Homepage </a>

    </body>
    
</html>
