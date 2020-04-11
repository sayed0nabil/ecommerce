<%--
  Created by IntelliJ IDEA.
  User: Reham Aboelyazied
  Date: 4/10/2020
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>product profile </title>
    <meta charset="utf-8">
    <script src="views/js/libs/jquery-3.4.1.min.js"></script>

    <link href="views/css/all.min.css" rel="stylesheet" type="text/css">

    <link href="views/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .productProfile {
            padding: 20px;
            background-color: #ffffff;
        }

        .productProfile .custom-select {
            width: auto;

        }

        .productProfile .productPrice {
            font-size: 28px;
        }

        .productImage {
            max-width: 100%;
        }

        .productProfile .productDetails {
            margin-left: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <section class="productProfile">
        <div class="row">
            <div class="col-md-4 col-sm-12">
                <c:forEach items="${requestScope.product.productImages}" var="iterator">
                    <img src="http://localhost:8989/ecommerce_war/productImages?image=${iterator.id.url}"
                         class="productImage">
                </c:forEach>
            </div>
            <div class="col-md-8 col-sm-12 border-left-primary">
                <div class="productDetails ">
                    <h2>${requestScope.product.name}</h2>
                    <span class="productPrice"><b>${requestScope.product.price} EGP</b></span>
                    <hr/>
                    <span style="font-size: 18px"><b>Description</b></span>

                    <p>${requestScope.product.description}</p>

                    <label>Qty</label>
                    <select class="custom-select my-1 mr-sm-2">
                        <option value="1" selected>1</option>
                        <c:forEach var="i" begin="2" end="${requestScope.product.quantity}">
                            <option value="2">${i}</option>
                        </c:forEach>

                    </select>
                    <button class="btn btn-primary ">Add to cart</button>
                </div>

            </div>
        </div>

    </section>
</div>
</body>
</html>
