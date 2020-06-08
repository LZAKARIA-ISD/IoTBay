<%-- 
    Document   : login
    Created on : 07/06/2020, 11:01:54 PM
    Author     : chris
--%>

<%@page import="isd.wsd.Staff"%>
<%@page import="isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="StaffConnServlet.java"/> 
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
        
            Staff staff = (Staff)session.getAttribute("staff");
        
        %>
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <% if(staff == null) { %>
                    <a href="login.jsp" role="button" class="btn btn-light" >Login</a>
                    <a href="register.jsp" role="button" class="btn btn-primary">Register</a>
                    <% } else { %>
                    <a href="main.jsp" role="button" class="btn btn-primary">Main</a>
                    <a href="logout.jsp" role="button" class="btn btn-link">Log out</a>
                    <% } %>
                </div>
            </div>
                
            <%
                String existErr = (String) session.getAttribute("existErr");
                String emailErr = (String) session.getAttribute("emailErr");
                String passErr = (String) session.getAttribute("passErr");
            %>    
                
            <h1 class="display-3 text-center">Login <%=(existErr != null ? existErr : "")%> </h1> 
            <div class="register">
                <div class="card">
                    <div class="card-body">
                      <form method="POST" action="StaffLoginServlet">
                        <div class="form-group">
                          <label for="email">Email address</label>
                          <input type="text" class="form-control" id="email" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter Email")%>">
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter Password")%>">
                        </div>
                          <input type="hidden" name="objtype" value="login" />
                          <div class="text-center">
                              <button type="submit" class="btn btn-primary ">Log in</button>
                          </div>
                      </form>
                    </div>
                </div>
            </div>
        </div>
</html>