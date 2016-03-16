/*
Author- Arghya Das
From- Indian School Of Ethical Hacking
This is used to enter data into the concerned tables to complete the reservation.
*/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
public class thank1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String fname = request.getParameter("fname");
           String mname = request.getParameter("mname");
           String lname = request.getParameter("lname");
           String address = request.getParameter("address");
           String contact = request.getParameter("contact");
           String adroom = request.getParameter("adroom");
           String sroom = request.getParameter("sroom");
           String date = request.getParameter("adate");
           String time = request.getParameter("atime");
           String nameroom[] = request.getParameterValues("nameroom");
           Connection conn=null;
           String driver=null;
           String jdbcUrl=null;
           String user=null;
           String password=null;
           Statement stmt=null;
           String sql=null;
           ResultSet rs=null;
           String value=null;
           int id=1;
           String name;
           try{
                        driver = "oracle.jdbc.driver.OracleDriver";
                        Class.forName(driver);
                        
                        jdbcUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
                        user = "arghya";
                        password = "pass";
                        conn = DriverManager.getConnection(jdbcUrl,user,password);
                        
                        stmt = conn.createStatement();
                        sql = "select max(id) from guest";
                        rs = stmt.executeQuery(sql);
                        System.out.println("world");
                        while(rs.next()){
                                value = rs.getString(1);
                                
                                if(value!=null){
                                    id=Integer.parseInt(value);
                                    id=id+1;
                                }
                                else{
                                    
                                }
                        }
                        if(mname!=null){
                            name = fname+" "+mname+" "+lname;
                        }
                        else{
                            name = fname+" "+lname;
                        }
                        String arrival = date+" "+time;

                        sql="insert into guest values("+String.valueOf(id)+",'"+name+"','"+address+"',"+contact+",to_date('"+arrival+"','dd/mm/yyyy hh24:mi:ss'),"+adroom+","+sroom+","+String.valueOf(nameroom.length)+",'F')";
                        int ret = stmt.executeUpdate(sql);
                        System.out.println(ret);
                        for(int i=0;i<nameroom.length;++i){
                            sql="insert into map values("+String.valueOf(id)+","+nameroom[i]+",'')";
                            ret = stmt.executeUpdate(sql);
                            System.out.println(ret);
                            sql="update room set check_in='T' where no="+nameroom[i];
                            ret=stmt.executeUpdate(sql);
                            System.out.println(ret);
                        
                        }
                    
                    rs.close();
                    stmt.close();
                    conn.close();
                    HttpSession session = request.getSession(false);
                    session.setAttribute("fname", fname);
                    session.setAttribute("lname", lname);
                    session.setAttribute("adate", date);
                    session.setAttribute("atime", time);
                    response.sendRedirect("/Hotel Management/thank.jsp");
                    }catch(Exception e){
                        System.out.println("hello");
                        e.printStackTrace();
                    }
                    
    }

}
