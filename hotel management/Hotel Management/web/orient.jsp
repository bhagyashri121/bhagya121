<%--
Author- Arghya Das
From- Indian School Of Ethical Hacking

    Used for selecting the rooms themselves.
--%>
<html>
    <head>
        
         <link rel="stylesheet" href="import.css" type="text/css">
        
  <style>
            body {
                background-image: url("room2.jpg");
                background-size: 100% auto;
            }
             </style>

       
         <script>
            <% String room = request.getParameter("room");
            String adroom = request.getParameter("adroom");
            String seproom = request.getParameter("nsep");%>
            function check(){
                /*
                 Checks the availability of a room. If a room is available then shown as green. Else red.
                 ID 1 represents number of adjoining rooms field.
                 ID 2 represents number of separate rooms field.
                 */
                
                var r = <%=room%>;
                var ad = <%=adroom%>;
                
                var ns = <%=seproom%>;
                
                var cad = document.getElementById("1");
                var ser = document.getElementById("2");
                //If number of adjoining rooms not sent, then all should be adjoined.
                if(ad){
                    
                    cad.value = ad;
                    ser.value = ns;
                }
                else{
                    
                    cad.value = r;
                    ser.value = 0;
                    
                }
                <%@page language="java" import="java.sql.*"%>
                var chsep = document.getElementsByName("room");
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
                    try{
                        driver="oracle.jdbc.driver.OracleDriver";
                        Class.forName(driver);
                        jdbcUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
                        user="arghya";
                        password="pass";
                        conn = DriverManager.getConnection(jdbcUrl,user,password);
                        stmt = conn.createStatement();
                        
                    }catch(Exception e){
                        e.printStackTrace();
                    }
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
                               
                            }
                            else{
                               chsep[<%=k%>].style.backgroundColor = 'rgb(255, 0, 0)';
                               chsep[<%=k%>].disabled="true";
                            }
                   <%
                           }
                           ++k; 
                        }
                     }
                     rs.close();
                     stmt.close();
                     conn.close();
                %>
                
            }
            function append(but){
                //Append the room to the <select> tag.
                var sel = document.getElementById("3");
                var dis = document.getElementById("4");
                <%
                     int i=Integer.parseInt(room);
                %>
                var len = <%=room%>;
                if(but.style.backgroundColor==="rgb(255, 255, 255)"){
                    but.style.backgroundColor='rgb(0, 255, 0)';
                    var options = document.getElementsByTagName("option");
                    for(var x=0;x<options.length;++x){
                        if(options[x].value===but.id){
                            sel.remove(x);
                            break;
                        }    
                    }
                    if(sel.length<len){
                        dis.disabled=true;
                    }
                }
                else{
                    if(sel.length===len){
                    alert("Exceeding Limit!");
                    }
                    else{
                        but.style.backgroundColor='rgb(255, 255, 255)';
                        var nop = document.createElement('option');
                        nop.selected = true;
                        nop.text = but.id;
                        nop.value = but.id;
                        sel.appendChild(nop);
                        if(sel.length===len){
                            dis.disabled = false;
                        }
                    }
                }
            }
        </script>           
    </head>
    <body onload="check();">
        
        <div class="container">
         <div class="style_1">
             <h1> Orientation of rooms :: </h1>
        
       
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
            <form action="form.jsp" method="get">
            <fieldset>
                <label style="font-size: 25px;">Number of Adjoining Rooms: </label>
                <input style="height: 25px; font-size: 20px;" type="text" id="1" name = "addroom" readonly="true"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 25px;">Number of Separate Rooms: </label>
                <input style="height: 25px; font-size: 20px;" type="text" id="2" name = "sroom" readonly="true"/>
                <br>
                <label style="font-size: 25px;">Selected Rooms : </label>
                <select id="3" name="nameroom" multiple="true" style="width: 60px;height: 40px;">
                
                </select>
            </fieldset>
            
            <fieldset>
            <button type="button" onclick="location.href='room.jsp';">Back</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" onclick="location.href='home.jsp';">Home</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button id="4" type="submit" disabled="true">Next</button>
            </fieldset>   
           </form>
        </div>
    </body>
</html>
