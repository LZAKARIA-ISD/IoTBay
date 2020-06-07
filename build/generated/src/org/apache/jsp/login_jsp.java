package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import isd.wsd.Customer;
import isd.controller.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/ConnServlet", out, false);
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("        <title>IoTBay - Login</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

        
            Customer customer = (Customer)session.getAttribute("customer");
        
        
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"navigation\">\r\n");
      out.write("                <h3><a href=\"index.jsp\" class=\"logo-text\">IoTBay</a></h3>\r\n");
      out.write("                <div class=\"inner-nav\">\r\n");
      out.write("                    ");
 if(customer == null) { 
      out.write("\r\n");
      out.write("                    <a href=\"login.jsp\" role=\"button\" class=\"btn btn-light\" >Login</a>\r\n");
      out.write("                    <a href=\"register.jsp\" role=\"button\" class=\"btn btn-primary\">Register</a>\r\n");
      out.write("                    ");
 } else { 
      out.write("\r\n");
      out.write("                    <a href=\"main.jsp\" role=\"button\" class=\"btn btn-primary\">Main</a>\r\n");
      out.write("                    <a href=\"logout.jsp\" role=\"button\" class=\"btn btn-link\">Log out</a>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("                \r\n");
      out.write("            ");

                String existErr = (String) session.getAttribute("existErr");
                String emailErr = (String) session.getAttribute("emailErr");
                String passErr = (String) session.getAttribute("passErr");
            
      out.write("    \r\n");
      out.write("                \r\n");
      out.write("            <h1 class=\"display-3 text-center\">Login ");
      out.print((existErr != null ? existErr : ""));
      out.write(" </h1> \r\n");
      out.write("            <div class=\"register\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                      <form method=\"POST\" action=\"LoginServlet\">\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                          <label for=\"email\">Email address</label>\r\n");
      out.write("                          <input type=\"text\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"");
      out.print((emailErr != null ? emailErr : "Enter Email"));
      out.write("\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                          <label for=\"password\">Password</label>\r\n");
      out.write("                          <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" placeholder=\"");
      out.print((passErr != null ? passErr : "Enter Password"));
      out.write("\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                          <input type=\"hidden\" name=\"objtype\" value=\"login\" />\r\n");
      out.write("                          <div class=\"text-center\">\r\n");
      out.write("                              <button type=\"submit\" class=\"btn btn-primary \">Log in</button>\r\n");
      out.write("                          </div>\r\n");
      out.write("                      </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("</html>\r\n");
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
