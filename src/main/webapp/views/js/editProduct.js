$(document).ready(function () {
    // let productId=document.getElementById('param').getAttribute('value');
    // let p=$('#param').text();
    let productId = $('#param')[0].innerHTML;

    $.get("admin/editproduct?productId=" + productId, ajaxCallBack);

    function ajaxCallBack(responseTxt, statusTxt, xhr) {
        if (statusTxt == "success") {
            let data = JSON.parse(responseTxt);
            $("#name").val(data.name);
            $("#price").val(data.price);
            $("#quantity").val(data.quantity);
            $("#description").val(data.description);
        }
    }
});

function fileInputOnChange(id) {
    let preview;
    let file;
    if (id == "image1") {
        preview = $("#image1")[0];
        file = $("#HTMLFileChooser1")[0].files[0];
    }

    if (id == "image2") {
        preview = $("#image2")[0];
        file = $("#HTMLFileChooser2")[0].files[0];
    }

    if (id == "image3") {
        preview = $("#image3")[0];
        file = $("#HTMLFileChooser3")[0].files[0];
    }


    let reader = new FileReader();

    reader.addEventListener("load", function () {
        // convert image file to base64 string
        preview.src = reader.result;
    }, false);

    if (file) {
        reader.readAsDataURL(file);
    }

}

function imageLoadingErrorMessage(id) {

    if (id == "image1") {
        $("#image1").attr("src", "views/images/product.png");
        $("#modal-title")[0].innerHTML = "Image1 upload error";
    }

    if (id == "image2") {
        $("#image2").attr("src", "views/images/product.png");
        $("#modal-title")[0].innerHTML = "Image2 upload error";
    }

    if (id == "image3") {
        $("#image3").attr("src", "views/images/product.png");
        $("#modal-title")[0].innerHTML = "Image3 upload error";
    }

    $("#modal-message")[0].innerHTML = "Please choose an image with a valid format.";
    $('#modal').modal('show');

}


function validateName() {
    let productName = $("#name").val();
    if (productName.trim().length == 0) {
        $("#name").removeClass("is-valid");
        $("#name").addClass("is-invalid");
        isValid = false;
    } else {
        $("#name").removeClass("is-invalid");
        $("#name").addClass("is-valid");
        isValid = true;
    }
}

function validatePrice() {
    let productPrice = $("#price").val();
    if (productPrice <= 0) {
        $("#price").removeClass("is-valid");
        $("#price").addClass("is-invalid");
        isValid = false;
    } else {
        $("#price").removeClass("is-invalid");
        $("#price").addClass("is-valid");
        isValid = true;
    }
}

function validateQuantity() {
    let productQuantity = $("#quantity").val();
    if (productQuantity <= 0) {
        $("#quantity").removeClass("is-valid");
        $("#quantity").addClass("is-invalid");
        isValid = false;
    } else {
        $("#quantity").removeClass("is-invalid");
        $("#quantity").addClass("is-valid");
        isValid = true;
    }
}

