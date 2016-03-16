<%--
Author- Arghya Das
From- Indian School Of Ethical Hacking
    Used for selecting the number of rooms, including adjoining rooms and separate rooms.
--%>
<html>
    <head>
         <link rel="stylesheet" href="import.css" type="text/css">
                
        <style>
            body {
                background-image: url("room_sel.jpg");
                background-size: 100% auto;
                
            }
        </style>
        <script>
        function sep(chad){
            //Calculate number of separate rooms.
                var chsep = document.rooms.nsep;//number of seaparate rooms.
                var changer = document.rooms.room;//total number of rooms.
                //If number of rooms is lower than number of adjoining rooms.
                if((changer.value - chad.value)<0){
                    chsep.value = 0;
                }
                else
                    chsep.value = changer.value - chad.value;
            }    
        function maxchanger(nofr){
                //Calculates the value of maximum number of adjoining rooms.
                var change = document.rooms.adroom;//adjoining room
                var change2 = document.rooms.orientation;//radio input of adjoining rooms and separate rooms.
                //number of rooms less than 2, then no question of separate rooms.
                if(nofr.value<2){
                    change.max = 2;
                    change2[1].checked = false;
                    change2[0].checked = true;
                    change2[1].disabled = true;//disable separate radio button.
                    change2[0].disabled = false;
                    document.rooms.add.disabled= true;
                    sep(change);
                }
                else
                    if(nofr.value>5){//if rooms greater than 5 then they all cannot be adjoining.
                        change2[1].checked = true;
                        change2[1].disabled = false;
                        change2[0].checked = false;
                        change2[0].disabled = true;
                        document.rooms.add.disabled= false;
                        change.max = 5;
                        sep(change);
                    }
                    else{
                        
                        change2[1].disabled = false;
                        change2[0].disabled = false;
                        change.max = nofr.value;
                        sep(change);
                    }
                if(change.value>nofr.value){
                        change.value = change.max;
                        sep(change);
                    }
            }
            
        </script>
    </head>
    <body>
       
        <div class="container">
            <div class="style_1">
                <h1> SELECT NO OF ROOMS FOR BOOKING : </h1>
       
            <form action="orient.jsp" name="rooms" method="post">
            <label style="font-size: 30px;">Number of rooms </label>
            <p>
                <input style="height: 40px; font-size: 30px;" type="number" min="1" max="30" value="1" name="room" onchange="maxchanger(this);"/><br>
            </p>
            <input style="height: 30px; font-size: 30px;" type="radio" name="orientation" value="adjoining" checked="true" onclick="document.rooms.add.disabled= true"/>
            <label style="font-size: 30px;">Adjoining </label>&nbsp;&nbsp;&nbsp;
            <input style="height: 30px; font-size: 30px;" type="radio" name="orientation" value="separate" onclick="document.rooms.add.disabled= false" disabled="true"/>
            <label style="font-size: 30px;">Separate </label>
            <br>
            <fieldset name="add" disabled="true">
            <label style="font-size: 30px;">Number of Adjoining Rooms: </label>
            <input style="height: 40px; font-size: 30px;" type="number" min="2" max="5" value="2" name="adroom" onchange="sep(this);"/>
            &nbsp;&nbsp;&nbsp;<br><br><br>
            <label style="font-size: 30px;">Number of Separate Rooms: </label>
            <input style="height: 40px; font-size: 30px;" type="text" value="0" name = "nsep" readonly="true"/>     
            </fieldset>
            <br>          
                
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="button" onclick="location.href='home.jsp';">Back</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <button type="submit">Next</button>
            </form>
        </div> 
    </body>
</html>