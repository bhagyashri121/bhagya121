package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class form_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("       <script>\n");
      out.write("            function fill(){\n");
      out.write("                //ID 3 represents <select> tag.\n");
      out.write("                //Fill data already available into the form, like rooms selected,arrival date and time.\n");
      out.write("                var sel = document.getElementById(\"3\");\n");
      out.write("                    ");

                        String adroom = request.getParameter("addroom");
                        String sroom = request.getParameter("sroom");
                        String nameroom[] = request.getParameterValues("nameroom");
                    
      out.write("\n");
      out.write("                   var js = new Array();  \n");
      out.write("                    ");
  
                    for (int i=0; i < nameroom.length; i++) {  
                    
      out.write("  \n");
      out.write("                    js[");
      out.print( i );
      out.write("] = '");
      out.print(nameroom[i] );
      out.write("'; \n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                    \n");
      out.write("                    var j;\n");
      out.write("                    for(j=0;j<js.length;++j){\n");
      out.write("                        var nop = document.createElement('option');\n");
      out.write("                        nop.selected = true;\n");
      out.write("                        nop.text = js[j];\n");
      out.write("                        nop.value = js[j];\n");
      out.write("                        sel.appendChild(nop);\n");
      out.write("                    }\n");
      out.write("                    \n");
      out.write("                    var noar = document.forms.adroom;\n");
      out.write("                    var nosr = document.forms.sroom;\n");
      out.write("                    var adate = document.forms.adate;\n");
      out.write("                    var atime = document.forms.atime;\n");
      out.write("                    noar.value = ");
      out.print(adroom);
      out.write(";\n");
      out.write("                    nosr.value = ");
      out.print(sroom);
      out.write(";\n");
      out.write("                    var curr = new Date();\n");
      out.write("                    var day =curr.getDate();\n");
      out.write("                    day = day<10?'0'+day:day;\n");
      out.write("                    var month =(curr.getMonth()+1);\n");
      out.write("                    month = month<10?'0'+month:month;\n");
      out.write("                    var date = day+\"/\"+month+\"/\"+curr.getFullYear();\n");
      out.write("                    var hour = curr.getHours();\n");
      out.write("                    hour = hour<10?'0'+hour:hour;\n");
      out.write("                    var minute = curr.getMinutes();\n");
      out.write("                    minute = minute<10?'0'+minute:minute;\n");
      out.write("                    var sec = curr.getSeconds();\n");
      out.write("                    sec = sec<10?'0'+sec:sec;\n");
      out.write("                    var time = hour+\":\"+minute+\":\"+sec;\n");
      out.write("                    adate.value=date;\n");
      out.write("                    atime.value=time;\n");
      out.write("            }\n");
      out.write("        </script> \n");
      out.write("        <style>\n");
      out.write("            h3 {\n");
      out.write("                margin-top: 10px;\n");
      out.write("    margin-bottom: 100px;\n");
      out.write("    margin-right: 700px;\n");
      out.write("    margin-left: 50px;\n");
      out.write("               position:relative;\n");
      out.write("               top:10px;\n");
      out.write("              left:20px;\n");
      out.write("              font-size: 20px;\n");
      out.write("              font-style: italic;\n");
      out.write("              color: black;\n");
      out.write("              background-color: yellow;\n");
      out.write("              border-radius: 20px;\n");
      out.write("               \n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            body {\n");
      out.write("                background-image: url(\"luxury-hotel-rooms-pamilla-cape-town.jpg\");\n");
      out.write("                background-size: 100% auto;\n");
      out.write("            }\n");
      out.write("          \n");
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
      out.write("  top: 10px;\n");
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
      out.write("  font-size: 35px;\n");
      out.write("  font-weight: bold;\n");
      out.write("  color: #8fde62;\n");
      out.write("  text-align: center;\n");
      out.write("  text-shadow: 0 1px white;\n");
      out.write("  background:  #4c4e5a;\n");
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
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body onload=\"fill();\">\n");
      out.write("        <h3>\n");
      out.write("            Please fill out this form to complete your booking details :-  \n");
      out.write("        </h3>\n");
      out.write("        <div class=\"container\">\n");
      out.write("         <div class=\"room_sel\">\n");
      out.write("        \n");
      out.write("        <h1> Reservation Form :: </h1>\n");
      out.write("            <form name=\"forms \" action=\"thank.jsp\" method=\"post\">\n");
      out.write("                <fieldset>\n");
      out.write("                <label style=\"font-size: 25px;\">First Name </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"fname\" required=\"true\"/><br>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <label style=\"font-size: 25px;\">Middle Name </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"mname\"/><br>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <label style=\"font-size: 25px;\">Last Name </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"lname\" required=\"true\"/>\n");
      out.write("                <br>\n");
      out.write("                <label style=\"font-size: 25px;\">Address </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"address\" required=\"true\"/>\n");
      out.write("                <br>\n");
      out.write("                <label style=\"font-size: 25px;\">Contact Number </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"contact\" required=\"true\"/>\n");
      out.write("                </fieldset>\n");
      out.write("                <br>\n");
      out.write("                <fieldset>\n");
      out.write("                    <label style=\"font-size: 25px;\">Number of Adjoining Rooms: </label>\n");
      out.write("                    <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"adroom\" readonly=\"true\"/><br>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <label style=\"font-size: 25px;\">Number of Separate Rooms: </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"sroom\" readonly=\"true\"/>\n");
      out.write("                </fieldset>\n");
      out.write("                <br>\n");
      out.write("                <fieldset>\n");
      out.write("                <label style=\"font-size: 25px;\">Arrival Date: </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"adate\" readonly=\"true\"/><br>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <label style=\"font-size: 25px;\">Arrival Time: </label>\n");
      out.write("                <input style=\"height: 25px; font-size: 20px;\" type=\"text\" name = \"atime\" readonly=\"true\"/>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <label style=\"font-size: 25px;\">Rooms : </label>\n");
      out.write("                <select id=\"3\" name=\"nameroom\" multiple=\"true\" style=\"width: 60px;height: 40px;\">\n");
      out.write("                \n");
      out.write("                </select>\n");
      out.write("                </fieldset>\n");
      out.write("                <br>\n");
      out.write("                <button type=\"button\" onclick=\"location.href='room.jsp';\">Back</button>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <button type=\"submit\">Next</button>\n");
      out.write("            </form>\n");
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
