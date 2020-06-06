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
            String phone = request.getParameter("phone"); //need to add to register form
            String dob = request.getParameter("dob"); //not applicable anymore
            String gender = request.getParameter("gender"); //not applicable anymore
            String tos = request.getParameter("tos"); //not applicable anymore ???
            String type = request.getParameter("type"); //individual or company
            
            Customer customer = (Customer)session.getAttribute("customer");
            
            
            if(customer != null) {
                    
                        
                     customer = new Customer(email, password, name, phone, type);

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
            
                <h1 class="display-3">Welcome</h1>
                <p class="lead">
                    Welcome ${customer.name} to the best website for all of your IoTBay needs. 
                    <br>
                    Click the button below to continue to the main page
                </p>
                <a href="main.jsp" role="button" class="btn btn-primary btn-lg mt-2">Continue</a>

            </div>
        </div>
                
                    
</html>
