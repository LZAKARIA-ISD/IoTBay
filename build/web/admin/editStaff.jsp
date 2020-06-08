<%-- 
    Document   : editStaff
    Created on : 08/06/2020, 7:51:04 PM
    Author     : lucas
--%>

<%@page import="isd.wsd.Admin"%>
<%@page import="isd.wsd.Staff"%>
<%@page import="isd.controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Edit Staff Member</title>
    </head>
    <body>
        <%
            Admin admin = (Admin)session.getAttribute("admin");
            Staff staff = (Staff)session.getAttribute("staffEdit");
                        
            if(admin == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <div class="container">
            <div class="navigation">
                <h3><a href="../index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                 
                   <a href="index.jsp" role="button" class="btn btn-primary">Home</a>
                    <a href="FetchUsersServlet" role="button" class="btn btn-outline-primary">Back</a>
                    <a href="logout.jsp" role="button" class="btn btn-link">Logout</a>
             
             
                </div>
            </div>
            <div class="text-center">
                <h1 class="display-4">Edit Staff Member</h1>
                <%
                    String existErr = (String) session.getAttribute("existErr");
                    String emailErr = (String) session.getAttribute("emailErr");
                    String nameErr = (String) session.getAttribute("nameErr");
                    String passErr = (String) session.getAttribute("passErr");
                    String staffUpdated = (String) session.getAttribute("staffUpdated");
                    System.out.println("exist = "+existErr);
                    session.setAttribute("staffUpdated", null);
                %>
                
                <% if(staffUpdated != null){ %>
                    <div class="alert alert-success" role="alert">
                        Staff Member "<%=staffUpdated%>" was successfully updated!
                    </div>
                <% } %>
              
            <div class="register text-left">
                <div class="card">
                    <div class="card-body">
                      <form method="POST" action="EditStaffServlet">
                        <div class="form-group">
                          <label for="name">Full Name</label>
                          <input type="text" class="form-control" id="name" name="name" placeholder="<%=(nameErr != null ? nameErr : "Enter Name")%>" value="<%=staff.getName()%>">
                        </div>
                        <div class="form-group">
                          <label for="email">Email address</label>
                          <input type="text" class="form-control" id="email" name="email" readonly placeholder="<%=(emailErr != null ? emailErr : "Enter Email")%>" value="<%=staff.getEmail()%>">
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="hidden" name="oldPassword" value="<%=staff.getPassword()%>" />
                          <input type="password" class="form-control" id="password" name="password" placeholder="<%=(passErr != null ? passErr : "Enter Password")%>" value="<%=staff.getPassword()%>">
                        </div>
                          <div class="form-group">
                            <label for="phone">Phone Number</label>
                            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Enter Phone Number" value="<%=staff.getPhone()%>">
                          </div>
                        <div class="form-group">
                            <label for="position">Position</label>
                            <input type="text" class="form-control" id="position" name="position" placeholder="Enter Staff Position" value="<%=staff.getPosition()%>">
                          </div>
                          <div class="text-center">
                              <button type="submit" class="btn btn-success ">Edit Staff Member</button>
                          </div>
                      </form>
                    </div>
                </div>
            </div>
                
                
    

            </div>
            
            
            
        </div>
    </body>
</html>
