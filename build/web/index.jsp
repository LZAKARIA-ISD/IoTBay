<%-- 
    Document   : index
    Created on : 29/04/2020, 2:05:37 PM
    Author     : lucas
--%>
<%@page import="isd.wsd.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css" />
        <title>IoTBay - Home Page</title>
    </head>
    <body class="index-body">
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        <div class="centre">
            <div class="index-modal">
                <h1 class="display-1">IoTBay</h1>
                <p class="lead">
                    The best place for all of your Internet of Things needs
                </p>
             
                <div class="p-2">
                    <% if(customer == null) { %>
                    <a href="register.jsp" role="button" class="btn btn-primary">Register</a>
                    <a href="login.jsp"  role="button" class="btn btn-link">Or Login</a>
                       
                    <% } else { %>
                    <a href="main.jsp" role="button" class="btn btn-primary">Continue as ${customer.name != null ? customer.name : customer.email}</a>
                    <a href="logout.jsp" role="button" class="btn btn-link">Log out</a>
                    <% } %>
                    <hr>
                    
                    <h5><i>Quick links</i></h5>
                    <div>Products, orders, etc ??</div>                  
                    <a href="ProductCollectionServlet">Products - Temp Link</a>
                </div>
            </div>
        </div>
                <div style="margin-top:-27px;"><a style="background-color:rgba(0,0,0,0.3);color:#6c757d;text-decoration:none;padding:4px 6px;font-family:-apple-system, BlinkMacSystemFont, &quot;San Francisco&quot;, &quot;Helvetica Neue&quot;, Helvetica, Ubuntu, Roboto, Noto, &quot;Segoe UI&quot;, Arial, sans-serif;font-size:12px;font-weight:bold;line-height:1.2;display:inline-block;border-radius:3px" href="https://unsplash.com/@markusspiske?utm_medium=referral&amp;utm_campaign=photographer-credit&amp;utm_content=creditBadge" target="_blank" rel="noopener noreferrer" title="Download free do whatever you want high-resolution photos from Markus Spiske"><span style="display:inline-block;padding:2px 3px"><svg xmlns="http://www.w3.org/2000/svg" style="height:12px;width:auto;position:relative;vertical-align:middle;top:-2px;fill:white" viewBox="0 0 32 32"><title>unsplash-logo</title><path d="M10 9V0h12v9H10zm12 5h10v18H0V14h10v9h12v-9z"></path></svg></span><span style="display:inline-block;padding:2px 3px">Markus Spiske</span></a></div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
