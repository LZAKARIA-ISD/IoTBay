<%-- 
    Document   : addCustomer
    Created on : 08/06/2020, 7:51:04 PM
    Author     : lucas
--%>

<%@page import="isd.wsd.Admin"%>
<%@page import="isd.wsd.Customer"%>
<%@page import="isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Add Customer</title>
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
                <h3><a href="../index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                 
                    <a href="index.jsp" role="button" class="btn btn-primary">Home</a>
             
                </div>
            </div>
            <div class="text-center">
                <h1 class="display-4">Add Customer</h1>
                <%
                    String existErr = (String) session.getAttribute("existErr");
                    String emailErr = (String) session.getAttribute("emailErr");
                    String nameErr = (String) session.getAttribute("nameErr");
                    String passErr = (String) session.getAttribute("passErr");
                    String customerAdded = (String) session.getAttribute("customerAdded");
                    System.out.println("exist = "+existErr);
                    session.setAttribute("customerAdded", null);
                %>
                
                <% if(customerAdded != null){ %>
                    <div class="alert alert-success" role="alert">
                        Customer "<%=customerAdded%>" was successfully added!
                    </div>
                <% } %>
              
            <div class="register text-left">
                <div class="card">
                    <div class="card-body">
                      <form method="POST" action="AddCustomerServlet">
                        <div class="form-group">
                          <label for="name">Full Name</label>
                          <input type="text" class="form-control" id="name" name="name" placeholder="<%=(nameErr != null ? nameErr : "Enter Name")%>">
                        </div>
                        <div class="form-group">
                          <label for="email">Email address</label>
                          <input type="text" class="form-control" id="email" name="email" placeholder="<%=(emailErr != null ? emailErr : "Enter Email")%>">
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control" id="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter Password")%>">
                        </div>
                          <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Enter Phone Number">
                          </div>
                        <div class="form-group">
                            <label for="type">Type</label>
                            <select class="form-control" id="type" name="type">
                                <option value="individual">Individual</option>
                                <option value="company">Company</option>
                            </select>
                          </div>
                          <div class="text-center">
                              <button type="submit" class="btn btn-success ">Add Customer</button>
                          </div>
                      </form>
                    </div>
                </div>
            </div>
                
                
    

            </div>
            
            
            
        </div>
    </body>
</html>
