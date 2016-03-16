/*
Author-Arghya Das
From- Indian School Of Ethical Hacking
Used to update the relevant tables after departure.
*/
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpSession;
public class update1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    String hide = request.getParameter("hide");
                    String ename=request.getParameter("ename");
                    Connection conn=null;
                    String driver=null;
                    String jdbcUrl=null;
                    String user=null;
                    String password=null;
                    Statement stmt=null;
                    String sql=null;
                    ResultSet rs=null,rs1=null;
                    String value=null;
                    String gid=null;
                    int tr,ret;
                    String d=null;
                    String gname=null;
                    String adate=null;
                    long price=0;
                    double vat=0;
                    double tp=0;
                    long food=0;
                    try{
                        driver="oracle.jdbc.driver.OracleDriver";
                        Class.forName(driver);
                        jdbcUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
                        user="arghya";
                        password="pass";
                        conn = DriverManager.getConnection(jdbcUrl,user,password);
                        stmt = conn.createStatement();
                        sql="select gid from map where rno="+hide+" and departure is null";
                        System.out.println(sql);
                        rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            value = rs.getString(1);
                            gid=value;
                            System.out.println("gid: "+gid);
                        }
                        sql = "select tr,name,to_char(arrival,'dd/mm/yyyy') from guest where id="+value;
                        System.out.println(sql);
                        rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            value=rs.getString(1);
                            System.out.println("value: "+value);
                            gname = rs.getString(2);
                            adate = rs.getString(3);
                        }
                        tr=Integer.parseInt(value)-1;
                        if(tr==0){
                            sql="update guest set tr=0,checkedout='T' where id="+gid;
                            System.out.println(sql);
                            ret=stmt.executeUpdate(sql);
                            System.out.println(ret);
                        }
                        else{
                            sql="update guest set tr="+tr+",checkedout='F' where id="+gid;
                            System.out.println(sql);
                            ret=stmt.executeUpdate(sql);
                            System.out.println(ret);
                        }
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	     Date date = new Date();
                        d=dateFormat.format(date);
                        sql="update map set departure=to_date('"+d+"','dd/mm/yyyy hh24:mi:ss') where gid="+gid+" and rno="+hide;
                        System.out.println(sql);
                        ret=stmt.executeUpdate(sql);
                        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        d=dateFormat.format(date);
                        System.out.println(d);
                        sql="update room set check_in='F' where no="+hide;
                        System.out.println(sql);
                        ret=stmt.executeUpdate(sql);
                        sql="select p_id from room where no="+hide;
                        System.out.println(sql);
                        rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            value=rs.getString(1);
                        }
                        sql="select cost from price where id="+value;
                        System.out.println(sql);
                        rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            value=rs.getString(1);
                        }
                        Date departure = dateFormat.parse(d);
                        Date arrival = dateFormat.parse(adate);
                        long diff = departure.getTime()-arrival.getTime();
                        long days=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+1;
                        price=Integer.parseInt(value);
                        price=price*days;
                        sql="select fid from res where rno="+hide+" and paid='F'";
                        rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            value=rs.getString(1);
                            sql="select cost from food where id="+value;
                            rs1=stmt.executeQuery(sql);
                            while(rs1.next()){
                                value=rs1.getString(1);
                                price = price+Integer.parseInt(value);
                            }
                        }
                        sql="update res set paid='T' where rno="+hide;
                        System.out.println(sql);
                        ret=stmt.executeUpdate(sql);
                        vat=0.1236*price;
                        tp=price+vat;
                        System.out.println ("Days: " + days);
                        HttpSession session=request.getSession();
                        session.setAttribute("ename", ename);
                        session.setAttribute("gname", gname);
                        session.setAttribute("hide", hide);
                        session.setAttribute("adate", adate);
                        session.setAttribute("d", d);
                        session.setAttribute("price", price);
                        session.setAttribute("vat", vat);
                        session.setAttribute("tp", tp);
                        response.sendRedirect("/Hotel Management/update.jsp");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
    }

}
