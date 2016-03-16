<%--
Author- Arghya Das
From- Indian School Of Ethical Hacking
Used for displaying the receipt.
--%>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <style>
            body {
                background-image: url("room7.jpg");
                background-size: 100% auto;
            }
        </style>
        <script>
            function check(){
                <%
                    String hide = session.getAttribute("hide").toString();
                    String ename=session.getAttribute("ename").toString();
                    String gname=session.getAttribute("gname").toString();
                    String adate=session.getAttribute("adate").toString();
                    String d=session.getAttribute("d").toString();
                    String price=session.getAttribute("price").toString();
                    String vat=session.getAttribute("vat").toString();
                    String tp=session.getAttribute("tp").toString();
                %>
            }
            function recheck(){
                //Go back to select another room for departure.
                    var form = document.createElement("form");
                    form.setAttribute("method", "post");
                    form.setAttribute("action", "checkd");
                    document.body.appendChild(form);
                    form.submit();
            }
        </script>
    </head>
    <body onload="check();">
        <div style="background-color: FFFFCC; position: absolute;top: 10%;left: 30%">
            <fieldset>
                <legend>
                    Employee Information
                </legend> 
                <label style="font-size: 30px;">Name: <%=ename%></label>
                                           
            </fieldset>
            <br>
            <fieldset>
                <legend>
                    Guest Information
                </legend>
                <label style="font-size: 30px;">Name: <%=gname%></label>
                <br>
                <label style="font-size: 30px;">Room: <%=hide%></label>
                <br>
                <label style="font-size: 30px;">Arrival Date: <%=adate%></label>
                <br>
                <label style="font-size: 30px;">Departure Date: <%=d%></label>
                
            </fieldset>
            <br>
            <fieldset>
                <legend>
                    Accounting Information
                </legend>
                <label style="font-size: 30px;">Price: <i class="fa fa-inr"></i> <%=price%></label>
                <br>
                <label style="font-size: 30px;">VAT(@12.36%): <i class="fa fa-inr"></i> <%=vat%></label>
                <br>
                <label style="font-size: 30px;">Total Price: <i class="fa fa-inr"></i> <%=tp%></label>
            </fieldset>
            <br>
            <button type="button" onclick="recheck();">OK</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" onclick="window.print();">Print Receipt</button>
        </div>
    </body>
</html>
