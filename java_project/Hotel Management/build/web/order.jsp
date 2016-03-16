<%--
Author- Arghya Das
From- Indian School Of Ethical Hacking
Used for selecting the food for the concerned room.
--%>
<html>
    <head>
        <style>
            body {
                background-image: url("foo_court.jpg");
                background-size: 100% auto;
            }
        </style>

        <script>
            function check(){
                var sel = document.getElementById("3");
                
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
                        sql="select name from food";
                        System.out.println(sql);
                        rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            value = rs.getString(1);
                        %>
                                var nop = document.createElement('option');
                                nop.selected = true;
                                nop.text = '<%=value%>';
                                nop.value = '<%=value%>';
                                sel.appendChild(nop);
                        
                        <%    
                        
                        
                        }
                        
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                %>
                
            }
        </script>
    </head>
    <body onload="check();">
        <div style="background-color: bisque; position: absolute;top: 40%;left: 30%">
            <form name="forms" action="place1" method="post">
            <fieldset>
                <label style="font-size: 30px;">Room: </label>
                <input value="<%=hide%>" style="height: 25px; font-size: 20px;" type="text" id="room" name = "room" readonly="true"/>
                <br>
                <label style="font-size: 25px;">Selected Cuisines : </label>
                <select id="3" name="cuisine" style="width: 120px;height: 20px;">
                
                </select>
                <button type="button" onclick="location.href='food.jsp'">Back</button>
                <button type="submit">Place Order</button>
            </fieldset>
            </form>
            
        </div>
    </body>
</html>