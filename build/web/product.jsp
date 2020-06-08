<%-- 
    Document   : product
    Created on : 07/06/2020, 3:46:26 PM
    Author     : Sam
--%>

<%@page import="isd.wsd.Product"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            Product product = (Product)session.getAttribute("product");
            DecimalFormat priceFormatter = new DecimalFormat("$#0.00");
        %>
        <div class="container-fluid">
            <div class="register">
                <div class="card">
                    <div class="card-body">
                        <h1 class="text-center">${product.name}</h1>
                        <h6>ID: ${product.id}</h6>
                        <p>${product.type}</p>
                        <p>${product.detail}</p>
                        <p><%= priceFormatter.format(product.getPrice()) %></p>
                        <!--Link to order page-->
                        <form class="form-inline justify-content-center" action="orderHistory.jsp" method="post">
                            <div class="form-group">
                                <label class="mr-2" for="quantity">Quantity: </label>
                                <input type="text" class="form-control mr-2" id="quantity" name="quantity">
                            </div>
                            <div class="mr-2">
                                <input type="submit" value="Order" class="btn btn-outline-primary">
                                <a href="ProductCollectionServlet" class="btn btn-outline-danger">Cancel</a>
                            </div>
                            <input placeholder="<%= (productNameErr != null ? productNameErr : "") %>" value="<%= (productNameErr != null ? "" : product.getName()) %>" type="hidden" class="form-control" id="name" name="name" required="">
                                <input placeholder="<%= (priceErr != null ? priceErr : "") %>" value="<%= (priceErr != null ? "" : product.getPrice()) %>" type="hidden" class="form-control" id="price" name="price" required="">
                                <input placeholder="<%= (typeErr != null ? typeErr : "") %>" value="<%= (typeErr != null ? "" : product.getType()) %>" type="hidden" class="form-control" id="type" name="type" required="">                                
                                <input placeholder="<%= (detailErr != null ? detailErr : "") %>" value="<%= (detailErr != null ? "" : product.getDetail()) %>" type="hidden" class="form-control" id="detail" name="detail" required="">
                                <input value="${product.id}" type="hidden" class="form-control-plaintext" id="id" name="id" readonly>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
