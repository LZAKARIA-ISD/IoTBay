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
            String search = request.getParameter("search");
            ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
            String userRemoved = (String) session.getAttribute("userRemoved");
            session.setAttribute("userRemoved", null);
                        
            if(admin == null) {
                response.sendRedirect("login.jsp");
            }
           
        %>
        <div class="container">
            <div class="navigation">
                <h3><a href="../index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                 
                    <a href="index.jsp" role="button" class="btn btn-primary">Home</a>
                    <a href="index.jsp" role="button" class="btn btn-outline-primary">Back</a>
                    <a href="logout.jsp" role="button" class="btn btn-link">Logout</a>
             
                </div>
            </div>
            <div class="text-center">
                <h1 class="display-3">User Management</h1>
                
                <div class="customer-profile">
                    <div class="d-flex justify-content-between align-items-end">
                        <div class="mb-2">
                            <a href="addCustomer.jsp" class="btn btn-success btn-sm">Add Customer</a>
                            <a href="addStaff.jsp" class="btn btn-success btn-sm">Add Staff Member</a>
                        </div>
                        <form class="form-inline " action="FetchUsersServlet" method="GET">
                            <label class="sr-only" for="search">Search</label>
                            <input type="text" class="form-control mb-2 mr-sm-2" id="search" name="search" placeholder="Search users..." value="<%=search != null ? search : ""%>">
                            <button type="submit" class="btn btn-primary mb-2">Search</button>
                            <% if(search != null){ %>
                                <a href="FetchUsersServlet" class="btn btn-secondary mb-2 ml-2">Cancel</a>
                            <% } %>

                      </form>
                    </div>
                            
                            <% if(userRemoved != null){ %>
                                    <div class="alert alert-success" role="alert">
                                        User <%=userRemoved%> was successfully removed!
                                    </div>
                             <% } %>
                    
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
                                    <td><%=user.getName()%></td>
                                    <td><%=user.getEmail()%></td>
                                    <td><%=user.getPassword()%></td>
                                    <td><%=user.getPhone()%></td>
                                    <td>
                                        <form action="EditUserServlet" method="post">
                                            <input type="hidden" name="email" value="<%=user.getEmail()%>" />
                                            <input type="hidden" name="password" value="<%=user.getPassword()%>" />
                                            <input type="hidden" name="type" value="<%=user instanceof Customer ? "customer" : "staff"%>" />
                                            <button type="submit" class="btn btn-primary btn-sm">Update</button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="RemoveUserServlet" method="post">
                                            <input type="hidden" name="email" value="<%=user.getEmail()%>" />
                                            <input type="hidden" name="password" value="<%=user.getPassword()%>" />
                                            <input type="hidden" name="type" value="<%=user instanceof Customer ? "customer" : "staff"%>" />
                                            <button type="submit" class="btn btn-danger btn-sm">X</button>
                                        </form>
                                        </td>
                                </tr>

                            <% }
                            } else { %>
                            
                            <tr>
                                <h5>No users exist</h5>
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
    </body>
</html>
