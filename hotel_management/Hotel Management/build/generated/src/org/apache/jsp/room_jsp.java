package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class room_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                \n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-image: url(\"room_sel.jpg\");\n");
      out.write("                background-size: 100% auto;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("        function sep(chad){\n");
      out.write("            //Calculate number of separate rooms.\n");
      out.write("                var chsep = document.rooms.nsep;//number of seaparate rooms.\n");
      out.write("                var changer = document.rooms.room;//total number of rooms.\n");
      out.write("                //If number of rooms is lower than number of adjoining rooms.\n");
      out.write("                if((changer.value - chad.value)<0){\n");
      out.write("                    chsep.value = 0;\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                    chsep.value = changer.value - chad.value;\n");
      out.write("            }    \n");
      out.write("        function maxchanger(nofr){\n");
      out.write("                //Calculates the value of maximum number of adjoining rooms.\n");
      out.write("                var change = document.rooms.adroom;//adjoining room\n");
      out.write("                var change2 = document.rooms.orientation;//radio input of adjoining rooms and separate rooms.\n");
      out.write("                //number of rooms less than 2, then no question of separate rooms.\n");
      out.write("                if(nofr.value<2){\n");
      out.write("                    change.max = 2;\n");
      out.write("                    change2[1].checked = false;\n");
      out.write("                    change2[0].checked = true;\n");
      out.write("                    change2[1].disabled = true;//disable separate radio button.\n");
      out.write("                    change2[0].disabled = false;\n");
      out.write("                    document.rooms.add.disabled= true;\n");
      out.write("                    sep(change);\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                    if(nofr.value>5){//if rooms greater than 5 then they all cannot be adjoining.\n");
      out.write("                        change2[1].checked = true;\n");
      out.write("                        change2[1].disabled = false;\n");
      out.write("                        change2[0].checked = false;\n");
      out.write("                        change2[0].disabled = true;\n");
      out.write("                        document.rooms.add.disabled= false;\n");
      out.write("                        change.max = 5;\n");
      out.write("                        sep(change);\n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                        \n");
      out.write("                        change2[1].disabled = false;\n");
      out.write("                        change2[0].disabled = false;\n");
      out.write("                        change.max = nofr.value;\n");
      out.write("                        sep(change);\n");
      out.write("                    }\n");
      out.write("                if(change.value>nofr.value){\n");
      out.write("                        change.value = change.max;\n");
      out.write("                        sep(change);\n");
      out.write("                    }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <style>\n");
      out.write("              \n");
      out.write("                          .container {\n");
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
      out.write("  font-size: 35px;\n");
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
      out.write("        </style>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"room_sel\">\n");
      out.write("                <h1> SELECT NO OF ROOMS FOR BOOKING : </h1>\n");
      out.write("       \n");
      out.write("            <form action=\"orient.jsp\" name=\"rooms\" method=\"post\">\n");
      out.write("            <label style=\"font-size: 30px;\">Number of rooms </label>\n");
      out.write("            <p>\n");
      out.write("                <input style=\"height: 40px; font-size: 30px;\" type=\"number\" min=\"1\" max=\"30\" value=\"1\" name=\"room\" onchange=\"maxchanger(this);\"/><br>\n");
      out.write("            </p>\n");
      out.write("            <input style=\"height: 30px; font-size: 30px;\" type=\"radio\" name=\"orientation\" value=\"adjoining\" checked=\"true\" onclick=\"document.rooms.add.disabled= true\"/>\n");
      out.write("            <label style=\"font-size: 30px;\">Adjoining </label>&nbsp;&nbsp;&nbsp;\n");
      out.write("            <input style=\"height: 30px; font-size: 30px;\" type=\"radio\" name=\"orientation\" value=\"separate\" onclick=\"document.rooms.add.disabled= false\" disabled=\"true\"/>\n");
      out.write("            <label style=\"font-size: 30px;\">Separate </label>\n");
      out.write("            <br>\n");
      out.write("            <fieldset name=\"add\" disabled=\"true\">\n");
      out.write("            <label style=\"font-size: 30px;\">Number of Adjoining Rooms: </label>\n");
      out.write("            <input style=\"height: 40px; font-size: 30px;\" type=\"number\" min=\"2\" max=\"5\" value=\"2\" name=\"adroom\" onchange=\"sep(this);\"/>\n");
      out.write("            &nbsp;&nbsp;&nbsp;<br><br><br>\n");
      out.write("            <label style=\"font-size: 30px;\">Number of Separate Rooms: </label>\n");
      out.write("            <input style=\"height: 40px; font-size: 30px;\" type=\"text\" value=\"0\" name = \"nsep\" readonly=\"true\"/>     \n");
      out.write("            </fieldset>\n");
      out.write("            <br>          \n");
      out.write("                \n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <button type=\"button\" onclick=\"location.href='home.jsp';\">Back</button>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <button type=\"submit\">Next</button>\n");
      out.write("            </form>\n");
      out.write("        </div> \n");
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
