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
    <title>add new product </title>

    <!-- Custom fonts for this template-->
    <link href="views/css/all.min.css" rel="stylesheet" type="text/css">
    <!--    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">-->

    <!-- Custom styles for this template-->
    <link href="views/css/sb-admin-2.min.css" rel="stylesheet">

</head>
<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#productImage').remove();
                $('#productImgDiv').prepend($('<img>', {id: 'productImage', src: '#'}));
                $('#imageLabel').text(input.files[0].name);
                $('#productImage').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]); // convert to base64 string
        }
    }

    function validateName() {
        var productName = $("#name").val();
        if (productName.trim().length == 0) {
            $("#name").removeClass("is-valid");
            $("#name").addClass("is-invalid");
        } else {
            $("#name").removeClass("is-invalid");
            $("#name").addClass("is-valid");
        }
    }

    function validatePrice() {
        var productPrice = $("#price").val();
        if (productPrice <= 0) {
            $("#price").removeClass("is-valid");
            $("#price").addClass("is-invalid");
        } else {
            $("#price").removeClass("is-invalid");
            $("#price").addClass("is-valid");
        }
    }

    function validateQuantity() {
        var productQuantity = $("#quantity").val();
        if (productQuantity <= 0) {
            $("#quantity").removeClass("is-valid");
            $("#quantity").addClass("is-invalid");
        } else {
            $("#quantity").removeClass("is-invalid");
            $("#quantity").addClass("is-valid");
        }
    }

    $().ready(function () {
        $('[type="file"]').change(function () {
            var fileInput = $(this);
            if (fileInput.length && fileInput[0].files && fileInput[0].files.length) {
                var url = window.URL || window.webkitURL;
                var image = new Image();
                image.onload = function () {
                    $("#imgInp").removeClass("is-invalid");
                    $("#imgInp").addClass("is-valid");
                };
                image.onerror = function () {

                    $("#imgInp").removeClass("is-valid");
                    $("#imgInp").addClass("is-invalid");
                };
                image.src = url.createObjectURL(fileInput[0].files[0]);
            }
        });
    });

</script>
<style>
    .bg-login-image {
        background-image: none;
    }

    #productImage {
        width: 100%;
        height: 90%;
        margin-top: 5px;
        margin-bottom: 5px;
    }

</style>

<body class="bg-gradient-primary">

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
                                <form class="user" method="post">
                                    <div class="form-group">
                                        <input class="form-control "
                                               id="name" name="name" placeholder="product name" type="text" required
                                               onchange="validateName()">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control "
                                               id="price" name="price" placeholder="price" type="number" required
                                               onchange="validatePrice()">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control "
                                               id="quantity" name="quantity" placeholder="quantity" type="number"
                                               required onchange="validateQuantity()">
                                    </div>

                                    <div class="form-group">
                                        <select class="custom-select my-1 mr-sm-2 is-valid" id="inlineFormCustomSelectPref"
                                                name="category" required >
                                            <!--<option value="" disabled selected hidden>others</option>-->
                                            <option value="others">others</option>
                                            <c:forEach items="${requestScope.categories}" var="iterator">
                                                <option value="${iterator.id}">${iterator.name}</option>

                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="custom-file">
                                        <input type="file" class="custom-file-input form-control " id="imgInp"
                                               accept="image/*"
                                               onchange="readURL(this)">
                                        <label class="custom-file-label" id="imageLabel" for="imgInp">Choose
                                            Image</label>
                                    </div>

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

<!-- Bootstrap core JavaScript-->
<script src="views/js/libs/jquery.min.js"></script>
<script src="views/js/libs/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="views/js/libs/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="views/js/libs/sb-admin-2.min.js"></script>

</body>
</html>
