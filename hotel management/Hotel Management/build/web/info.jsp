<%--
Author- Arghya Das
From- Indian School Of Ethical Hacking
Used for selecting the room for which information is required.
--%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="java.io.*" %>
<html>
    <head>
        <link rel="stylesheet" href="import.css" type="text/css">
        <style>
            body {
                background-image: url("room_info.jpg");
                background-size: 100% auto;
            }
            h3 {
                margin-top: 10px;
    margin-bottom: 100px;
    margin-right: 700px;
    margin-left: 50px;
               position:relative;
               top:10px;
              left:20px;
              font-size: 20px;
              font-style: italic;
              color: black;
              background-color: yellow;
              border-radius: 20px;
               
                
            }
            
       </style>
        <script>
            <%    
                    Connection conn=null;
                    String driver=null;
                    String jdbcUrl=null;
                    String user=null;
                    String password=null;
                    Statement stmt=null;
                    String sql=null;
                    ResultSet rs=null;
                    String value;
            %>
            function check(){
                var chsep = document.getElementsByName("room");
                <%
                    try{
                        driver="oracle.jdbc.driver.OracleDriver";
                        Class.forName(driver);
                        jdbcUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
                        user="arghya";
                        password="pass";
                        conn = DriverManager.getConnection(jdbcUrl,user,password);
                        stmt = conn.createStatement();
                        int k=0;      
                        for(int i=1;i<=3;++i){
                        for(int j=1;j<=10;++j){
                            sql="select check_in from room where no="+String.valueOf((i*100)+j);
                            rs = stmt.executeQuery(sql);
                            while(rs.next()){
                                value = rs.getString(1);
                                
                   %>
                           if('<%=value%>'==='F'){
                               chsep[<%=k%>].style.backgroundColor = 'rgb(0, 255, 0)';
                               chsep[<%=k%>].disabled="true";
                            }
                            else{
                               chsep[<%=k%>].style.backgroundColor = 'rgb(255, 0, 0)';
                               
                            }
                            
                   <%
                           }
                           ++k; 
                        }
                     }
                     rs.close();
                     stmt.close();
                     conn.close();
                
                    }catch(Exception e){
                        e.printStackTrace();
                    }%>
                     
                
            }
            function append(but){
                //Create a form and append the data to the form as hidden variable.
                
                    var form = document.createElement("form");
                    form.setAttribute("method", "post");
                    form.setAttribute("action", "ginfo.jsp");
                    var hiddenField = document.createElement("input");
                    
                    hiddenField.setAttribute("type", "hidden");
                    hiddenField.setAttribute("name", "hide");
                    hiddenField.setAttribute("value", but.id);
                    form.appendChild(hiddenField);
                    document.body.appendChild(form);
                    form.submit();
            }
        </script>
    </head>
    <body onload="check();">
        <h3> select a room to check its complete booking details  :~ </h3>
        <div class="container">
         <div class="style_1">
             
             <h1>
                 Select Room Number::
             </h1>
            <fieldset>
              
            <button type="button" id="101" name="room" onclick="append(this);">101</button>
            <button type="button" id="102" name="room" onclick="append(this);">102</button>
            <button type="button" id="103" name="room" onclick="append(this);">103</button>
            <button type="button" id="104" name="room" onclick="append(this);">104</button>
            <button type="button" id="105" name="room" onclick="append(this);">105</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" id="106" name="room" onclick="append(this);">106</button>
            <button type="button" id="107" name="room" onclick="append(this);">107</button>
            <button type="button" id="108" name="room" onclick="append(this);">108</button>
            <button type="button" id="109" name="room" onclick="append(this);">109</button>
            <button type="button" id="110" name="room" onclick="append(this);">110</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" id="201" name="room" onclick="append(this);">201</button>
            <button type="button" id="202" name="room" onclick="append(this);">202</button>
            <button type="button" id="203" name="room" onclick="append(this);">203</button>
            <button type="button" id="204" name="room" onclick="append(this);">204</button>
            <button type="button" id="205" name="room" onclick="append(this);">205</button>
            <br><br><br><br><br><br><br><br><br><br><br><br>
            <button type="button" id="206" name="room" onclick="append(this);">206</button>
            <button type="button" id="207" name="room" onclick="append(this);">207</button>
            <button type="button" id="208" name="room" onclick="append(this);">208</button>
            <button type="button" id="209" name="room" onclick="append(this);">209</button>
            <button type="button" id="210" name="room" onclick="append(this);">210</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" id="301" name="room" onclick="append(this);">301</button>
            <button type="button" id="302" name="room" onclick="append(this);">302</button>
            <button type="button" id="303" name="room" onclick="append(this);">303</button>
            <button type="button" id="304" name="room" onclick="append(this);">304</button>
            <button type="button" id="305" name="room" onclick="append(this);">305</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" id="306" name="room" onclick="append(this);">306</button>
            <button type="button" id="307" name="room" onclick="append(this);">307</button>
            <button type="button" id="308" name="room" onclick="append(this);">308</button>
            <button type="button" id="309" name="room" onclick="append(this);">309</button>
            <button type="button" id="310" name="room" onclick="append(this);">310</button>

            </fieldset>
            <br>
                     
            <fieldset>
            <button type="button" onclick="location.href='home.jsp';">Back</button>
                                
            </fieldset>   
           
        </div>
    </body>
</html>