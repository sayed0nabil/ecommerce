<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 4/11/2020
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./views/css/nav.css"/>
</head>
<body>
    <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container col-lg-10">
                <a class="main-link navbar-brand mr-5 text-warning" href="main">
                    Shopping
                </a>
                <form class="form-inline w-75" style="position: relative;">
                    <input type="text" class="form-control mb-2 w-75" id="searchInput" placeholder="What You Looking For ?">
                    <button type="submit" class="btn btn-info mb-2" style="width: 60px; border-radius: 0">
                        <i class="fas fa-search"></i>
                    </button>
                    <ul class="search-result list-group" id="myList" style="position: absolute; top: 37px; z-index: 999; width: 100%;">
                        <li class="list-group-item">Hi</li>
                    </ul>
                </form>
                <c:choose>
                    <c:when test="${ empty sessionScope.mine}">
                        <a class="btn btn-primary mr-2" href="loginPage.html">Login</a>
                        Or
                        <a href="#" class="mx-2">Register</a>
                    </c:when>
                    <c:otherwise>
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Myprofile
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="logout">Logout</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </div>
                        <span class="cart ml-3">
                            <img width="40" height="40" src="./views/images/cart.png" alt="Cart" />
                        </span>
                    </c:otherwise>
                </c:choose>

            </div>
        </nav>
        <nav class="categories navbar navbar-expand-lg navbar-dark bg-secondary p-0 text-center">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="products">All Categories <span class="sr-only">(current)</span></a>
                    </li>
                    <c:forEach items="${requestScope.categories}" var="category">
                        <li class="nav-item active">
                            <a class="nav-link" href="<c:out value="category/${category.getName()}" />"><c:out value = "${category.getName()}"/> <span class="sr-only">(current)</span></a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </nav>
    </div>
    <script src="./views/js/search.js"></script>
</body>
</html>
