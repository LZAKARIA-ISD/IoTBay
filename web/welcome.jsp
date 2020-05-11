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
        <title>IoTBay - Welcome Page</title>
    </head>
    <body>
        
        <%  
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String tos = request.getParameter("tos");
            String objtype = request.getParameter("objtype");
            
            Customer customer = (Customer)session.getAttribute("customer");
            
            
            if( (tos != null && tos.equals("tos")) || (objtype != null && objtype.equals("login")) || customer != null) {
                if(customer == null){
                    customer = new Customer(email,name,password,dob,gender);
                    session.setAttribute("customer",customer);
                }
        %>
        
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <a href="main.jsp" role="button" class="btn btn-primary" >Main</a>
                    <a href="logout.jsp" role="button" class="btn btn-link">Log out</a>
                </div>
            </div>
            <div class="text-center">
            
                <h1 class="display-3">Welcome<% if(objtype != null && objtype.equals("login")) { out.print(" back"); }%></h1>
                <p class="lead">
                    Welcome ${customer.name != null ? customer.name : customer.email} to the best website for all of your IoTBay needs. 
                    <br>
                    Click the button below to continue to the main page
                </p>
                <a href="main.jsp" role="button" class="btn btn-primary btn-lg mt-2">Continue</a>

            </div>
        </div>
                  
        <% } else { %>   
                    
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
                    
        <div class="footer text-muted"><small>Lucas Hahn - 12554200 - Group 7</small></div>
    </body>
</html>
