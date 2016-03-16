<%--
Author- Supratim Ghosh
From- Indian School Of Ethical Hacking
Used for confirming the order.
--%>
<html>
    <head>
        <style>
            body {
                background-image: url("room7.jpg");
                background-size: 100% auto;
            }
        </style>

        <script>
            function check(){
                
                <%
                    String room = session.getAttribute("room").toString();
                    String cuisine = session.getAttribute("cuisine").toString();
                
                %>
            }
        </script>
    </head>
    <body onload="check();">
        <div style="background-color: bisque; position: absolute;top: 30%;left: 40%">
            <fieldset>
                
                <label style="font-size: 30px;">Room: <%=room%></label>
                <br>
                <label style="font-size: 30px;">Cuisine: <%=cuisine%></label>
                <br>
                <label style="font-size: 30px;">Order has been placed</label>
                
            </fieldset>
            <button type="button" onclick="location.href='food.jsp'">OK</button>
        </div>
    </body>
</html>
