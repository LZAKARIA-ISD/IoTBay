<%-- 
    Document   : orderUpdate
    Created on : 08/06/2020, 4:53:04 PM
    Author     : Sorakrit
--%>
<%@page import="isd.wsd.Product"%>
<%@page import="isd.wsd.Order"%>
<%@page import="isd.wsd.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Order</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%
            Product product = (Product)session.getAttribute("product");
            String quantityErr = (String)session.getAttribute("quantityErr");
            Order order = (Order)session.getAttribute("order");
            Customer customer = (Customer)session.getAttribute("order");
        %>
        <h>Edit your order</h>
    </body><form action="orderHistory.jsp" method="post">
            <table>
                <tr><td>Order Name :</td>
                    <td><input value="${product.name}" type="text" class="form-control-plaintext" id="id" name="id" readonly></td></tr>
                <tr><td>Order Detail :</td>
                    <td><input value="${product.detail}" type="text" class="form-control-plaintext" id="detail" name="detail" readonly></td></tr>
                <tr><td>Total Price :</td>
                    <td><input value="${product.price}" type="text" class="form-control-plaintext" id="price" name="price" readonly></td></tr>
                <tr><td>Order Type :</td>
                    <td><input type="date" name="dob" value="${customer.dob}"></td></tr>
                <div class="form-group">
                                <label class="mr-2" for="quantity">Quantity: </label>
                                <input type="text" class="form-control mr-2" id="quantity" name="quantity">
                            </div>
            </table>
            <div>
                <a class="myButton" href="MainServlet?email='<%=customer.getEmail()%>' &password='<%=customer.getPassword()%>'" >Main</a>
                <a class="myButton" href="orderHistory.jsp"> Back </a>
                <input type="submit" value="Update" class="myButton">
            </div>
        </form>
</html>
