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
