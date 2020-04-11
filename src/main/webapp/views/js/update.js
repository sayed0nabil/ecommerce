$(document).ready(function () {
    // function getUserId(responseTxt, statusTxt, xhr){
    //     if (statusTxt== "success"){
    //         if(!responseTxt == ""){
    //             let data = JSON.parse(responseTxt);
    //             let userId = data.userid;
    //           //  $.get("updateProfile", ajaxCallBack);
    //         }
    //     }
    // }
    //
    // $.get("mine", getUserId);
    $.get("updateProfile", ajaxCallBack);

    function ajaxCallBack(responseTxt, statusTxt, xhr) {
        if (statusTxt == "success") {
            let data = JSON.parse(responseTxt);
            $("#firstname").val("alaa");
            $("#lastname").val("albadry");
            $("#email").val("a@g.com");
            $("#birthdate").val("2020-4-12");
            $("#creditlimit").val("500");
            $.get("uploadPhoto", getUserImage);
        }
    }

    function getUserImage(responseTxt, statusTxt, xhr) {
        if (statusTxt == "success") {
            if (!responseTxt == undefined) {
                var preview = $("#UserImage")[0];
                preview.src = responseTxt;
            }
        }
    }


});


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
