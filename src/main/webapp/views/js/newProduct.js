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
