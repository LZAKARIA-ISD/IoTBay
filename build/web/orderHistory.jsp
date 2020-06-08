<%-- 
    Document   : orderHistory
    Created on : 05/06/2020, 3:08:25 PM
    Author     : Sorakrit
--%>
<%@page import="isd.wsd.Customer"%>
<%@page import="isd.controller.*"%>
<%@page import="isd.wsd.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="isd.wsd.Product"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            ArrayList<Order> orders = (ArrayList<Order>)session.getAttribute("orders");
            ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("products");
            String ordSearch = (String)session.getAttribute("ordSearch");
            String save = (String)session.getAttribute("save");
            DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
            Product product = (Product)session.getAttribute("product");
            Order order = (Order)session.getAttribute("order");
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        
         <div class="text-center">
                <h1 class="display-3">Order History</h1>
                <form class="form-inline my-4 my-lg-0" method="get" action="OrderSearchServlet">
                <input class="form-control mr-sm-2" type="search" placeholder="Search by ID & DATE" aria-label="Search" name="ordSearch">
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
        </form>
                <p class="text-center my-2"><%= (ordSearch != null ? "Results for '" + ordSearch + "'" : "") %></p>
                 <p class="text-center my-2"><%= (products.isEmpty() ? "No available products" : "") %></p>
                 <P>You're logged in as <%= customer.getEmail()%></p>
                 <form action="productCollection.jsp">            
                <input type="submit" value="Add Order">
            </form>
                <div class="customer-profile">
                    <table class="table">
                    <tr>
                        <th>OrderId</th>
                        <th>Order Name</th>
                        <th>Product Detail</th>
                        <th>Quantity</th>
                        <th>ProductPrice</th>
                        <th>ProductType</th>
                        <th>Order Date
                        <th>ProStatus</th>
                    </tr>
                    <a href="productCollection.jsp"></a>
                    <div>
                       
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.detail}</td>
                        <td>${product.quantity}</td>
                        <td><%= priceFormatter.format(product.getPrice()) %></td>
                        <td>${product.type}</td>
                        <td>
                        <td><%= (save != null ? "save" : "Saved") %></td>
                       
                    </div>
                        
                </table>
                </div>
            
            <div>
                <a class="btn btn-outline-primary"href="main.jsp">Main</a>
                        <a  class="btn btn-outline-primary"href="OrderCancelServlet?id=<%= product.getId()%>" name="cancel">Cancel</a>
                        <a  class="btn btn-outline-primary"href="EditProductServlet?id=<%= product.getId()%>">Edit</a>
                        <a class="btn btn-outline-primary"href="orderHistory.jsp" >Check out</a>
            </div> 
                 
    </body>
</html>
