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
    <script src="https://cdn.jsdelivr.net/npm/bs-custom-file-input/dist/bs-custom-file-input.js"></script>


    <title>User Cart</title>

    <link href="../views/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="../views/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="../views/css/usercart.css" rel="stylesheet" type="text/css">

</head>
<body>
<jsp:include page="nav.jsp"/>
<h1>Shopping Cart</h1><br/>
<hr/>

<%--shopping cart--%>
<div class="shopping-cart">

    <%--    column lables for the items --%>
    <div class="column-labels">
        <label class="product-image">Image</label>
        <label class="product-details">Product</label>
        <label class="product-price">Price</label>
        <label class="product-quantity">Quantity</label>
        <label class="product-removal">Remove</label>
        <label class="product-line-price">Total</label>
    </div>


    <%--    iterating over the comming userproductcart--%>
    <c:forEach items="${requestScope.userProductCart}" var="userCart">
        <div class="product">
            <div class="product-image">
                    <%--                <img src="${userCart.product.productImages[0]}">--%>
                <img src="images/nike.jpg">
            </div>
            <div class="product-details">
                <div class="product-title">${userCart.product.name}</div>
                <p class="product-description">${userCart.product.description}</p>
            </div>
            <div class="product-price">${userCart.product.price}</div>
            <div class="product-quantity">
                <input type="number" value="1" min="1">
            </div>
            <div class="product-removal">
                <button class="remove-product">
                    Remove
                </button>
            </div>
            <div class="product-line-price">${userCart.product.price}</div>
        </div>

    </c:forEach>

    <%--    total of the bill --%>
    <div class="totals">
        <div class="totals-item">
            <label>Subtotal</label>
            <div class="totals-value" id="cart-subtotal">71.97</div>
        </div>
        <div class="totals-item">
            <label>Tax (5%)</label>
            <div class="totals-value" id="cart-tax">3.60</div>
        </div>
        <div class="totals-item">
            <label>Shipping</label>
            <div class="totals-value" id="cart-shipping">15.00</div>
        </div>
        <div class="totals-item totals-item-total">
            <label>Grand Total</label>
            <div class="totals-value" id="cart-total">90.57</div>
        </div>
    </div>

    <button class="checkout">Checkout</button>

</div>

<%--importing script lib--%>

<script src="../views/js/libs/jquery.min.js"></script>
<script src="../views/js/libs/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../views/js/libs/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../views/js/libs/sb-admin-2.min.js"></script>

<script src="../views/js/usercart.js"></script>

</body>
</html>