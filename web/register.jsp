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
        <title>IoTBay - Register Page</title>
    </head>
    <body>
        <%
        
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
                    <a href="logout.jsp" role="button" class="btn btn-link">Log out</a>
                    <% } %>
                </div>
            </div>
            <h1 class="display-3 text-center">Register</h1>
            <div class="register">
                <div class="card">
                    <div class="card-body">
                      <form method="POST" action="welcome.jsp">
                        <div class="form-group">
                          <label for="name">Full Name</label>
                          <input type="text" class="form-control" id="name" name="name" placeholder="e.g. John Smith">
                        </div>
                        <div class="form-group">
                          <label for="email">Email address</label>
                          <input type="text" class="form-control" id="email" name="email" placeholder="e.g. john@smith.com">
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" name="password" placeholder="">
                        </div>
                          <div class="form-row">
                              <div class="form-group col-md-5">
                            <label for="dob">Date of Birth</label>
                            <input type="date" class="form-control" id="dob" name="dob">
                          </div>
                          <div class="form-group col">
                            <label for="gender">Gender</label>
                            <div style="height:38px;" class="d-flex align-items-center justify-content-around" id="gender">
                               <div class="custom-control custom-radio">
                                <input type="radio" id="male" name="gender" value="male" class="custom-control-input">
                                <label class="custom-control-label" for="male">Male</label>
                              </div>
                              <div class="custom-control custom-radio">
                                <input type="radio" id="female" name="gender" value="female" class="custom-control-input">
                                <label class="custom-control-label" for="female">Female</label>
                              </div>
                            </div>
                            
                              
                          </div>
                          </div>
                          <hr>
                        <div class="form-group custom-control custom-checkbox pt-2">
                            <input type="checkbox" class="custom-control-input" id="tos" name="tos" value="tos">
                            <label class="custom-control-label" for="tos">I agree to the terms and conditions</label>
                        </div>
                          <input type="hidden" name="objtype" value="register" />
                          <div class="text-center">
                              <button type="submit" class="btn btn-primary ">Sign Up</button>
                          </div>
                      </form>
                    </div>
                </div>
            </div>
            
        </div>
<div class="index-footer text-muted"><small>ISD - Group 7</small></div>    </body>
</html>
