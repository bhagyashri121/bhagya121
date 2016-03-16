<%--
Author- Arghya Das
From- Indian School Of Ethical Hacking
This is used to fill up the guest information.
--%>
<html>
    <head>
        <script>
            function fill(){
                //ID 3 represents <select> tag.
                //Fill data already available into the form, like rooms selected,arrival date and time.
                var sel = document.getElementById("3");
                    <%
                        String adroom = request.getParameter("addroom");
                        String sroom = request.getParameter("sroom");
                        String nameroom[] = request.getParameterValues("nameroom");
                    %>
                   var js = new Array();  
                    <%  
                    for (int i=0; i < nameroom.length; i++) {  
                    %>  
                    js[<%= i %>] = '<%=nameroom[i] %>'; 
                    <%}%>
                    
                    var j;
                    for(j=0;j<js.length;++j){
                        var nop = document.createElement('option');
                        nop.selected = true;
                        nop.text = js[j];
                        nop.value = js[j];
                        sel.appendChild(nop);
                    }
                    
                    var noar = document.forms.adroom;
                    var nosr = document.forms.sroom;
                    var adate = document.forms.adate;
                    var atime = document.forms.atime;
                    noar.value = <%=adroom%>;
                    nosr.value = <%=sroom%>;
                    var curr = new Date();
                    var day =curr.getDate();
                    day = day<10?'0'+day:day;
                    var month =(curr.getMonth()+1);
                    month = month<10?'0'+month:month;
                    var date = day+"/"+month+"/"+curr.getFullYear();
                    var hour = curr.getHours();
                    hour = hour<10?'0'+hour:hour;
                    var minute = curr.getMinutes();
                    minute = minute<10?'0'+minute:minute;
                    var sec = curr.getSeconds();
                    sec = sec<10?'0'+sec:sec;
                    var time = hour+":"+minute+":"+sec;
                    adate.value=date;
                    atime.value=time;
            }
        </script>
        <link rel="stylesheet" href="import.css" type="text/css">
        <style>
            body {
                background-image: url("room5.jpg");
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
    <body onload="fill();">
        <h3>
            Please fill out this form to complete your booking details :-  
        </h3>
        <div class="container">
         <div class="style_1">
        
        <h1> Reservation Form :: </h1>
        
        
            <form name="forms" action="thank1" method="post">
                <fieldset>
                <label style="font-size: 25px;">First Name </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "fname" required="true"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 25px;">Middle Name </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "mname"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 25px;">Last Name </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "lname" required="true"/>
                <br>
                <label style="font-size: 25px;">Address </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "address" required="true"/>
                <br>
                <label style="font-size: 25px;">Contact Number </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "contact" required="true"/>
                </fieldset>
                <br>
                <fieldset>
                <label style="font-size: 25px;">Number of Adjoining Rooms: </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "adroom" readonly="true"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 25px;">Number of Separate Rooms: </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "sroom" readonly="true"/>
                </fieldset>
                <br>
                <fieldset>
                <label style="font-size: 25px;">Arrival Date: </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "adate" readonly="true"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 25px;">Arrival Time: </label>
                <input style="height: 25px; font-size: 20px;" type="text" name = "atime" readonly="true"/>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <label style="font-size: 25px;">Rooms : </label>
                <select id="3" name="nameroom" multiple="true" style="width: 60px;height: 40px;">
                
                </select>
                </fieldset>
                <br>
                <button type="button" onclick="location.href='room.jsp';">Back</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit">Next</button>
            </form>
        </div>
    </body>
</html>
