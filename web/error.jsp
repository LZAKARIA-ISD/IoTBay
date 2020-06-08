<%-- 
    Document   : index
    Created on : 29/04/2020, 2:05:37 PM
    Author     : lucas

    currently still welcome page
--%>
<%@page import="isd.wsd.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css" />
        <title>IoTBay - Welcome Page</title>
    </head>
    <body>
        
        <%  
            String error = request.getParameter("error");
            String returnURL = request.getParameter("returnURL");
            
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <% if(customer == null) { %>
                    <a href="login.jsp" role="button" class="btn btn-light" >Login</a>
                    <a href="register.jsp" role="button" class="btn btn-primary">Register</a>
                    <% } else { %>
                    <a href="main.jsp" role="button" class="btn btn-primary">Main</a>
                    <a href="LogoutServlet" role="button" class="btn btn-link">Log out</a>
                    <% } %>
                </div>
            </div>
            <div class="text-center">
            
                <h1 class="display-3">Something went wrong</h1>
                <p class="lead">
                    ERROR MESSAGE
                </p>
                <a href="${returnURL}" role="button" class="btn btn-primary btn-lg mt-2">Return</a>

            </div>
        </div>
                  
   
                    
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <a href="login.jsp" role="button" class="btn btn-light" >Login</a>
                    <a href="register.jsp" role="button" class="btn btn-primary">Register</a>
                </div>
            </div>
            <div class="text-center">
                <% if(objtype != null && objtype.equals("register")) { %>
                <h1 class="display-3">Failed to register...</h1>
                <p class="lead">
                    You need to accept the terms and conditions in order to be able to make an account
                    <% } else { %>
                <h1 class="display-3">Something went wrong...</h1>
                <p class="lead">
                    Something went wrong
                <% } %>
                    <br>
                    Click to return to the home page
                </p>
                <a href="index.jsp" role="button" class="btn btn-primary btn-lg mt-2">Return to Home</a>

            </div>
        </div>
                    
        <% } %>
                    
</html>
