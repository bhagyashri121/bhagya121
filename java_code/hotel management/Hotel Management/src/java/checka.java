/*
Author- Arghya Das
From- Indian School Of Ethical Hacking
*/
/*
This file checks the login information provided by logina.jsp.
If correct, then forward to room.jsp for completing the reservation.
If incorrect, then redirects back to logina.jsp.
*/
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class checka extends HttpServlet {
    
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
                        jdbcUrl="jdbc:oracle:thin:@localhost:1521:orcl";
                        user="arghya";
                        password="pass";
                        conn = DriverManager.getConnection(jdbcUrl,user,password);
                        stmt = conn.createStatement();
                        sql="select name from employee where login='"+login+"' and password='"+pass+"'";
                        rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            value=rs.getString(1);
                            
                        }
                        //If does not match, then go back.
                        if(value==null){
                            response.sendRedirect("/Hotel Management/logina.jsp");
                        }
                        //Else go to room.jsp.
                        else{
                            response.sendRedirect("/Hotel Management/room.jsp");
                        }
                                
                    }catch(Exception e){
                        e.printStackTrace();
                    }

    }


}
