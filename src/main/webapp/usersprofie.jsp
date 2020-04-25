<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Commerce</title>
    <%-- My Custmo Css File--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/main.css"/>
</head>
<body>
<header>
    <jsp:include page="nav.jsp"/>
</header>
<h1 class="text-center my-2">Users' profiles</h1>

<div class="row justify-content-center" style="min-height: 72vh">
    <table class="table table-striped col-md-8">
        <tr class="bg-primary text-white">
            <th>Image</th>
            <th>Name</th>
            <th>email</th>
            <th>BirthDate</th>
            <th>Admin</th>
        </tr>
        <c:forEach items="${requestScope.users}" var="iterator">
            <tr>
                <td><img class="img-profile rounded-circle" style="width:2rem;height:2rem"
                         src="usersimages?userid=${iterator.id}"/></td>
                <td>${iterator.firstName} ${iterator.lastName}</td>
                <td>${iterator.email}</td>
                <td>${iterator.birthDate}</td>
                <td>
                    <c:choose>
                        <c:when test="${iterator.admin == 0}">

                            No

                        </c:when>
                        <c:otherwise>

                            Yes

                        </c:otherwise>

                    </c:choose>

                </td>

            </tr>

        </c:forEach>
    </table>
</div>
<jsp:include page="footer.html"/>
<style>
    table {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    #customers td, table th {
        border: 1px solid #ddd;
        padding: 8px;
    }

    #customers tr:nth-child(even){background-color: #f2f2f2;}

    #customers tr:hover {background-color: #ddd;}

    #customers th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #4CAF50;
        color: white;
    }
</style>

</body>
</html>
