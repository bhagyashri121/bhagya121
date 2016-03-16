<html>
    <head><title> login page</title> </head>
    <style>
        .container {
  margin: 50px auto;
  width: 640px;
  
}
 body {
                background-image: url("dream calcutta.jpg");
                background-size: 100% auto;
            }
.login:before {
  content: '';
  position: absolute;
  top: -8px;
  right: -8px;
  bottom: -8px;
  left: -8px;
  z-index: -1;
  background: FFFFCC;
  border-radius: 4px;
}

 
input[type=submit]:active {
  background: #cde5ef;
  border-color: #9eb9c2 #b3c0c8 #b4ccce;
  -webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);
  box-shadow: inset 0 0 3px rgba(, 0, 0, 0.2);
}

.login h1 {
  margin: -20px -20px 21px;
  line-height: 40px;
  font-size: 25px;
  font-weight: bold;
  color: #8fde62;
  text-align: center;
  text-shadow: 0 1px white;
  background: #4c4e5a;
  border-bottom: 1px solid #cfcfcf;
  border-radius: 3px 3px 0 0;
  background-image: -webkit-linear-gradient(top, whiteffd, #eef2f5);
  background-image: -moz-linear-gradient(top, whiteffd, #eef2f5);
  background-image: -o-linear-gradient(top, whiteffd, #eef2f5);
  background-image: linear-gradient(to bottom, whiteffd, #eef2f5);
  -webkit-box-shadow: 0 1px whitesmoke;
  box-shadow: 0 1px whitesmoke;
}
.login input[type=text], .login input[type=password] {
  width: 278px;
  height: 30px;
}
.login p {
  margin: 40px 0 0;
}
 
.login {
  position: relative;
  margin: 0 auto;
  padding: 20px 20px 20px;
  width: 310px;
  top: 50px;
  left: 30px
}
    </style>
    <body>
<div class="container">
<div class="login">
    <h1>Admin Login ::</h1>
    
    <form method="post" action="checka">
      <p><input type="text" name="login" placeholder="Username"></p>
      <p><input type="password" name="pass" placeholder="Password"></p>
      
     <p class="submit">
         <input type="submit" name="commit" value="Login">
     </p>
    </form>
  </div>
    <body>
</html>