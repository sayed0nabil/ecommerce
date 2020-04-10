<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Commerce</title>
    <link rel="stylesheet" href="./views/css/libs/bootstrap.min.css" />
    <script src="./views/js/libs/jquery-3.4.1.min.js"></script>
    <script src="./views/js/libs/bootstrap.min.js"></script>

    <!-- Font Awesome -->
    <link rel="stylesheet" href="views/css/libs/all.min.css" />
    <script src="./views/js/libs/all.min.js"></script>

    <%-- My Custmo Css File--%>
    <link rel="stylesheet" href="./views/css/main.css" />

    <%-- Google Fonts --%>
    <link href="https://fonts.googleapis.com/css2?family=Gotu&display=swap" rel="stylesheet">

    <%-- Icon In Tab--%>
    <link rel="icon" href="./views/images/cart.png" />
</head>
<body>
<header>
    <div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container col-lg-10">
                <a class="main-link navbar-brand mr-5 text-warning" href="#">
                    Shopping
                </a>
                <form class="form-inline w-75">
                    <input type="text" class="form-control mb-2 w-75" id="inlineFormInputName2" placeholder="What You Looking For ?">
                    <button type="submit" class="btn btn-info mb-2" style="width: 60px; border-radius: 0">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
                <button class="btn btn-primary mr-2">Login</button>
                Or
                <a href="#" class="mx-2">Register</a>
                <span class="cart ml-3">
                    <img width="40" height="40" src="./views/images/cart.png" alt="Cart" />
                </span>
            </div>
        </nav>
        <nav class="categories navbar navbar-expand-lg navbar-dark bg-secondary p-0 text-center">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mx-auto">
                    <c:forEach var = "i" begin = "1" end = "5">
                        <li class="nav-item active">
                          <a class="nav-link" href="#">Category <c:out value = "${i}"/> <span class="sr-only">(current)</span></a>
                         </li>
                    </c:forEach>
                </ul>
            </div>
        </nav>
    </div>
    <div class="header-content overflow-hidden">
        <div class="cover overflow-hidden">
            <section class="text-white header-text-content">
                <div class="container col-lg-10">
                    <h2>Find Your Product Here</h2>
                    <p>
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry.
                        Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                        when an unknown printer took a galley of type and scrambled it to make
                        a type specimen book.
                    </p>
                    <button class="btn btn-outline-warning">Shope Now</button>
                </div>
            </section>
        </div>
    </div>
</header>
</body>
</html>
