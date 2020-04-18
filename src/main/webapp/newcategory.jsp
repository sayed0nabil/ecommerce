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
    <script src="views/js/libs/jquery-3.4.1.min.js"></script>
    <title>add new category </title>

    <!-- Custom fonts for this template-->
    <link href="views/css/all.min.css" rel="stylesheet" type="text/css">
    <!--    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">-->

    <!-- Custom styles for this template-->
    <link href="views/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<script>

</script>

<body class="bg-gradient-primary">
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


                                        <!-- <div id="error" class="alert alert-danger d-none" role="alert">
                                             Email or Password is incorrect
                                         </div>-->
                                    </div>
                                    <form action="/ecommerce/addcategory" method="post"
                                          class="form-inline justify-content-center user">
                                        <input type="text" required="" name="category_name" id="category-name"
                                               placeholder="Enter Catgory name"
                                               class="form-control mx-sm-3 mb-2 form-control-user">
                                        <button type="submit" id="submitBtn"
                                                style="font-size: 1.1rem;line-height: 1.2;font-weight: 400;"
                                                class="btn btn-primary btn-user  text-white mb-2">Add Category<img
                                                id="loading" src="SB%20Admin%202%20-%20Login_files/loading.gif"
                                                class="d-none" alt="Loading" width="20" height="20"></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Bootstrap core JavaScript-->
<script src="views/js/libs/jquery.min.js"></script>
<script src="views/js/libs/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="views/js/libs/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="views/js/libs/sb-admin-2.min.js"></script>

</body>
</html>
