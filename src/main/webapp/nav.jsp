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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/libs/bootstrap.min.css" />
    <script src="${pageContext.request.contextPath}/views/js/libs/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/views/js/libs/bootstrap.min.js"></script>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/libs/all.min.css" />
    <script src="${pageContext.request.contextPath}/views/js/libs/all.min.js"></script>



    <%-- Google Fonts --%>
    <link href="https://fonts.googleapis.com/css2?family=Gotu&display=swap" rel="stylesheet">

    <%-- Icon In Tab--%>
    <link rel="icon" href="${pageContext.request.contextPath}/views/images/cart.png" />


    <%--    <!-- Font Awesome -->--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/libs/all.min.css"/>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/libs/custom/sb-admin-2.css"/>
    <script src="${pageContext.request.contextPath}/views/js/libs/all.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/nav.css"/>

</head>
<body>
<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container col-lg-10">
            <a class="main-link navbar-brand mr-5 text-warning" href="${pageContext.request.contextPath}/main">
                Shopping
            </a>
            <form class="form-inline w-75" style="position: relative;" action="searchproducts">
                <input type="text" class="form-control mb-2 w-75" id="searchInput" placeholder="What You Looking For ?"
                       name="keyword">
                <button type="submit" class="btn btn-info mb-2" style="width: 60px; border-radius: 0">
                    <i class="fas fa-search"></i>
                </button>
                <ul class="search-result list-group" id="myList"
                    style="position: absolute; top: 37px; z-index: 999; width: 100%;">
                </ul>
            </form>
            <c:choose>
                <c:when test="${ empty sessionScope.mine}">
                    <a class="btn btn-primary mr-2" href="${pageContext.request.contextPath}/loginPage.html">Login</a>
                    Or
                    <a href="${pageContext.request.contextPath}/register.html" class="mx-2">Register</a>
                </c:when>
                <c:when test="${sessionScope.mine.admin == 1}">

                    <!-- Nav Item - User Information -->
                    <li style="list-style-type: none" class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.mine.firstName}</span>
                            <img style="width:2.5rem;height:2.5rem" class="img-profile rounded-circle"
                                 src="${pageContext.request.contextPath}/images/users">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/addcategory">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Add Category
                            </a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/newproduct">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Add Product
                            </a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/addcredit">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Add Credit limit
                            </a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/usersprofile">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Users' profiles
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/logout" >
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>





                </c:when>
                <c:otherwise>


                <!-- Nav Item - User Information -->
                <li style="list-style-type: none" class="nav-item dropdown no-arrow">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.mine.firstName}</span>
                        <img style="width:2.5rem;height:2.5rem" class="img-profile rounded-circle"
                             src="${pageContext.request.contextPath}/images/users">
                    </a>
                    <!-- Dropdown - User Information -->
                    <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                         aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/user/profile">
                            <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                            Profile
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">
                            <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                            Logout
                        </a>
                    </div>
                </li>
                <span class="cart ml-3">
                        <a href="${pageContext.request.contextPath}/user/cart"><img width="40" height="40" src="${pageContext.request.contextPath}/views/images/cart.png" alt="Cart" /></a>
                </span>


                </c:otherwise>
            </c:choose>

        </div>
    </nav>
    <nav class="categories navbar navbar-expand-lg navbar-dark p-0 text-center">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/products">All Categories <span class="sr-only">(current)</span></a>
                </li>
                <c:forEach items="${requestScope.categories}" var="category">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}<c:out value="/category?categoryname=${category.getName()}" />"><c:out
                                value="${category.getName()}"/> <span class="sr-only">(current)</span></a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </nav>
</div>
<script src="${pageContext.request.contextPath}/views/js/search.js"></script>
</body>
</html>

