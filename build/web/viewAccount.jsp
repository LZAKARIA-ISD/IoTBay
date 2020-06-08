<%-- 
    Document   : index
    Created on : 29/04/2020, 2:05:37 PM
    Author     : lucas
--%>
<%@page import="isd.wsd.TimeLog"%>
<%@page import="java.util.ArrayList"%>
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
        <title>IoTBay - Account</title>
    </head>
    <body>
        <%
        
            Customer customer = (Customer)session.getAttribute("customer");
            Staff staff = (Staff)session.getAttribute("staff");
            ArrayList<TimeLog> timeLogs = (ArrayList<TimeLog>) session.getAttribute("timeLogs");
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
                
            <h1 class="display-3 text-center">Account</h1>
            <div class="register">
                <div class="card">
                    <div class="card-body">
                        <% if (customer != null) { %>
                        <table class="table">
                            <tr>
                                <th>Full Name:</th>
                                <td>${customer.name}</td>
                            </tr>
                            <tr>
                                <th>Email address:</th>
                                <td>${customer.email}</td>
                            </tr>
                            <tr>
                                <th>Password:</th>
                                <td>${customer.password}</td>
                            </tr>
                            <tr>
                                <th>Phone Number:</th>
                                <td>${customer.phone}</td>
                            </tr>
                            <tr>
                                <th>Type:</th>
                                <td>${customer.type}</td>
                            </tr>
                        </table>
                            
                        <% } else { %>
                        <table class="table">
                            <tr>
                                <th>Full Name:</th>
                                <td>${staff.name}</td>
                            </tr>
                            <tr>
                                <th>Email address:</th>
                                <td>${staff.email}</td>
                            </tr>
                            <tr>
                                <th>Password:</th>
                                <td>${staff.password}</td>
                            </tr>
                            <tr>
                                <th>Phone Number:</th>
                                <td>${staff.phone}</td>
                            </tr>
                            <tr>
                                <th>Position:</th>
                                <td>${staff.position}</td>
                            </tr>
                        </table>
                        <% } %>
                          <hr>
                          <div class="text-center">
                              <form action="edit.jsp" method="POST">
                                <button type="submit" class="btn btn-primary ">Edit</button>
                              </form>
                          </div>
                    </div>
                </div>
                <h1 class="display-3 text-center">Login Times</h1>    
                <table class="table">
                    <% if(timeLogs != null) {  %>
                            <% for(TimeLog timeLog : timeLogs){ %>
                            
                    <tr>
                        <th><% out.print(timeLog.getLoginTime()); %></th>
                    </tr>
                    
                    <% }
                            } else { %>
                    <tr>
                    <h5>no logs exist</h5>
                    </tr>
                    <% } %>
                </table> 
                <hr>
            </div>
        </div>
</html>
