package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import isd.wsd.Product;
import java.text.DecimalFormat;
import java.util.ArrayList;

public final class productCollection_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Product Collection</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");

            ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("products");
            String error = (String)session.getAttribute("productsErr");
            DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
            String productSearch = (String)session.getAttribute("productSearch");
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"navigation\">\r\n");
      out.write("                <h3><a href=\"index.jsp\" class=\"logo-text\">IoTBay</a></h3>\r\n");
      out.write("                <div class=\"inner-nav\">\r\n");
      out.write("                    <a href=\"ProductCollectionServlet\" class=\"btn btn-outline-primary mr-2\">Products</a>\r\n");
      out.write("                    <!--Nav needs to be updated-->          \r\n");
      out.write("                    <a href=\"main.jsp\" role=\"button\" class=\"btn btn-primary\">Main</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        <h1 class=\"text-center display-3 my-2\">Products</h1>\r\n");
      out.write("        <div class=\"flex-row d-flex justify-content-center mb-4\">   \r\n");
      out.write("            <a class=\"btn btn-outline-primary mr-sm-2\" href=\"addProduct.jsp\">Add Product</a>\r\n");
      out.write("            <a class=\"btn btn-outline-primary mr-sm-5\" href=\"ProductCollectionServlet\">List All Products</a>\r\n");
      out.write("            <form class=\"form-inline my-4 my-lg-0\" method=\"get\" action=\"SearchProductsServlet\">\r\n");
      out.write("                <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search Products\" aria-label=\"Search\" name=\"productSearch\">\r\n");
      out.write("                <button class=\"btn btn-outline-primary my-2 my-sm-0\" type=\"submit\">Search</button>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <p class=\"text-center my-2\">");
      out.print( (productSearch != null ? "Results for '" + productSearch + "'" : "") );
      out.write("</p>\r\n");
      out.write("        <p class=\"text-center my-2\">");
      out.print( (products.isEmpty() ? "No available products" : "") );
      out.write("</p>\r\n");
      out.write("       \r\n");
      out.write("        <div class=\"row text-center\">   \r\n");
      out.write("        ");
 for (Product product: products){ 
      out.write("\r\n");
      out.write("            <div class=\"col-lg-4 col-sm-6 mb-4\"> \r\n");
      out.write("                <div class=\"card h-100 box-shadow\">\r\n");
      out.write("                    <h6 class=\"card-header text-muted\">");
      out.print( product.getType() );
      out.write("</h6>\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <h5 class=\"card-title\">");
      out.print( product.getName() );
      out.write("</h5>\r\n");
      out.write("                        <h6 class=\"card-subtitle text-muted\">ID: ");
      out.print( product.getId() );
      out.write("</h6>\r\n");
      out.write("                        <p class=\"card-text\">");
      out.print( product.getDetail() );
      out.write("</p>\r\n");
      out.write("                        <p class=\"card-text\">Price: ");
      out.print( priceFormatter.format(product.getPrice()));
      out.write("</p>\r\n");
      out.write("                        <p class=\"card-text\">Quantity: ");
      out.print( product.getQuantity() );
      out.write("</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"card-footer\">\r\n");
      out.write("                        <a class=\"btn btn-outline-primary\" href=\"DeleteProductServlet?id=");
      out.print( product.getId());
      out.write("\">Delete</a>\r\n");
      out.write("                        <a class=\"btn btn-outline-primary\" href=\"EditProductServlet?id=");
      out.print( product.getId());
      out.write("\">Edit</a>\r\n");
      out.write("                        ");
 if (product.getQuantity() > 0) {
      out.write("    \r\n");
      out.write("                        <a class=\"btn btn-outline-primary\" href=\"ProductServlet?id=");
      out.print( product.getId());
      out.write("\">Order</a>\r\n");
      out.write("                        ");
 } else { 
      out.write("\r\n");
      out.write("                        Out of Stock\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    </div>      \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>        \r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("                    \r\n");
      out.write("                    \r\n");
      out.write("    \r\n");
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
