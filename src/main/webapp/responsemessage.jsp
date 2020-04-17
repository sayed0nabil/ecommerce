<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 4/15/2020
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <link rel="stylesheet" href="../views/css/libs/bootstrap.min.css" />
    <script src="../views/js/libs/jquery-3.4.1.min.js"></script>
    <script src="../views/js/libs/bootstrap.min.js"></script>

    <%-- Icon In Tab--%>
    <link rel="icon" href="./views/images/cart.png" />

</head>
<body>
    <div class="row justify-content-center mt-3">
    <c:choose>
        <c:when test="${param.status == 200}">
            <h2 class="alert alert-success text-center col-md-6 col-10" role="alert">
                Successfully Removed
            </h2>
        </c:when>
        <c:when test="${param.status == 404}">
            <h2 class="alert alert-danger text-center col-md-6 col-10" role="alert">
                Product Not Found
            </h2>
        </c:when>
        <c:otherwise>
            <h2 class="alert alert-danger text-center col-md-6 col-10" role="alert">
                Failed To Delete Product
            </h2>
        </c:otherwise>
    </c:choose>
    </div>
    <script>
        document.body.onload = function(){
            setTimeout(function (){
                window.location = "/ecommerce_war/products";
            }, 3000);
        }
    </script>
</body>
</html>
