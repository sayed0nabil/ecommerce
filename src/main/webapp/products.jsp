<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>E-Commerce</title>

    <%-- My Custmo Css Files--%>
    <link rel="stylesheet" href="./views/css/main.css"/>
    <link rel="stylesheet" href="./views/css/products.css"/>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="products">
    <div class="container">
        <div class="row">
            <c:set var="current" value="" scope="page"/>
            <c:if test="${empty requestScope.products}">
                <div class="m-auto w-50 alert alert-danger p-2">
                    No Products Found
                </div>
            </c:if>
            <c:forEach items="${requestScope.products}" var="product">
            <c:if test="${current != product.getCategory().getName()}">
                <h1 class="category-header col-md-12 p-2">${product.getCategory().getName()}</h1>
                <hr style="width: 100%"/>
                <c:set var="current" value="${product.getCategory().getName()}"/>
            </c:if>
            <c:if test="${product.quantity > 0}">
                <div class="card col-lg-3 col-md-4 my-3">
                    <div class="product-image">
                        <img class="card-img-top" src="./productImages?productID=${product.id}&imageNumber=1" alt="Card image cap">
                        <div class="product-cover"></div>
                        <a class="btn btn-primary inner-view-details"
                           href="${pageContext.request.contextPath}/productprofile?productId=${product.getId()}">View
                            Details</a>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <h3 class="card-title"><c:out value="${product.getName()}"/></h3>
                        </li>
                        <li class="list-group-item">
                            <h4 class="text-primary font-weight-bold"><c:out value="${product.getPrice()}"/>.00 EGP</h4>
                        </li>
                    </ul>
                    <div class="card-body">
                        <c:if test="${not empty sessionScope.mine}">
                            <c:choose>
                                <c:when test="${sessionScope.mine.getAdmin() == 1}">
                                    <a href="admin/editproduct?productid=${product.getId()}"
                                       class="btn btn-outline-info btn-lg btn-block">Edit</a>
                                    <a href="admin/removeproduct?productid=${product.getId()}"
                                       class="btn btn-danger btn-lg btn-block">Remove</a>
                                </c:when>
                                <c:otherwise>
                                    <button type="button" class="btn btn-success btn-lg btn-block">Add To Cart</button>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </div>
                </div>
            </c:if>
        </c:forEach>
        </div>
    </div>
    <hr/>
</div>
</div>
</body>
</html>
