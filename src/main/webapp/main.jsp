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
    <jsp:include page="nav.jsp" />
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
