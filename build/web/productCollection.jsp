<%-- 
    Document   : productCollection
    Created on : 07/06/2020, 2:37:20 PM
    Author     : Sam
--%>

<%@page import="isd.wsd.Product"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Collection</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("products");
            String error = (String)session.getAttribute("productsErr");
            DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
            String productSearch = (String)session.getAttribute("productSearch");
        %>
        
        <div class="container">
            <div class="navigation">
                <h3><a href="index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">
                    <a href="ProductCollectionServlet" class="btn btn-outline-primary mr-2">Products</a>
                    <!--Nav needs to be updated-->          
                    <a href="main.jsp" role="button" class="btn btn-primary">Main</a>
                </div>
            </div>
            
        <h1 class="text-center display-3 my-2">Products</h1>
        <div class="flex-row d-flex justify-content-center mb-4">   
            <a class="btn btn-outline-primary mr-sm-2" href="addProduct.jsp">Add Product</a>
            <a class="btn btn-outline-primary mr-sm-5" href="ProductCollectionServlet">List All Products</a>
            <form class="form-inline my-4 my-lg-0" method="get" action="SearchProductsServlet">
                <input class="form-control mr-sm-2" type="search" placeholder="Search Products" aria-label="Search" name="productSearch">
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
        <p class="text-center my-2"><%= (productSearch != null ? "Results for '" + productSearch + "'" : "") %></p>
        <p class="text-center my-2"><%= (products.isEmpty() ? "No available products" : "") %></p>
       
        <div class="row text-center">   
        <% for (Product product: products){ %>
            <div class="col-lg-4 col-sm-6 mb-4"> 
                <div class="card h-100 box-shadow">
                    <h6 class="card-header text-muted"><%= product.getType() %></h6>
                    <div class="card-body">
                        <h5 class="card-title"><%= product.getName() %></h5>
                        <h6 class="card-subtitle text-muted">ID: <%= product.getId() %></h6>
                        <p class="card-text"><%= product.getDetail() %></p>
                        <p class="card-text">Price: <%= priceFormatter.format(product.getPrice())%></p>
                        <p class="card-text">Quantity: <%= product.getQuantity() %></p>
                    </div>
                    <div class="card-footer">
                        <a class="btn btn-outline-primary" href="DeleteProductServlet?id=<%= product.getId()%>">Delete</a>
                        <a class="btn btn-outline-primary" href="EditProductServlet?id=<%= product.getId()%>">Edit</a>
                        <% if (product.getQuantity() > 0) {%>    
                        <a class="btn btn-outline-primary" href="ProductServlet?id=<%= product.getId()%>">Order</a>
                        <% } else { %>
                        Out of Stock
                        <% } %>
                    </div>      
                </div>
            </div>        
        <% } %>
        </div>
    </div>
                    
                    
    
    </body>
</html>
