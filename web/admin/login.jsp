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
        <title>IoTBay - Login</title>
    </head>
    <body>
        <%
        
            Admin admin = (Admin)session.getAttribute("admin");
        
        %>
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <% if(admin == null) { %>
                    <a href="login.jsp" role="button" class="btn btn-light" >Login</a>
                    <% } else { %>
                    <a href="main.jsp" role="button" class="btn btn-primary">Main</a>
                    <a href="logout.jsp" role="button" class="btn btn-link">Log out</a>
                    <% } %>
                </div>
            </div>
            <h1 class="display-3 text-center">Admin Login</h1>
            <div class="register">
                <div class="card">
                    <div class="card-body">
                        <% if (admin == null) { %>
                      <form method="POST" action="welcome.jsp">
                        <div class="form-group">
                          <label for="username">Username</label>
                          <input type="text" class="form-control" id="username" name="username" placeholder="e.g. john@smith.com">
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" name="password" placeholder="">
                        </div>
                    
                          <input type="hidden" name="objtype" value="login" />
                          <div class="text-center">
                              <button type="submit" class="btn btn-primary ">Log in</button>
                          </div>
                      </form>
                      
                      <% } else { %>
                        <a href="main.jsp" role="button" class="btn btn-primary">Continue as Admin</a>
                        <a href="logout.jsp" role="button" class="btn btn-link">Log out</a>
                       <% } %>
                    </div>
                </div>
            </div>
            
        </div>
</html>
