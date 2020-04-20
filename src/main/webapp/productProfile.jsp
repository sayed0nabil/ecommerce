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

        .productImages {
            margin: 20px auto;
        }

        .productImage {
            max-width: 75px;
            margin-right: 5px;
            margin-left: 8px;
        }

        .productPrimaryImage {
            max-width: 100%;
        }
    </style>
    <script>
        function changeImage(img) {
            document.getElementById("chosenImage").src = img.src;
        }
    </script>
</head>
<body>

<header>
    <jsp:include page="nav.jsp"/>
</header>

<div class="container">
    <section class="productProfile">
        <div class="row">
            <div class="col-md-5 col-sm-12">

                <img style="width:23rem;height:23rem;"
                     src="${pageContext.request.contextPath}/productImages?productID=${requestScope.product.id}&imageNumber=1"
                     class="mt-2 ml-4 productPrimaryImage shadow-lg" id="chosenImage">
            </div>
            <div class="col-md-7 col-sm-12 border-left-primary">
                <div class="productDetails ">
                    <h2>${requestScope.product.name}</h2>
                    <span class="productPrice"><b>${requestScope.product.price} EGP</b></span>
                    <hr/>
                    <span style="font-size: 18px"><b>Description</b></span>

                    <p>${requestScope.product.description}</p>
                    <div class=" productImages">
                        <c:forEach begin="1" end="3" var="iterator">
                            <img src="${pageContext.request.contextPath}/productImages?productID=${requestScope.product.id}&imageNumber=${iterator}"
                                 class="productImage shadow-lg" onclick="changeImage(this)">

                        </c:forEach>
                    </div>

                    <label>Qty</label>
                    <form method="post" action="productprofile">



                        <input name="productId" type="hidden" value="${requestScope.product.id}"/>

                        <c:choose>
                            <c:when test="${!empty sessionScope.mine && sessionScope.mine.admin != 1}">
                                <select name="quantity" class="custom-select my-1 mr-sm-2">
                                    <option value="1" selected>1</option>
                                    <c:forEach var="i" begin="2" end="${requestScope.product.quantity}">
                                        <option value="${i}">${i}</option>
                                    </c:forEach>
                                </select>
                                <input type="submit" name="" value="Add to cart" class="btn btn-primary "/>
                            </c:when>
                            <c:otherwise>
                                <p>${requestScope.product.quantity}</p>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </div>

            </div>
        </div>

    </section>
</div>
</body>
</html>
