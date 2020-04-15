<%--
  Created by IntelliJ IDEA.
  User: Reham Aboelyazied
  Date: 4/9/2020
  Time: 8:04 PM
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
    <script src="https://cdn.jsdelivr.net/npm/bs-custom-file-input/dist/bs-custom-file-input.js"></script>

    <script src="views/js/newProduct.js"></script>
    <title>add new product </title>


    <link href="views/css/all.min.css" rel="stylesheet" type="text/css">

    <link href="views/css/sb-admin-2.min.css" rel="stylesheet">

</head>


<style>
    .bg-login-image {
        background-image: none;
    }

    #productImage {
        width: 100%;
        height: 90%;
        margin:2em;
    }
    .custom-file{
        margin-bottom: 7px;
    }

</style>

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
                            <div id="productImgDiv" class="col-lg-6 d-none d-lg-block bg-login-image">
                                <img id="productImage" src="images/lock1.png">

                            </div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Add new Product</h1>
                                    </div>
                                    <div id="error" class="alert alert-danger d-none" role="alert">
                                       please fill all fields and set different images!
                                    </div>
                                    <form class="user" method="post" action="newProduct" onsubmit="return validateForm()" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <input class="form-control " multiple
                                                   id="name" name="name" placeholder="product name" type="text" required
                                                   onchange="validateName()">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control " multiple
                                                   id="price" name="price" placeholder="price" type="number" required
                                                   onchange="validatePrice()">
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control "
                                                   id="quantity" name="quantity" placeholder="quantity" type="number"
                                                   required onchange="validateQuantity()">
                                        </div>

                                        <div class="form-group">
                                            <select class="custom-select my-1 mr-sm-2 is-valid"
                                                    id="inlineFormCustomSelectPref"
                                                    name="category" required>
                                                <!--<option value="" disabled selected hidden>others</option>-->
                                                <option value="others" selected>others</option>
                                                <c:forEach items="${requestScope.categories}" var="iterator">
                                                    <option value="${iterator.id}">${iterator.name}</option>

                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="custom-file">
                                            <input type="file" class="custom-file-input form-control " id="imgInp"
                                                   accept="image/*"
                                                   onchange="readURL(this)" name="productImage" text-truncate>
                                            <label class="custom-file-label" id="imageLabel" for="imgInp">Choose Primary
                                                Image</label>
                                        </div>

                                        <div class="custom-file">
                                            <input type="file" class="custom-file-input form-control " id="imgInp2"
                                                   accept="image/*" onchange="validateImage2()"
                                                   name="productImage2" text-truncate>
                                            <label class="custom-file-label" id="imageLabel2" for="imgInp2">Choose
                                                Image</label>
                                        </div>
                                        <div class="custom-file">
                                            <input type="file" class="custom-file-input form-control " id="imgInp3"
                                                   accept="image/*" onchange="validateImage3()"
                                                   name="productImage3" text-truncate>
                                            <label class="custom-file-label" id="imageLabel3" for="imgInp2">Choose
                                                Image</label>
                                        </div>
                                        <p id="imageswarning"></p>

                                        <div class="form-group">

                                        <textarea class="form-control " id="Textarea" rows="3"
                                                  placeholder="description.." style="margin-top: 8px"
                                                  name="description"></textarea>
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-block btn-user">Submit</button>
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
