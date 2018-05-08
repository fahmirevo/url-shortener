package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE HTML>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\" />\n");
      out.write("    <title>Purl - Pens Url Shortener</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.2/css/bulma.min.css\" media=\"all\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            position: absolute;\n");
      out.write("            font-size: 1.1em;\n");
      out.write("            background-color: white;\n");
      out.write("            width: 100%;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        img {\n");
      out.write("            max-width: 100%;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-short {\n");
      out.write("            background: linear-gradient(-90deg, #FF2B7F 0%, rgba(250, 0, 147, 0.03) 0%), url('images/bg.png');\n");
      out.write("            background-size: cover;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .clm-t-pad {\n");
      out.write("            border-top: #FF2B7F 1px solid;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .clm-b-pad {\n");
      out.write("            border-top: #FF2B7F 1px solid;\n");
      out.write("            border-bottom: #FF2B7F 1px solid;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .clm-lr {\n");
      out.write("            border-left: #FF2B7F 1px solid;\n");
      out.write("            border-right: #FF2B7F 1px solid;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .icn {\n");
      out.write("            width: 64px;\n");
      out.write("            height: 64px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .frame-full {\n");
      out.write("            width: 100%;\n");
      out.write("            min-height: 100vh;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .box{\n");
      out.write("            padding: 40px 40px 40px 40px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <section class=\"section hero is-fullwidth is-fullheight form-short\">\n");
      out.write("        <div class=\"hero-head has-text-centered\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"hero-body\">\n");
      out.write("            <div class=\"container content has-text-centered\">\n");
      out.write("                <div class=\"columns is-12\">\n");
      out.write("                    <div class=\"column is-3\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"column is-6 box\">\n");
      out.write("                        <h1 class=\"title is-1 has-text-danger\">Purl - Pens Url Shortener</h1>\n");
      out.write("                        <form action=\"proses-short.jsp\" method=\"GET\">\n");
      out.write("                            <div class=\"columns\">\n");
      out.write("                                <div class=\"column is-12\">\n");
      out.write("                                    <input type=\"text\" class=\"input is-danger\" placeholder=\"Paste Url\" name=\"url\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"columns\">\n");
      out.write("                                <div class=\"column is-6\">\n");
      out.write("                                    <input type=\"text\" class=\"input is-danger\" placeholder=\"Custom (optional)\" name=\"custom\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"column is-6\">\n");
      out.write("                                    <input type=\"text\" class=\"input is-danger\" placeholder=\"Password (optional)\" name=\"password\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"submit\" class=\"button is-danger\" value=\"Shorten\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"column is-3\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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
