<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit-Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/products.css"/>

    <%-- Custom script for editProduct  --%>
    <script src="${pageContext.request.contextPath}/views/js/libs/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/views/js/editProduct.js"></script>


</head>
<body>
<header>
    <jsp:include page="nav.jsp"/>
</header>
<div id="param" class="d-none" value="${param.productid}">${param.productid}</div>
<div class="card o-hidden border-0 shadow-lg my-5">
    <form class="user" method="post" action="${pageContext.request.contextPath}/admin/editproduct2" onsubmit="" enctype="multipart/form-data">

        <input name="productId" class="d-none" type="text" value="${param.productid}"/>
        <div class="modal" id="modal" role="dialog" tabindex="-1">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modal-title">Image upload error</h5>
                        <button aria-label="Close" class="close" data-dismiss="modal" type="button">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p id="modal-message">Please choose an image with a valid format.</p>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" data-dismiss="modal" type="button">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-lg-3 mb-2">
                <div class="card bg-primary text-white shadow">
                    <div class="card-body">
                        <div class="product-image">
                            <img class="img-fluid px-3 px-sm-4 mt-3 mb-2" style="width: 25rem;height:16rem;"
                                 src="${pageContext.request.contextPath}/productImages?productID=${param.productid}&imageNumber=1"
                                 id="image1"
                                 onerror="imageLoadingErrorMessage('image1')"
                                 alt="Card image cap">
                            <input name="image_name1" accept="image/*" class="d-none"
                                   id="HTMLFileChooser1" onchange="fileInputOnChange('image1')" type="file"
                                   value="Upload"/>
                            <div class="product-cover"></div>
                            <button class="btn btn-primary inner-view-details"
                                    onclick="event.preventDefault();$('#HTMLFileChooser1').trigger('click')">Upload
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 mb-2">
                <div class="card bg-primary text-white shadow">
                    <div class="card-body">
                        <div class="product-image">
                            <img class="img-fluid px-3 px-sm-4 mt-3 mb-2" style="width: 25rem;height:16rem;"
                                 src="${pageContext.request.contextPath}/productImages?productID=${param.productid}&imageNumber=2"
                                 id="image2"
                                 onerror="imageLoadingErrorMessage('image2')"
                                 alt="Card image cap">
                            <input name="image_name2" accept="image/*" class="d-none"
                                   id="HTMLFileChooser2" onchange="fileInputOnChange('image2')" type="file"
                                   value="Upload"/>
                            <div class="product-cover"></div>
                            <button class="btn btn-primary inner-view-details"
                                    onclick="event.preventDefault();$('#HTMLFileChooser2').trigger('click')">Upload
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 mb-2">
                <div class="card bg-primary text-white shadow">
                    <div class="card-body">
                        <div class="product-image">
                            <img class="img-fluid px-3 px-sm-4 mt-3 mb-2" style="width: 25rem;height:16rem;"
                                 src="${pageContext.request.contextPath}/productImages?productID=${param.productid}&imageNumber=3"
                                 id="image3"
                                 onerror="imageLoadingErrorMessage('image3')"
                                 alt="Card image cap">
                            <input name="image_name3" accept="image/*" class="d-none"
                                   id="HTMLFileChooser3" onchange="fileInputOnChange('image3')" type="file"
                                   value="Upload"/>
                            <div class="product-cover"></div>
                            <button class="btn btn-primary inner-view-details"
                                    onclick="event.preventDefault();$('#HTMLFileChooser3').trigger('click')">Upload
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        <div class="row justify-content-center">
            <div class="col-lg-7">
                <div class="p-5">
                    <div class="text-center">
                        <h1 class="h4 text-gray-900 mb-4">Edit Product!</h1>
                    </div>
                    <div class="form-group">
                        <input class="form-control " multiple
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

                    <hr>
                    <div class="form-group">

                                        <textarea class="form-control " id="description" rows="3"
                                                  placeholder="description.." style="margin-top: 8px"
                                                  name="description"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block btn-user">Submit</button>

                </div>

            </div>
        </div>
    </form>
</div>
<%--    </div>--%>
<%--</div>--%>


<%--<div class="row">--%>
<%--<!-- primary Image -->--%>
<%--<div class="card shadow mb-4">--%>
<%--    <div class="card-header py-3">--%>
<%--        <h6 class="m-0 font-weight-bold text-primary">Primary Image</h6>--%>
<%--    </div>--%>
<%--    <div class="card-body">--%>
<%--        --%>
<%--        <div class="text-center">--%>
<%--            <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;" src="images/lock1.png" alt="">--%>
<%--        </div>--%>
<%--        <div class="text-center">--%>
<%--            <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;" src="images/lock1.png" alt="">--%>
<%--        </div>--%>
<%--    </div>--%>

<%--</div>--%>
<%--</div>--%>
</body>
</html>
<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/views/js/libs/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/views/js/libs/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/views/js/libs/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/views/js/libs/sb-admin-2.min.js"></script>

<%--<!-- Page level plugins -->--%>
<%--<script src="vendor/chart.js/Chart.min.js"></script>--%>

<%--<!-- Page level custom scripts -->--%>
<%--<script src="js/demo/chart-area-demo.js"></script>--%>
<%--<script src="js/demo/chart-pie-demo.js"></script>--%>