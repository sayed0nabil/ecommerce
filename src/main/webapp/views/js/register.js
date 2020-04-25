function checkPasswordMatch() {

    if ($("#InputPassword")[0].value == $("#RepeatPassword")[0].value) {

        return true;

    } else {

        $("#RepeatPassword")[0].style.border = "red solid 2px";
        $("#RepeatPassword").attr("placeholder", "Passwords don't match");
        $("#RepeatPassword")[0].value = "";
        return false

    }
}

function onSubmit() {

    $("#submit").prop("disabled", true);
    var isValid = (checkPasswordMatch() && checkEmailDuplicate($("#Email")[0].value));
    $("#submit").prop("disabled", false);

    return isValid;

}

function checkEmailDuplicate(email) {

    var responseText = $.ajax({
        type: "GET",
        url: "emailChecker?email=" + email,
        async: false
    }).responseText;

    if (responseText == "true") {

        $("#Email")[0].style.border = "red solid 2px";
        $("#modal-title")[0].innerHTML = "Account already registered";
        $("#modal-message")[0].innerHTML = "Sorry, but your account is already registered";
        $('#modal').modal('show');

    }

    return responseText == "true" ? false : true;

}

function fileInputOnChange() {

    var preview = $("#UserImage")[0];
    var file = $("#HTMLFileChooser")[0].files[0];
    var reader = new FileReader();

    reader.addEventListener("load", function () {
        // convert image file to base64 string
        preview.src = reader.result;
    }, false);

    if (file) {
        reader.readAsDataURL(file);
    }

}

function imageLoadingErrorMessage(event) {

    $("#UserImage").attr("src", "views/images/user.png");
    $("#modal-title").innerHTML = "Image upload error";
    $("#modal-message").innerHTML = "Please choose an image with a valid format.";
    $('#modal').modal('show');
    $("#HTMLFileChooser").replaceWith($("#HTMLFileChooser").val('').clone(true));

}
