package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class orient_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-image: url(\"luxury-hotel-rooms-pamilla-cape-town.jpg\");\n");
      out.write("                background-size: 100% auto;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            ");
 String room = request.getParameter("room");
            String adroom = request.getParameter("adroom");
            String seproom = request.getParameter("nsep");
      out.write("\n");
      out.write("            function check(){\n");
      out.write("                /*\n");
      out.write("                 Checks the availability of a room. If a room is available then shown as green. Else red.\n");
      out.write("                 ID 1 represents number of adjoining rooms field.\n");
      out.write("                 ID 2 represents number of separate rooms field.\n");
      out.write("                 */\n");
      out.write("                \n");
      out.write("                var r = ");
      out.print(room);
      out.write(";\n");
      out.write("                var ad = ");
      out.print(adroom);
      out.write(";\n");
      out.write("                \n");
      out.write("                var ns = ");
      out.print(seproom);
      out.write(";\n");
      out.write("                \n");
      out.write("                var cad = document.getElementById(\"1\");\n");
      out.write("                var ser = document.getElementById(\"2\");\n");
      out.write("                //If number of adjoining rooms not sent, then all should be adjoined.\n");
      out.write("                if(ad){\n");
      out.write("                    \n");
      out.write("                    cad.value = ad;\n");
      out.write("                    ser.value = ns;\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    \n");
      out.write("                    cad.value = r;\n");
      out.write("                    ser.value = 0;\n");
      out.write("                    \n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                var chsep = document.getElementsByName(\"room\");\n");
      out.write("                ");

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
                   
      out.write("\n");
      out.write("                           if('");
      out.print(value);
      out.write("'==='F'){\n");
      out.write("                               chsep[");
      out.print(k);
      out.write("].style.backgroundColor = 'rgb(0, 255, 0)';\n");
      out.write("                               \n");
      out.write("                            }\n");
      out.write("                            else{\n");
      out.write("                               chsep[");
      out.print(k);
      out.write("].style.backgroundColor = 'rgb(255, 0, 0)';\n");
      out.write("                               chsep[");
      out.print(k);
      out.write("].disabled=\"true\";\n");
      out.write("                            }\n");
      out.write("                   ");

                           }
                           ++k; 
                        }
                     }
                     rs.close();
                     stmt.close();
                     conn.close();
                
      out.write("\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            function append(but){\n");
      out.write("                //Append the room to the <select> tag.\n");
      out.write("                var sel = document.getElementById(\"3\");\n");
      out.write("                var dis = document.getElementById(\"4\");\n");
      out.write("                ");

                     int i=Integer.parseInt(room);
                
      out.write("\n");
      out.write("                var len = ");
      out.print(room);
      out.write(";\n");
      out.write("                if(but.style.backgroundColor===\"rgb(255, 255, 255)\"){\n");
      out.write("                    but.style.backgroundColor='rgb(0, 255, 0)';\n");
      out.write("                    var options = document.getElementsByTagName(\"option\");\n");
      out.write("                    for(var x=0;x<options.length;++x){\n");
      out.write("                        if(options[x].value===but.id){\n");
      out.write("                            sel.remove(x);\n");
      out.write("                            break;\n");
      out.write("                        }    \n");
      out.write("                    }\n");
      out.write("                    if(sel.length<len){\n");
      out.write("                        dis.disabled=true;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    if(sel.length===len){\n");
      out.write("                    alert(\"Exceeding Limit!\");\n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                        but.style.backgroundColor='rgb(255, 255, 255)';\n");
      out.write("                        var nop = document.createElement('option');\n");
      out.write("                        nop.selected = true;\n");
      out.write("                        nop.text = but.id;\n");
      out.write("                        nop.value = but.id;\n");
      out.write("                        sel.appendChild(nop);\n");
      out.write("                        if(sel.length===len){\n");
      out.write("                            dis.disabled = false;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script> --%>\n");
      out.write("        <style>\n");
      out.write("           .container {\n");
      out.write("  margin: 50px auto;\n");
      out.write("  width: 1000px;\n");
      out.write("  height: 100px;\n");
      out.write("                          }\n");
      out.write("               \n");
      out.write("                          input[type=submit]:active {\n");
      out.write("  background: #cde5ef;\n");
      out.write("  border-color: #9eb9c2 #b3c0c8 #b4ccce;\n");
      out.write("  -webkit-box-shadow: inset 0 0 3px rgba(0, 0, 0, 0.2);\n");
      out.write("  box-shadow: inset 0 0 3px rgba(0, 255, 0, 0.2);\n");
      out.write("}\n");
      out.write("                          \n");
      out.write("    .room_sel input[type=text], .room_sel input[type=number] {\n");
      out.write("  width: 378px;\n");
      out.write("  height: 30px;\n");
      out.write("}\n");
      out.write(".room_sel {\n");
      out.write("  position: relative;\n");
      out.write("  margin: 0 auto;\n");
      out.write("  padding: 20px 20px 20px;\n");
      out.write("  width: 1000px;\n");
      out.write("  top: 50px;\n");
      out.write("  left: 30px\n");
      out.write("}\n");
      out.write("\n");
      out.write(" \n");
      out.write("   .room_sel:before {\n");
      out.write("  content: '';\n");
      out.write("  position: absolute;\n");
      out.write("  top: -8px;\n");
      out.write("  right: -8px;\n");
      out.write("  bottom: -8px;\n");
      out.write("  left: -8px;\n");
      out.write("  z-index: -1;\n");
      out.write("  background: FFFFCC;\n");
      out.write("  border-radius: 50px;\n");
      out.write("}\n");
      out.write(".room_sel h1 {\n");
      out.write("  margin: -20px -20px 21px;\n");
      out.write("  line-height: 50px;\n");
      out.write("  line-width : 200px\n");
      out.write("  font-size : 35px;\n");
      out.write("  font-weight: bold;\n");
      out.write("  color:#8fde62;\n");
      out.write("  text-align: center;\n");
      out.write("  text-shadow: 0 1px white;\n");
      out.write("  background: #4c4e5a;\n");
      out.write("  border-bottom: 1px solid #cfcfcf;\n");
      out.write("  border-radius: 50px;\n");
      out.write("  background-image: -webkit-linear-gradient(top, whiteffd, #eef2f5);\n");
      out.write("  background-image: -moz-linear-gradient(top, whiteffd, #eef2f5);\n");
      out.write("  background-image: -o-linear-gradient(top, whiteffd, #eef2f5);\n");
      out.write("  background-image: linear-gradient(to bottom, whiteffd, #eef2f5);\n");
      out.write("  -webkit-box-shadow: 0 1px whitesmoke;\n");
      out.write("  box-shadow: 0 1px whitesmoke;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"check();\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("         <div class=\"room_sel\">\n");
      out.write("             <h1> Orientation of rooms :: </h1>\n");
      out.write("         \n");
      out.write("            <fieldset>\n");
      out.write("            <button type=\"button\" id=\"101\" name=\"room\" onclick=\"append(this);\">101</button>\n");
      out.write("            <button type=\"button\" id=\"102\" name=\"room\" onclick=\"append(this);\">102</button>\n");
      out.write("            <button type=\"button\" id=\"103\" name=\"room\" onclick=\"append(this);\">103</button>\n");
      out.write("            <button type=\"button\" id=\"104\" name=\"room\" onclick=\"append(this);\">104</button>\n");
      out.write("            <button type=\"button\" id=\"105\" name=\"room\" onclick=\"append(this);\">105</button>\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <button type=\"button\" id=\"106\" name=\"room\" onclick=\"append(this);\">106</button>\n");
      out.write("            <button type=\"button\" id=\"107\" name=\"room\" onclick=\"append(this);\">107</button>\n");
      out.write("            <button type=\"button\" id=\"108\" name=\"room\" onclick=\"append(this);\">108</button>\n");
      out.write("            <button type=\"button\" id=\"109\" name=\"room\" onclick=\"append(this);\">109</button>\n");
      out.write("            <button type=\"button\" id=\"110\" name=\"room\" onclick=\"append(this);\">110</button>\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <button type=\"button\" id=\"201\" name=\"room\" onclick=\"append(this);\">201</button>\n");
      out.write("            <button type=\"button\" id=\"202\" name=\"room\" onclick=\"append(this);\">202</button>\n");
      out.write("            <button type=\"button\" id=\"203\" name=\"room\" onclick=\"append(this);\">203</button>\n");
      out.write("            <button type=\"button\" id=\"204\" name=\"room\" onclick=\"append(this);\">204</button>\n");
      out.write("            <button type=\"button\" id=\"205\" name=\"room\" onclick=\"append(this);\">205</button>\n");
      out.write("            <br><br><br><br><br><br><br><br><br><br><br><br>\n");
      out.write("            <button type=\"button\" id=\"206\" name=\"room\" onclick=\"append(this);\">206</button>\n");
      out.write("            <button type=\"button\" id=\"207\" name=\"room\" onclick=\"append(this);\">207</button>\n");
      out.write("            <button type=\"button\" id=\"208\" name=\"room\" onclick=\"append(this);\">208</button>\n");
      out.write("            <button type=\"button\" id=\"209\" name=\"room\" onclick=\"append(this);\">209</button>\n");
      out.write("            <button type=\"button\" id=\"210\" name=\"room\" onclick=\"append(this);\">210</button>\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <button type=\"button\" id=\"301\" name=\"room\" onclick=\"append(this);\">301</button>\n");
      out.write("            <button type=\"button\" id=\"302\" name=\"room\" onclick=\"append(this);\">302</button>\n");
      out.write("            <button type=\"button\" id=\"303\" name=\"room\" onclick=\"append(this);\">303</button>\n");
      out.write("            <button type=\"button\" id=\"304\" name=\"room\" onclick=\"append(this);\">304</button>\n");
      out.write("            <button type=\"button\" id=\"305\" name=\"room\" onclick=\"append(this);\">305</button>\n");
      out.write("            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("            <button type=\"button\" id=\"306\" name=\"room\" onclick=\"append(this);\">306</button>\n");
      out.write("            <button type=\"button\" id=\"307\" name=\"room\" onclick=\"append(this);\">307</button>\n");
      out.write("            <button type=\"button\" id=\"308\" name=\"room\" onclick=\"append(this);\">308</button>\n");
      out.write("            <button type=\"button\" id=\"309\" name=\"room\" onclick=\"append(this);\">309</button>\n");
      out.write("            <button type=\"button\" id=\"310\" name=\"room\" onclick=\"append(this);\">310</button>\n");
      out.write("            </fieldset>\n");
      out.write("            <br>\n");
      out.write("            <form action=\"form.jsp\" method=\"get\">\n");
      out.write("            <fieldset>\n");
      out.write("                <label style=\"font-size: 25px;\">Number of Adjoining Rooms: </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" id=\"1\" name = \"addroom\" readonly=\"true\"/>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>\n");
      out.write("                <label style=\"font-size: 25px;\">Number of Separate Rooms: </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" id=\"2\" name = \"sroom\" readonly=\"true\"/>\n");
      out.write("                <br>\n");
      out.write("                <label style=\"font-size: 25px;\">Selected Rooms : </label>\n");
      out.write("                <select id=\"3\" name=\"nameroom\" multiple=\"true\" style=\"width: 60px;height: 40px;\">\n");
      out.write("                \n");
      out.write("                </select>\n");
      out.write("            </fieldset>\n");
      out.write("            \n");
      out.write("            <fieldset>\n");
      out.write("            <button type=\"button\" onclick=\"location.href='room.jsp';\">Back</button>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <button type=\"button\" onclick=\"location.href='home.jsp';\">Home</button>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <button id=\"4\" type=\"submit\" disabled=\"true\">Next</button>\n");
      out.write("            </fieldset>   \n");
      out.write("           </form>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
