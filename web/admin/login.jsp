<%-- 
    Document   : index
    Created on : 29/04/2020, 2:05:37 PM
    Author     : lucas
--%>
<%@page import="isd.wsd.Admin"%>
<%@page import="isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../ConnServlet"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css" />
        <title>IoTBay - Admin Login</title>
    </head>
    <body>
        <%
        
            Admin admin = (Admin)session.getAttribute("admin");
        
        
        %>
        <div class="container">
            <div class="navigation">
                <h3><a href="../index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <% if(admin == null) { %>
                    <a href="login.jsp" role="button" class="btn btn-light" >Login</a>
                    <% } else { %>
                    <a href="index.jsp" role="button" class="btn btn-primary">Home</a>
                    <a href="logout.jsp" role="button" class="btn btn-link">Log out</a>
                    <% } %>
                </div>
            </div>
                
            <%
                String adminExistErr = (String) session.getAttribute("adminExistErr");
                String adminUserErr = (String) session.getAttribute("adminUserErr");
                String adminPassErr = (String) session.getAttribute("adminPassErr");
                session.setAttribute("adminExistErr",null);
            %>    
            
            
                

                
            <h1 class="display-3 text-center">Admin Login</h1>
            <div class="register">
                <% if(adminExistErr != null){ %>
                    <div class="alert alert-danger" role="alert">
                        Admin user does not exist!
                    </div>
                <% } %>
                <div class="card">
                    <div class="card-body">
                        <% if (admin == null) { %>
                      <form method="POST" action="AdminLoginServlet">
                        <div class="form-group">
                          <label for="username">Username</label>
                          <input type="text" class="form-control" id="username" name="username" placeholder="<%=(adminUserErr != null ? adminUserErr : "Enter username")%>">
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" name="password" placeholder="<%=(adminPassErr != null ? adminPassErr : "Enter password")%>">
                        </div>
                
                          <div class="text-center">
                              <button type="submit" class="btn btn-primary ">Log in</button>
                          </div>
                      </form>
                      
                      <% } else { %>
                        <a href="index.jsp" role="button" class="btn btn-primary">Continue as Admin</a>
                        <a href="logout.jsp" role="button" class="btn btn-link">Log out</a>
                       <% } %>
                    </div>
                </div>
                    
                    <div class="mt-5 text-center text-muted">
                        <h3>Default Login</h3>
                        <p>User: admin | Pass: admin</p>

                    </div>
            </div>
            
        </div>
    </body>

</html>
