<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 4/20/2020
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Credit</title>


</head>
<body>
    <jsp:include page="nav.jsp" />
    <div class="container credits row justify-content-center m-auto">
        <table class="table col-md-8" id="credits-table">
            <thead class="thead-light">
            <tr>
                <th>Code</th>
                <th colspan="2">Limit</th>
            </tr>
            </thead>
            <tbody id="credits-body">
            <c:forEach items="${requestScope.credits}" var="credit">
                <tr class="${credit.used == 1 ? 'table-primary': 'table-danger'}">
                    <td><strong>${credit.code}</strong></td>
                    <td colspan="2"><strong>${credit.limit}</strong></td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot>
                <tr class="bg-dark">
                    <td><input class="form-control mr-sm-2" type="text" placeholder="Add Credit Code" id="code"></td>
                    <td><input class="form-control mr-sm-2" type="text" placeholder="Add Limit" id="limit"></td>
                    <td><button class="btn btn-success my-2 my-sm-0" type="submit" onclick="addCreditCard('${pageContext.request.contextPath}')">Add</button></td>
                </tr>
                <tr class="text-danger" style="background: #d0cbcb">
                    <td id="code-error"></td>
                    <td id="limit-error" colspan="2"></td>
                </tr>
            </tfoot>
        </table>
    </div>
    <script src="${pageContext.request.contextPath}/views/js/creditcard.js"></script>
</body>
</html>
