/*
Author- Arghya Das
From- Indian School Of Ethical Hacking
*/
/*
This file checks the login information provided by logini.jsp.
If correct, then forward to info.jsp for obtaining information.
If incorrect, then redirects back to logini.jsp.

*/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class checki extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    String login=request.getParameter("login") ;
                    String pass = request.getParameter("pass") ;
                    Connection conn=null;
                    String driver=null;
                    String jdbcUrl=null;
                    String user=null;
                    String password=null;
                    Statement stmt=null;
                    String sql=null;
                    ResultSet rs=null;
                    String value=null;
                    
                    try{
                        driver="oracle.jdbc.driver.OracleDriver";
                        Class.forName(driver);
                        jdbcUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
                        user="arghya";
                        password="pass";
                        conn = DriverManager.getConnection(jdbcUrl,user,password);
                        stmt = conn.createStatement();
                        sql="select name from employee where login='"+login+"' and password='"+pass+"'";
                        rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            value=rs.getString(1);
                            
                        }
                        if(value==null){
                            response.sendRedirect("/Hotel Management/logini.jsp");
                        }
                        else{
                            response.sendRedirect("/Hotel Management/info.jsp");
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
    }

}
