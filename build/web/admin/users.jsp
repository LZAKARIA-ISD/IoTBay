<%-- 
    Document   : users
    Created on : 08/06/2020, 4:30:25 PM
    Author     : lucas
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="isd.wsd.Admin"%>
<%@page import="isd.wsd.User"%>
<%@page import="isd.wsd.Customer"%>
<%@page import="isd.wsd.Staff"%>
<%@page import="isd.controller.*"%>
<jsp:include page="../ConnServlet"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
       <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css" />
        <title>IoTBay - User Management</title>
    </head>
    <body>
        <%
            Admin admin = (Admin)session.getAttribute("admin");
            ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
                        
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
                <h1 class="display-3">User Management</h1>
                
                <div class="customer-profile">
                    <table class="table">
                        <tr>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Phone</th>
                            <th>Update</th>
                            <th>Remove</th>
                        </tr>
                        <% if(users != null) {  %>
                            <% for(User user : users){ %>

                                <tr>
                                    <td><%out.print(user.getName());%></td>
                                    <td><%out.print(user.getEmail());%></td>
                                    <td><%out.print(user.getPassword());%></td>
                                    <td><%out.print(user.getPhone());%></td>
                                    <td><a href="updateUser.jsp?email=<%out.print(user.getEmail());%>" class="btn btn-primary btn-sm">Update</a></td>
                                    <td><a href="removeUser.jsp?email=<%out.print(user.getEmail());%>" class="btn btn-danger btn-sm">X</a></td>
                                </tr>

                            <% }
                            } else { %>
                            
                            <tr>
                            <h5>no users exist</h5>
                            </tr>
                            <% } %>
                            
                        
                        
                        
                        <!--<c:forEach var="user" items="${users}">
                            <tr>
                                <td><c:out value="${user.name}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.password}" /></td>
                            <td><c:out value="${user.phone}" /></td>
                            <td><a href="updateUser.jsp?email=${user.email}" class="btn btn-primary btn-sm">Update</a></td>
                            <td><a href="removeUser.jsp?email=${user.email}" class="btn btn-primary btn-sm">X</a></td>
                            </tr>
                            
                        </c:for> -->
                        
                    </table>
                </div>
                
    

            </div>
            
            
            
        </div>
</html>
