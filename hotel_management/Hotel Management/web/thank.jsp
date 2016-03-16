<%--
Acknowledgement of reservation completion.
--%>
<html>
    <head>
        <style>
            body {
                background-image: url("room_sel_02.jpg");
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
        
    </head>
    <body>
        <h3>
           Enjoy your stay !
        </h3>
              
        <%
           String fname = session.getAttribute("fname").toString();
           String lname = session.getAttribute("lname").toString();
           String date = session.getAttribute("adate").toString();
           String time = session.getAttribute("atime").toString();
                               
        %>   
        <div style="background-color: FFFFCC; position: absolute;top: 30%;left: 40%;border-radius: 20px ">
            <fieldset>
                <label style="font-size: 30px;">Name: <%=fname%> <%=lname%> </label>
                <br>
                <label style="font-size: 30px;">Arrival Date/Time: <%=date%> <%=time%> </label>
                <br>
                <label style="font-size: 30px;">Reservation is Complete. </label>
                <br>
                <button type="button" onclick="location.href='home.jsp'">OK</button>
            </fieldset>
        </div>
    </body>
</html>