/*
Author- Arghya Das
From- Indian School Of Ethical Hacking
Used for making respective changes in the table with respect to order.
*/

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
public class place1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    String room = request.getParameter("room");
                    String cuisine = request.getParameter("cuisine");
                    Connection conn=null;
                    String driver=null;
                    String jdbcUrl=null;
                    String user=null;
                    String password=null;
                    Statement stmt=null;
                    String sql=null;
                    ResultSet rs=null;
                    String value=null;
                    String address=null;
                    String contact=null;
                    int ret;
                    String gname=null;
                    String adate=null;
                    try{
                        driver="oracle.jdbc.driver.OracleDriver";
                        Class.forName(driver);
                        jdbcUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
                        user="arghya";
                        password="pass";
                        conn = DriverManager.getConnection(jdbcUrl,user,password);
                        stmt = conn.createStatement();
                        sql="select id from food where name='"+cuisine+"'";
                        System.out.println(sql);
                        rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            value = rs.getString(1);
                            
                        }
                        sql="insert into res values("+room+","+value+",'F')";
                        System.out.println(sql);
                        ret = stmt.executeUpdate(sql);
                        HttpSession session=request.getSession();
                        session.setAttribute("room", room);
                        session.setAttribute("cuisine", cuisine);
                        response.sendRedirect("/Hotel Management/place.jsp");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
    }

}
