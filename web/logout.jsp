<%-- 
    Document   : index
    Created on : 29/04/2020, 2:05:37 PM
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css" />
        <title>IoTBay - Logout Page</title>
    </head>
    <body>
        <% session.invalidate(); %>
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <a href="ProductCollectionServlet" class="btn btn-outline-primary mr-2">Products</a>
                    <a href="login.jsp" role="button" class="btn btn-light" >Login</a>
                    <a href="register.jsp" role="button" class="btn btn-primary">Register</a>
                </div>
            </div>
            <div class="text-center">
                <h1 class="display-3">Logged out</h1>
            <p class="lead">
                    You have successfully logged out of IoTBay
                    <br>
                    Click the button below to return to the home page
                </p>
                <a href="index.jsp" role="button" class="btn btn-primary btn-lg mt-2">Return to Home</a>
            </div>
        </div>
</html>
