<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>E-Commerce</title>
    <link rel="stylesheet" href="./views/css/libs/bootstrap.min.css" />
    <script src="./views/js/libs/jquery-3.4.1.min.js"></script>
    <script src="./views/js/libs/bootstrap.min.js"></script>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="views/css/libs/all.min.css" />
    <script src="./views/js/libs/all.min.js"></script>

    <%-- My Custmo Css Files--%>
    <link rel="stylesheet" href="./views/css/main.css" />
    <link rel="stylesheet" href="./views/css/products.css" />
    <%-- Google Fonts --%>
    <link href="https://fonts.googleapis.com/css2?family=Gotu&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital@1&display=swap" rel="stylesheet">
    <%-- Icon In Tab--%>
    <link rel="icon" href="./views/images/cart.png" />
</head>
<body>
    <jsp:include page="nav.jsp" />
    <div class="products">
        <div class="container">
            <div class="row">
                <c:set var="current" value="" scope="page"/>
                <c:forEach items="${requestScope.products}" var="product">
                    <c:if test="${current != product.getCategory().getName()}">
                        <h1 class="category-header col-md-12 p-2">${product.getCategory().getName()}</h1>
                        <hr style="width: 100%"/>
                        <c:set var="current" value="${product.getCategory().getName()}"/>
                    </c:if>

                    <div class="card col-lg-3 col-md-4">
                        <div class="product-image">
                            <img class="card-img-top" src="./views/images/laptop.jpg" alt="Card image cap">
                            <div class="product-cover"></div>
                            <a class="btn btn-primary inner-view-details" href="http://localhost:9090/ecommerce_war/productprofile?productId=${product.getId()}">View Details</a>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <h3 class="card-title"><c:out value = "${product.getName()}"/></h3>
                            </li>
                            <li class="list-group-item">
                                <h4 class="text-primary font-weight-bold"><c:out value = "${product.getPrice()}"/>.00 EGP</h4>
                            </li>
                        </ul>
                            <%--                <ul class="list-group list-group-flush">--%>
                            <%--                    <li class="list-group-item">Cras justo odio</li>--%>
                            <%--                    <li class="list-group-item">Dapibus ac facilisis in</li>--%>
                            <%--                    <li class="list-group-item">Vestibulum at eros</li>--%>
                            <%--                </ul>--%>
                        <div class="card-body">
                            <c:if test="${not empty sessionScope.mine}">
                                <c:choose>
                                    <c:when test="${sessionScope.mine.getAdmin() == 1}">
                                        <a href="admin/editproduct?productid=${product.getId()}" class="btn btn-outline-info btn-lg btn-block">Edit</a>
                                        <a href="admin/removeproduct?productid=${product.getId()}" class="btn btn-danger btn-lg btn-block">Remove</a>
                                    </c:when>
                                    <c:otherwise>
                                        <button type="button" class="btn btn-success btn-lg btn-block">Add To Cart</button>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <hr />
        </div>
    </div>
</body>
</html>
