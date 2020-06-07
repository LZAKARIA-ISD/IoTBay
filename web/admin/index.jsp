<%-- 
    Document   : index
    Created on : 29/04/2020, 2:05:37 PM
    Author     : lucas
--%>

<%@page import="isd.wsd.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
       <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css" />
        <title>IoTBay - Admin Panel</title>
    </head>
    <body>
        <%
            Admin admin = (Admin)session.getAttribute("admin");
            
            if(admin == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                 
                    <a href="../index.jsp" role="button" class="btn btn-primary">Return Home</a>
             
                </div>
            </div>
            <div class="text-center">
                <h1 class="display-3">Admin Console</h1>
                
                <div class="customer-profile">
                    <table class="table">
                    <tr>
                        <th>Full Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Date of Birth</th>
                        <th>Gender</th>
                    </tr>
                    <tr>
                        <td>${customer.name}</td>
                        <td>${customer.email}</td>
                        <td>${customer.password}</td>
                        <td>${customer.dob}</td>
                        <td class="text-capitalize">${customer.gender}</td>
                    </tr>
                </table>
                </div>
                
                <p><em>Products coming soon...</em></p>

            </div>
            
            
            
        </div>
</html>
