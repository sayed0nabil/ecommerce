var isValid = true;

var imageNo;

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
        imageNo = 1;
    }
}

function validateName() {
    var productName = $("#name").val();
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
    var productPrice = $("#price").val();
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
    var productQuantity = $("#quantity").val();
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

function validateForm() {
    validateImagesNames();
    if (!isValid) {
        $("#error").removeClass("d-none");
        return false;
    }
}
function validateImagesNames(){
    var image1Name = $("#imgInp").val();
    var image2Name = $("#imgInp2").val();
    var image3Name = $("#imgInp3").val();
    if(image1Name == image2Name || image1Name== image3Name || image2Name == image3Name){
        document.getElementById("imageswarning").val = "choose different images"
        isValid = false;
    }
}
function validateImage2() {
    imageNo = 2;
}
function validateImage3() {
    imageNo = 3;
}

$().ready(function () {
    $('[type="file"]').change(function () {
        var fileInput = $(this);
        if (fileInput.length && fileInput[0].files && fileInput[0].files.length) {
            var url = window.URL || window.webkitURL;
            var image = new Image();
            image.onload = function () {
                if (imageNo == 1) {
                    $("#imgInp").removeClass("is-invalid");
                    $("#imgInp").addClass("is-valid");
                    isValid = true;
                } else if (imageNo == 2) {
                    $("#imgInp2").removeClass("is-invalid");
                    $("#imgInp2").addClass("is-valid");
                    isValid = true;
                }else if(imageNo == 3) {
                    $("#imgInp3").removeClass("is-invalid");
                    $("#imgInp3").addClass("is-valid");
                    isValid = true;

            };
            image.onerror = function () {
                if (imageNo == 1) {
                    $("#imgInp").removeClass("is-valid");
                    $("#imgInp").addClass("is-invalid");
                    isValid = false;
                } else if (imageNo == 2) {
                    $("#imgInp2").removeClass("is-valid");
                    $("#imgInp2").addClass("is-invalid");
                    isValid = false;
                }else if(imageNo == 3){
                    $("#imgInp3").removeClass("is-valid");
                    $("#imgInp3").addClass("is-invalid");
                    isValid = false;
                }
            }

            };
            image.src = url.createObjectURL(fileInput[0].files[0]);
        }
    });
});
$(document).ready(function () {
    bsCustomFileInput.init()
})
