<%--
  Created by IntelliJ IDEA.
  User: Elnagger
  Date: 4/11/2020
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <meta charset="utf-8">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">
    <meta content="" name="description">
    <meta content="" name="author">
    <title>add new category </title>

<%--    <!-- Custom styles for this template-->--%>
<%--    <link href="${pageContext.request.contextPath}/views/css/sb-admin-2.min.css" rel="stylesheet">--%>

</head>
<body class="bg-gradient-light">
<jsp:include page="nav.jsp"/>

<section>
    <div class="container">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-12">
                                <div class="p-4">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Add Category</h1>
                                    </div>
                                    <form method="post"
                                          class="form-inline justify-content-center user">
                                        <input type="text" required="" name="category_name" id="newcategory"
                                               placeholder="Enter Catgory name"
                                               class="form-control mx-sm-3 mb-2 form-control-user">

                                        <button type="button" id="submitBtn" onclick="addcategory()"
                                                style="font-size: 1.1rem;line-height: 1.2;font-weight: 400;"
                                                class="btn btn-primary btn-user  text-white mb-2">Add Category<img
                                                id="loading" src="SB%20Admin%202%20-%20Login_files/loading.gif"
                                                class="d-none" alt="Loading" width="20" height="20"></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div id="status" class="" role="alert">

                    </div>

                </div>
            </div>
        </div>
    </div>
</section>


<section>
    <table class="table table-hover table-light bg-gradient-light justify-content-center mp-4" id="category-table">
        <thead>
        <tr>
            <th scope="col">Category Name</th>
            <th scope="col">action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.categories}" var="category">
            <tr>
                    <%--                    <th scope="row">${category.id}</th>--%>
                <td>${category.name}</td>
                <c:if test="${category.name != 'others'}">
                <td>
                    <a class="btn btn btn-outline-danger" href="${pageContext.request.contextPath}/admin/removecategory?categoryid=${category.id}"
                    onclick="return confirm('Removing this category will remove all products binded to it \nAre You Sure To Delete It ?') ? true : false ;">Remove</a>
                </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="footer.html"/>
</section>



<!-- Custom scripts for all pages-->
<%--<script src="../views/js/libs/sb-admin-2.min.js"></script>--%>

<script>
    var req = null;

    function addcategory() {
        var categoryName = document.getElementById('newcategory').value;
        console.log(categoryName);
        if (window.XMLHttpRequest)
            req = new XMLHttpRequest();
        else if (window.ActiveXObject)
            req = new ActiveXObject(Microsoft.XMLHTTP);

        req.open("POST", "?t=" + new Date().getTime(), true);
        req.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        req.onreadystatechange = handleReq;
        req.send("category_name=" + categoryName);
    }

    function handleReq() {
        if (req.readyState == 4 && req.status == 200) {
            xmlvalue = req.responseText;
            if (xmlvalue == "Category has been created successfully") {
                $("#status").addClass("alert alert-success w-50 mx-auto text-center");
                document.getElementById('newcategory').innerHTML = "";

                location.reload();

            } else {
                $("#status").addClass("alert alert-danger w-50 mx-auto text-center");
            }
            document.getElementById("status").innerHTML = xmlvalue;
        } else {
            document.getElementById("status").innerHTML = "no response";
        }
    }
</script>

</body>
</html>
