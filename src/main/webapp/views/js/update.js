$(document).ready(function () {

    $.get("../userProfile", ajaxCallBack);

    function ajaxCallBack(responseTxt, statusTxt, xhr) {
        if (statusTxt == "success") {
            let data = JSON.parse(responseTxt);
            $("#FirstName").val(data.firstName);
            $("#LastName").val(data.lastName);
            $("#Email").val(data.email);
            $("#BirthDate").val(data.birthDate);
            $("#User_limit").val(data.creditLimit)
            // $.get("/images/users", getUserImage);
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

    $("#ceditBtn").click(function () {
        let creditlimit = $("#creditlimit").val();
        $.post("../CreditLimitServlet", {"creditlimit": creditlimit}, criditLimitStatus);
    });

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
    $("#modal-title").innerHTML = "Image upload error";
    $("#modal-message").innerHTML = "Please choose an image with a valid format.";
    $('#modal').modal('show');

}

function criditLimitStatus(responseTxt, statusTxt, xhr) {
    if (statusTxt == "success") {

        if (responseTxt == "0") {
            $("#modal1-title")[0].innerHTML = "Your Code Not Found";
            $("#modal1-message")[0].innerHTML = "Please Try Again or Call Admin";
        } else if (responseTxt == "1") {
            $("#modal1-title")[0].innerHTML = "Your Code Used Before";
            $("#modal1-message")[0].innerHTML = "Please Call Admin";
        } else if (responseTxt[0] == "2") {
            $("#modal1-title")[0].innerHTML = "Thank you";
            $("#modal1-message")[0].innerHTML = "Your Limit Charged Successfully";
            $("#User_limit").val(parseInt(responseTxt.split(":")[1]) + parseInt($("#User_limit").val()));
            $("#creditlimit").val("");
        }
        $('#modal1').modal('show');
    }

}
