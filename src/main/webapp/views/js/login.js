function ajaxCallBack(responseTxt, statusTxt, xhr) {
    if (statusTxt == "success") {
        let data = JSON.parse(responseTxt);
        if(typeof data.error === "undefined")
            window.location.replace("http://localhost:9090/ecommerce/main");
        else 
            $("#error").removeClass("d-none");
    }
    $("#loading").addClass("d-none");
    $("#submitBtn").prop("disabled", false);
}


function validateData() {
    $(".error").hide();
    let hasError = false;
    let emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;

    let emailaddressVal = $("#email").val();
    let passwordVal = $("#password").val();

    if (emailaddressVal == '') {
        $("#email").after('<p style="color:red;font-weight:bold;font-size:12px; padding-left: 10px; padding-top: 2px;" class="error">Please enter your email address.</p>');
        hasError = true;
    } else if (!emailReg.test(emailaddressVal)) {
        $("#email").after('<p style="color:red;font-weight:bold;font-size:12px; padding-left: 10px; padding-top: 2px;" class="error">Enter a valid email address.</p>');
        hasError = true;
    }
    if (passwordVal == '') {
        $("#password").after('<p style="color:red;font-weight:bold;font-size:12px; padding-left: 10px; padding-top: 2px;" class="error">Please enter your password.</p>');
        hasError = true;
    }

    if (hasError == true) {
        return false;
    }
    return true;
}

$(document).ready(function () {

    $("#submitBtn").click(function () {
        $("#error").addClass("d-none");
        if (validateData()) {
            $("#loading").removeClass("d-none");
            $(this).prop("disabled", true);
            let email = $("#email").val();
            let password = $("#password").val();
            //let jsonData = {"email": email, "password": password}
            $.post("LoginServlet",
                {"email": email, "password": password}
                , ajaxCallBack);
        }

    });
});