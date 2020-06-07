package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import isd.wsd.Customer;

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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" />\r\n");
      out.write("        <title>IoTBay - Home Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"index-body\">\r\n");
      out.write("        ");

            Customer customer = (Customer)session.getAttribute("customer");
        
      out.write("\r\n");
      out.write("        <div class=\"centre\">\r\n");
      out.write("            <div class=\"index-modal\">\r\n");
      out.write("                <h1 class=\"display-1\">IoTBay</h1>\r\n");
      out.write("                <p class=\"lead\">\r\n");
      out.write("                    The best place for all of your Internet of Things needs\r\n");
      out.write("                </p>\r\n");
      out.write("             \r\n");
      out.write("                <div class=\"p-2\">\r\n");
      out.write("                    ");
 if(customer == null) { 
      out.write("\r\n");
      out.write("                    <a href=\"register.jsp\" role=\"button\" class=\"btn btn-primary\">Register</a>\r\n");
      out.write("                    <a href=\"login.jsp\"  role=\"button\" class=\"btn btn-link\">Or Login</a>\r\n");
      out.write("                       \r\n");
      out.write("                    ");
 } else { 
      out.write("\r\n");
      out.write("                    <a href=\"main.jsp\" role=\"button\" class=\"btn btn-primary\">Continue as ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${customer.name != null ? customer.name : customer.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a>\r\n");
      out.write("                    <a href=\"logout.jsp\" role=\"button\" class=\"btn btn-link\">Log out</a>\r\n");
      out.write("                    ");
 } 
      out.write("\r\n");
      out.write("                    <hr>\r\n");
      out.write("                    \r\n");
      out.write("                    <h5><i>Quick links</i></h5>\r\n");
      out.write("                    <div>Products, orders, etc ??</div>                  \r\n");
      out.write("                    <a href=\"ProductCollectionServlet\">Products - Temp Link</a>\r\n");
      out.write("                    <hr>\r\n");
      out.write("                    <a href=\"staff/index.jsp\">Staff Site - Temp Link</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("                <div style=\"margin-top:-27px;\"><a style=\"background-color:rgba(0,0,0,0.3);color:#6c757d;text-decoration:none;padding:4px 6px;font-family:-apple-system, BlinkMacSystemFont, &quot;San Francisco&quot;, &quot;Helvetica Neue&quot;, Helvetica, Ubuntu, Roboto, Noto, &quot;Segoe UI&quot;, Arial, sans-serif;font-size:12px;font-weight:bold;line-height:1.2;display:inline-block;border-radius:3px\" href=\"https://unsplash.com/@markusspiske?utm_medium=referral&amp;utm_campaign=photographer-credit&amp;utm_content=creditBadge\" target=\"_blank\" rel=\"noopener noreferrer\" title=\"Download free do whatever you want high-resolution photos from Markus Spiske\"><span style=\"display:inline-block;padding:2px 3px\"><svg xmlns=\"http://www.w3.org/2000/svg\" style=\"height:12px;width:auto;position:relative;vertical-align:middle;top:-2px;fill:white\" viewBox=\"0 0 32 32\"><title>unsplash-logo</title><path d=\"M10 9V0h12v9H10zm12 5h10v18H0V14h10v9h12v-9z\"></path></svg></span><span style=\"display:inline-block;padding:2px 3px\">Markus Spiske</span></a></div>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/ConnServlet", out, true);
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/CustomerConnServlet", out, true);
      out.write("        \r\n");
      out.write("    </body>\r\n");
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
