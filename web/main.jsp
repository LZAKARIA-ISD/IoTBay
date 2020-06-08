<%-- 
    Document   : index
    Created on : 29/04/2020, 2:05:37 PM
    Author     : lucas
--%>

<%@page import="isd.wsd.Customer"%>
<%@page import="isd.wsd.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/ConnServlet"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
       <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css" />
        <title>IoTBay - Main Page</title>
    </head>
    <body>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
            Staff staff = (Staff)session.getAttribute("staff");
        %>
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <a href="ProductCollectionServlet" class="btn btn-outline-primary mr-2">Products</a>
                    <% if(customer == null && staff == null) { %>
                    <a href="login.jsp" role="button" class="btn btn-light" >Login</a>
                    <a href="register.jsp" role="button" class="btn btn-primary">Register</a>
                    <% } else { %>
                    <a href="main.jsp" role="button" class="btn btn-primary">Main</a>
                    <a href="FetchLogsServlet" role="button" class="btn btn-link">Account</a>
                    <a href="LogoutServlet" role="button" class="btn btn-link">Log out</a>
                    <% } %>
                </div>
            </div>
            <div class="text-center">
                <h1 class="display-3">IoTBay Featured Products</h1>
                
                <p><em>Products coming soon...</em></p>

            </div>
            
            
            
        </div>
</html>
