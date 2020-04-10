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

    return checkPasswordMatch();

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
    $('#modal').modal('show');

}
