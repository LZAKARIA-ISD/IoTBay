<%-- 
    Document   : editProduct
    Created on : 07/06/2020, 3:29:53 PM
    Author     : Sam
--%>

<%@page import="isd.wsd.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            Product product = (Product)session.getAttribute("product");
            String update = (String)session.getAttribute("productUpdate");
            String priceErr = (String)session.getAttribute("priceErr");
            String quantityErr = (String)session.getAttribute("quantityErr");
            String productNameErr = (String)session.getAttribute("productNameErr");
            String detailErr = (String)session.getAttribute("detailErr");
            String typeErr = (String)session.getAttribute("typeErr");
        %>
        <div class="container-fluid">
            <div class="register">
                <div class="card">
                    <div class="card-body">
                        <h1 class="text-center">Edit Product</h1>
                        <p class="text-center"><%= (update != null ? update : "") %></p>
                        <form action="UpdateProductServlet" method="Post">
                            <div class="form-group">
                                <label for="id">ID: </label>
                                <input value="${product.id}" type="text" class="form-control-plaintext" id="id" name="id" readonly>
                            </div>
                            <div class="form-group">
                                <label for="name">Name:</label>
                                <input placeholder="<%= (productNameErr != null ? productNameErr : "") %>" value="<%= (productNameErr != null ? "" : product.getName()) %>" type="text" class="form-control" id="name" name="name" required="">
                            </div>
                            <div class="form-group">
                                <label for="detail">Detail:</label>
                                <input placeholder="<%= (detailErr != null ? detailErr : "") %>" value="<%= (detailErr != null ? "" : product.getDetail()) %>" type="text" class="form-control" id="detail" name="detail" required="">
                            </div>
                            <div class="form-group">
                                <label for="type">Type:</label>
                                <input placeholder="<%= (typeErr != null ? typeErr : "") %>" value="<%= (typeErr != null ? "" : product.getType()) %>" type="text" class="form-control" id="type" name="type" required="">
                            </div>
                            <div class="form-group">
                                <label for="price">Price:</label>
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">$</div>
                                    </div>
                                    <input placeholder="<%= (priceErr != null ? priceErr : "") %>" value="<%= (priceErr != null ? "" : product.getPrice()) %>" type="text" class="form-control" id="price" name="price" required="">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="quantity">Quantity</label>
                                <input placeholder="<%= (quantityErr != null ? quantityErr : "") %>" value="<%= (quantityErr != null ? "" : product.getQuantity()) %>" type="text" class="form-control" id="quantity" name="quantity" required="">
                            </div>
                            <div class="text-center">
                                <input type="submit" value="Update" class="btn btn-outline-primary">
                                <a href="ProductCollectionServlet" class="btn btn-outline-danger">Back</a>
                            </div>
                    </form>
                </div>
            </div>
            </div>
        </div>
    </body>
</html>

