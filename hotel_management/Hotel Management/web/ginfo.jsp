<%--
Author- Arghya Das
From- Indian School Of Ethical Hacking
Display information about the room selected.
--%>
<html>
    <head>
        <style>
            body {
                background-image: url("room_sel_03.jpg");
                background-size: 100% auto;
            }
        </style>

        <script>
            function check(){
                
                <%@page language="java" import="java.sql.*"%>
                <%@page language="java" import="java.io.*" %>
                <%
                    String hide = request.getParameter("hide");
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
                        sql="select gid from map where rno="+hide+" and departure is null";
                        System.out.println(sql);
                        rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            value = rs.getString(1);
                            
                        }
                        sql = "select name,to_char(arrival,'dd/mm/yyyy'),address,contact from guest where id="+value;
                        System.out.println(sql);
                        rs=stmt.executeQuery(sql);
                        while(rs.next()){
                            gname = rs.getString(1);
                            adate = rs.getString(2);
                            address = rs.getString(3);
                            contact = rs.getString(4);
                        }
                        
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                %>
            }
        </script>
    </head>
    <body onload="check();">
        <div style="background-color: bisque; position: absolute;top: 10%;left: 30%">
            <fieldset>
                
                <label style="font-size: 30px;">Name: <%=gname%></label>
                <br>
                <label style="font-size: 30px;">Room: <%=hide%></label>
                <br>
                <label style="font-size: 30px;">Arrival Date: <%=adate%></label>
                <br>
                <label style="font-size: 30px;">Address: <%=address%></label>
                <br>
                <label style="font-size: 30px;">Contact: <%=contact%></label>
                
            </fieldset>
            <button type="button" onclick="location.href='info.jsp'">OK</button>
        </div>
    </body>
</html>
