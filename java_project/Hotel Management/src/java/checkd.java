/*
Author- Arghya Das
From- Indian School Of Ethical Hacking
*/
/*
This file checks the login information provided by logind.jsp.
If correct, then forward to status.jsp for completing the departure.
If incorrect, then redirects back to logind.jsp.
This file also makes use of the concept of cookies.
*/
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
public class checkd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Cookie[] cookies = request.getCookies();//Get all the cookies.
            String value=null;
            String login=null;
            String pass=null;
            Connection conn=null;
            String driver=null;
            String jdbcUrl=null;
            String user=null;
            String password=null;
            Statement stmt=null;
            String sql=null;
            ResultSet rs=null;
            HttpSession session;
            login=request.getParameter("login") ;
            pass=request.getParameter("pass") ;
            try{
                        driver="oracle.jdbc.driver.OracleDriver";
                        Class.forName(driver);
                        jdbcUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
                        user="arghya";
                        password="pass";
                        conn = DriverManager.getConnection(jdbcUrl,user,password);
                        stmt = conn.createStatement();
                        //If login id and password are provided through request, then check.
                        if((login!=null)&&(pass!=null)){
                        sql="select name from employee where login='"+login+"' and password='"+pass+"'";
                            rs=stmt.executeQuery(sql);
                            while(rs.next()){
                                value=rs.getString(1);
                                
                            }
                            //If does not exist, then go back to logind.jsp.
                            if(value==null){
                                response.sendRedirect("/Hotel Management/logind.jsp");
                            }
                            /*Else set two cookies depicting login id and password and send to employee computer.
                            A session variable is also used to transfer the employee name to status.jsp.
                            The variable could have been appended directly to request, like:
                                request.setAttribute("logname", "value");
                                request.getRequestDispatcher("status.jsp").forward(request, response);
                            However, the problem with this code is, the url shall remain fixed to this servlet url since there was
                            no page redirection. That is why we require redirect, so that the url is changed.
                            */
                            else{
                                Cookie cookie1 = new Cookie("logname",login);
                                Cookie cookie2 = new Cookie("password",pass);
                                response.addCookie(cookie1);
                                response.addCookie(cookie2);
                                session = request.getSession(false);
                                session.setAttribute("logname", value);
                                response.sendRedirect("/Hotel Management/status.jsp");
                            }
                        }
                        /*
                        If no login id or password is provided, then it checks for cookies.
                        */
                        else{
                            Cookie cookie=null;
                            for(int i=0;i<cookies.length;++i){
                                cookie = cookies[i];
                                if((cookie.getName().equals("logname"))&&(cookie!=null)){
                                    login = cookie.getValue();
                                }
                                if((cookie.getName().equals("password"))&&(cookie!=null)){
                                    pass = cookie.getValue();
                                }
                            }
                            /*
                            Check if a valid employee was found.
                            Note, since the browser overwrites a cookie with same name in it's cookiejar, the cookie
                            we received contains the name of the last employee to login to the segment.
                            */
                            if((login!=null)&&(pass!=null)){
                                /*
                                Rechecking the login id and password is required, otherwise the system would be vulnerable
                                from cookie injection, as anyone can easily inject cookie into the cookijar.
                                Just checking for availability of cookie is not enough, we also need to check for validity.
                                Also the cookie received might be too old and contain incorrect data, so checking is the only
                                logical solution.
                                */
                            sql="select name from employee where login='"+login+"' and password='"+pass+"'";
                            rs=stmt.executeQuery(sql);
                            while(rs.next()){
                                value=rs.getString(1);
                                
                            }
                            if(value==null){
                                response.sendRedirect("/Hotel Management/logind.jsp");
                            }
                            else{
                                session = request.getSession(false);
                                session.setAttribute("logname", value);
                                response.sendRedirect("/Hotel Management/status.jsp");
                            }
                            }
                            /*
                            If cookie did not contain either of the fields, then ask for login again.
                            */
                            else{
                                response.sendRedirect("/Hotel Management/logind.jsp");
                            }
                            
                        }
                }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
}
    
    
    
    