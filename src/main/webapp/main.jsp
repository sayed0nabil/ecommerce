<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Commerce</title>
    <%-- My Custmo Css File--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/main.css" />
</head>
<body>
<header>
    <jsp:include page="nav.jsp" />
    <div class="header-content overflow-hidden">
        <div class="cover overflow-hidden">
            <section class="text-white header-text-content">
                <div class="container col-lg-10">
                    <h2>Find Your Product Here</h2>
                    <ul>
                        <li>You Can Browse For Products</li>
                        <li>You Can Put Your Products In Cart</li>
                        <li>You Can Increase Your Limit By Using Generation Code</li>
                        <li>You Can Buy What You Want Using Your Limit</li>
                        <li>You Can Search about Products</li>
                    </ul>
                    <button class="btn btn-outline-warning">Shope Now</button>
                </div>
            </section>
        </div>
    </div>
    <jsp:include page="footer.html"/>
</header>
</body>
</html>
