<%-- 
    Document   : index
    Created on : 29/04/2020, 2:05:37 PM
    Author     : lucas
--%>
<%@page import="isd.wsd.Customer"%>
<%@page import="isd.wsd.Staff"%>
<%@page import="isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/ConnServlet"/>
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
            Staff staff = (Staff)session.getAttribute("staff");
        %>
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <% if(customer == null && staff == null) { %>
                    <a href="login.jsp" role="button" class="btn btn-light" >Login</a>
                    <a href="register.jsp" role="button" class="btn btn-primary">Register</a>
                    <% } else { %>
                    <a href="main.jsp" role="button" class="btn btn-primary">Main</a>
                    <a href="LogoutServlet" role="button" class="btn btn-link">Log out</a>
                    <% } %>
                </div>
            </div>
                
                <%
                    String updated = (String) session.getAttribute("updated");
                %>
                
            <h1 class="display-3 text-center">Update Details <%=(updated != null ? updated : "")%></h1>
            
            <% if (customer != null) { %>
            <div class="register">
                <div class="card">
                    <div class="card-body">
                      <form method="POST" action="UpdateUserServlet">
                        <div class="form-group">
                          <label for="name">Full Name</label>
                          <input type="text" class="form-control" id="name" name="name" value="${customer.name}">
                        </div>
                        <div class="form-group">
                          <label for="email">Email address</label>
                          <input type="text" class="form-control" id="email" name="email" value="${customer.email}" readonly>
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" name="password" value="${customer.password}">
                        </div>
                          <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <input type="tel" class="form-control" id="phone" name="phone" value="${customer.phone}">
                          </div>
                        <div class="form-group">
                            <label for="type">Type</label>
                            <select class="form-control" id="type" name="type">
                                <option value="individual" <%=customer.isIndividual() ? "selected" : ""%>>Individual</option>
                                <option value="company" <%=customer.isCompany() ? "selected" : ""%>>Company</option>
                            </select>
                          </div>
                          <hr>
                          <input type="hidden" name="objtype" value="update" />
                          <div class="text-center">
                              <button type="submit" class="btn btn-primary ">Update</button>
                          </div>
                      </form>
                    </div>
                </div>
            </div>
            <% } else { %>
            <div class="register">
                <div class="card">
                    <div class="card-body">
                      <form method="POST" action="UpdateUserServlet">
                        <div class="form-group">
                          <label for="name">Full Name</label>
                          <input type="text" class="form-control" id="name" name="name" value="${staff.name}">
                        </div>
                        <div class="form-group">
                          <label for="email">Email address</label>
                          <input type="text" class="form-control" id="email" name="email" value="${staff.email}" readonly>
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" name="password" value="${staff.password}">
                        </div>
                          <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <input type="tel" class="form-control" id="phone" name="phone" value="${staff.phone}">
                          </div>
                        <div class="form-group">
                            <label for="position">Position</label>
                            <input type="text" class="form-control" id="position" name="position" value="${staff.position}">
                          </div>
                          <hr>
                          <input type="hidden" name="objtype" value="update" />
                          <div class="text-center">
                              <button type="submit" class="btn btn-primary ">Update</button>
                          </div>
                      </form>
                    </div>  
                </div>
            </div>
            <% } %>                    
        </div>
</html>
