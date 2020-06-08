<%-- 
    Document   : customers
    Created on : 08/06/2020, 7:14:57 PM
    Author     : lukez
--%>

<%--
    The necessary classes have been imported below
    to help the code on this web page to function
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
    
    <%--
        The head links the web page to the css and provides,
        the tab in the web browser with a title
    --%>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css" />
        <title>IoTBay - Customer Information Management</title>
    </head>
    
    <body>
        
        <%--
            The below code is used to determine whether the end user has successfully loggedin as an admin,
            if they haven't the web app redirects the user to the admin login page to try again.
        --%>
        
        <%
            Admin admin = (Admin) session.getAttribute("admin");
            String search = request.getParameter("search");
            ArrayList<Customer> customers = (ArrayList<Customer>) session.getAttribute("customers");

            if (admin == null) {
                response.sendRedirect("login.jsp");
            }
        %>
    
        <div class="container">
            <%--
            The navigation class contains the top row of icons which includes;
            
            On the left side;
                - The website name, which acts as a link to the main home page
                
            On the right side;
                - Home Button   - (Returns the end user to the admin console page)
                - Back Button   - (Returns the end user to the previous page, 
                    on the customer information page it servers the same role as the home button however,
                    when the end user selects the Add Customer or Update Customer buttons,
                    it will redirect the end user to the previous page which would be the Customer Info Management page.
                - Logout Button - (Sends the end user to the logout page, which then provides a link to the IoTBay landing page,
                    the logout page also provides a login button that the end user can use to re-enter the admin console.
            --%>
            <div class="navigation">
                <h3><a href="../index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">

                    <a href="index.jsp" role="button" class="btn btn-primary">Home</a>
                    <a href="index.jsp" role="button" class="btn btn-outline-primary">Back</a>
                    <a href="logout.jsp" role="button" class="btn btn-link">Logout</a>
                </div>
            </div>
            
            <%--
                Simple header text of this web page, it utilizes the "display-3" class to maintain the
                consistency displayed throughout the website.
            --%>
            
            <h1 style="text-align: center" class="display-3"> Customer Info Management</h1>
            <br><br>
            
            <%--
                The next div contains the first half of the CRUD,
                this includes; an "Add Customer" Button and an input search bar with a search button that initiates the search.
            --%>
            
            <div class="d-flex justify-content-between align-items-end">
                <div class="mb-2">
                    <a href="addCustomer.jsp" role="button" class="btn btn-success btn-sm">Add Customer</a>
                </div>
            
                <form class="form-inline " action="FetchCustomersServlet" method="GET">
                    <label class="sr-only" for="search">Search</label>
                    <input type="text" class="form-control mb-2 mr-sm-2" id="search" name="search" placeholder="Search customers..." value="<%=search != null ? search : ""%>">
                    <button type="submit" class="btn btn-primary mb-2">Search</button>
                    <% if (search != null) { %>
                    <a href="FetchUsersServlet" class="btn btn-secondary mb-2 ml-2">Cancel</a>
                    <% } %>
                </form>
            </div>
                
            <%--
                Below is the customers table, this is where the Read part of the CRUD would occur,
                the end user is not required to press a "Read Customers" button as the customers 
                are called and displayed automatically on this page.
            --%>
                
            <div style="text-align: center">
                <table class="table">
                    
                    <%-- 
                        Table headers
                    --%>
                    
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Type</th>
                        <th>Address</th>
                        <th>Update</th>
                        <th>Remove</th>
                    </tr>
                    
                    <%--
                        Printing all customers into the table in their respective columns
                    --%>
                    
                    <% if (customers != null) {  %>
                    <% for (Customer customer : customers) { %>
                    <tr>
                        <td><%out.print(customer.getName());%></td>
                        <td><%out.print(customer.getEmail());%></td>
                        <td><%out.print(customer.getType());%></td>
                        <td><%out.print(customer.getAddress());%></td>
                    
                    <%--
                        The next 2 lines of code cover the "Update" & "Delete" of the CRUD,
                        
                        The first line takes the end user to an update custoemr page,
                        this page edits the information of the customer in the same row as this button.
                    
                        The second line of code deletes the customer in the same row as this button.
                    --%>
                            
                        <td><a href="updateCustomer.jsp?email=<%out.print(customer.getEmail());%>" class="btn btn-primary btn-sm">Update</a></td>
                        <td><a href="removeCustomer.jsp?email=<%out.print(customer.getEmail());%>" class="btn btn-danger btn-sm">X</a></td>
                    </tr>
                    
                    <%--
                        if no customers exist then, the text "no customers exist" will be displayed
                        to inform the end user.
                    --%>
                    
                    <% }
                    } else { %>

                    <tr>
                    <h5>no customers exist</h5>
                    </tr>
                    <% }%>
                </table>
                
            </div>
        </div>
    </body>
</html>