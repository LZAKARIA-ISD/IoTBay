<%-- 
    Document   : customers
    Created on : 08/06/2020, 7:14:57 PM
    Author     : lukez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/style.css" />

        <title>Customer Information Management</title>
    </head>
    <body>
        <div class="container">
            <div class="navigation">
                <h3><a href="../index.jsp" class="logo-text">IoTBay</a></h3>
                <div class="inner-nav">

                    <a href="index.jsp" role="button" class="btn btn-primary">Home</a>

                </div>
            </div>

            <h1 style="text-align: center" class="display-3"> Customer Information</h1>
            <h1 style="text-align: center" class="display-3"> Management</h1>
            <br><br><br><br>
            <div style="text-align: center">
                <table class="table">
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Type</th>
                        <th>Address</th>
                        <th>Update</th>
                        <th>Remove</th>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>