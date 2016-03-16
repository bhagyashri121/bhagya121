package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<home>\n");
      out.write("    <head>\n");
      out.write("    <title> home page</title>\n");
      out.write("    </head>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        body {\n");
      out.write("                background-image: url(\"index2.jpg\");\n");
      out.write("                background-size: 100% auto;\n");
      out.write("                \n");
      out.write("            }   \n");
      out.write("            \n");
      out.write("\n");
      out.write("        .menu,\n");
      out.write(".menu ul,\n");
      out.write(".menu li,\n");
      out.write(".menu a {\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    border: none;\n");
      out.write("    outline: none;\n");
      out.write("}\n");
      out.write(" \n");
      out.write(".menu {\n");
      out.write("    height: 40px;\n");
      out.write("    width: 505px;\n");
      out.write(" \n");
      out.write("    background: #4c4e5a;\n");
      out.write("    background: -webkit-linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);\n");
      out.write("    background: -moz-linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);\n");
      out.write("    background: -o-linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);\n");
      out.write("    background: -ms-linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);\n");
      out.write("    background: linear-gradient(top, #4c4e5a 0%,#2c2d33 100%);\n");
      out.write(" \n");
      out.write("    -webkit-border-radius: 5px;\n");
      out.write("    -moz-border-radius: 5px;\n");
      out.write("    border-radius: 5px;\n");
      out.write("}\n");
      out.write(" \n");
      out.write(".menu li {\n");
      out.write("    position: relative;\n");
      out.write("    list-style: none;\n");
      out.write("    float: left;\n");
      out.write("    display: block;\n");
      out.write("    height: 40px; }\n");
      out.write(".menu li a {\n");
      out.write("    display: block;\n");
      out.write("    padding: 0 14px;\n");
      out.write("    margin: 6px 0;\n");
      out.write("    line-height: 28px;\n");
      out.write("    text-decoration: none;\n");
      out.write(" \n");
      out.write("    border-left: 1px solid #393942;\n");
      out.write("    border-right: 1px solid #4f5058;\n");
      out.write(" \n");
      out.write("    font-family: Helvetica, Arial, sans-serif;\n");
      out.write("    font-weight: bold;\n");
      out.write("    font-size: 13px;\n");
      out.write(" \n");
      out.write("    color: #f3f3f3;\n");
      out.write("    text-shadow: 1px 1px 1px rgba(0,0,0,.6);\n");
      out.write(" \n");
      out.write("    -webkit-transition: color .2s ease-in-out;\n");
      out.write("    -moz-transition: color .2s ease-in-out;\n");
      out.write("    -o-transition: color .2s ease-in-out;\n");
      out.write("    -ms-transition: color .2s ease-in-out;\n");
      out.write("    transition: color .2s ease-in-out;\n");
      out.write("}\n");
      out.write(" \n");
      out.write(".menu li:first-child a { border-left: none; }\n");
      out.write(".menu li:last-child a{ border-right: none; }\n");
      out.write(" \n");
      out.write(".menu li:hover > a { color: #8fde62; }\n");
      out.write(".menu ul {\n");
      out.write("    position: absolute;\n");
      out.write("    top: 40px;\n");
      out.write("    left: 0;\n");
      out.write(" \n");
      out.write("    opacity: 0;\n");
      out.write("    background: #1f2024;\n");
      out.write(" \n");
      out.write("    -webkit-border-radius: 0 0 5px 5px;\n");
      out.write("    -moz-border-radius: 0 0 5px 5px;\n");
      out.write("    border-radius: 0 0 5px 5px;\n");
      out.write(" \n");
      out.write("    -webkit-transition: opacity .25s ease .1s;\n");
      out.write("    -moz-transition: opacity .25s ease .1s;\n");
      out.write("    -o-transition: opacity .25s ease .1s;\n");
      out.write("    -ms-transition: opacity .25s ease .1s;\n");
      out.write("    transition: opacity .25s ease .1s;\n");
      out.write("}\n");
      out.write(" \n");
      out.write(".menu li:hover > ul { opacity: 1; }\n");
      out.write(" \n");
      out.write(".menu ul li {\n");
      out.write("    height: 0;\n");
      out.write("    overflow: hidden;\n");
      out.write("    padding: 0;\n");
      out.write(" \n");
      out.write("    -webkit-transition: height .25s ease .1s;\n");
      out.write("    -moz-transition: height .25s ease .1s;\n");
      out.write("    -o-transition: height .25s ease .1s;\n");
      out.write("    -ms-transition: height .25s ease .1s;\n");
      out.write("    transition: height .25s ease .1s;\n");
      out.write("}\n");
      out.write(" \n");
      out.write(".menu li:hover > ul li {\n");
      out.write("       height: 36px;\n");
      out.write("    overflow: visible;\n");
      out.write("    padding: 0;\n");
      out.write("}\n");
      out.write(".menu ul li a {\n");
      out.write("    width: 100px;\n");
      out.write("    padding: 4px 0 4px 40px;\n");
      out.write("    margin: 0;\n");
      out.write(" \n");
      out.write("    border: none;\n");
      out.write("    border-bottom: 1px solid #353539;\n");
      out.write("}\n");
      out.write(" \n");
      out.write(".menu ul li:last-child a { border: none; }\n");
      out.write(".menu a.documents { background: url(../img/docs.png) no-repeat 6px center; }\n");
      out.write(".menu a.messages { background: url(../img/bubble.png) no-repeat 6px center; }\n");
      out.write(".menu a.signout { background: url(../img/arrow.png) no-repeat 6px center; }\n");
      out.write("\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write(" \n");
      out.write("        \n");
      out.write("<ul class=\"menu\">\n");
      out.write(" \n");
      out.write("    <li><a href=\"#\">Home</a></li>\n");
      out.write("    <li><a href=\"#\">Information</a>\n");
      out.write("    <ul>\n");
      out.write("            <li><a href=\"desc.html\" class=\"h_info\">Hotel </a></li>\n");
      out.write("            <li><a href=\"logini.jsp\" class=\"b_info\">Room Booking </a></li>\n");
      out.write("            \n");
      out.write("        </ul>\n");
      out.write("    </li>\n");
      out.write("    <li><a href=\"#\">Reservation</a>\n");
      out.write(" \n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"logina.jsp\" class=\"new\">New</a></li>\n");
      out.write("            <li><a href=\"logind.jsp\" class=\"checkout\">Checkout</a></li>\n");
      out.write("            \n");
      out.write("        </ul>\n");
      out.write(" \n");
      out.write("    </li>\n");
      out.write("    <li><a href=\"#\">Hotel Services</a>\n");
      out.write("     <ul>\n");
      out.write("         <li><a href=\"loginf.jsp\" class=\"new\">Food Court</a></li>\n");
      out.write("     </ul>\n");
      out.write("    </li>\n");
      out.write("    <li><a href=\"gallery1.html\" target=\"_blank\">Hotel gallery</a></li>\n");
      out.write(" \n");
      out.write("</ul>\n");
      out.write("    </body>\n");
      out.write("</home>");
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
