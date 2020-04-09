<%--
  Created by IntelliJ IDEA.
  User: ALaa
  Date: 4/9/2020
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%--         pageEncoding="windows-1256"--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Login Page</title>
</head>
<script>

    function ajaxCallBack(responseTxt, statusTxt, xhr) {
        if (statusTxt == "success") {
            let data = JSON.parse(responseTxt);
            if (data.firstName == undefined) {
                document.getElementById("result").value = data.error;
            } else {
                document.getElementById("result").value = " welcom ya " + data.firstName + " " + data.lastName;
            }
        }
    }

    $(document).ready(function () {
        $("#submitBtn").click(function () {
            let email = $("#email").val();
            let password = $("#password").val();
            //let jsonData = {"email": email, "password": password}
            $.post("LoginServlet",
                {"email": email, "password": password}
                , ajaxCallBack);
        });
    });
</script>


<body>
<form>

    Please enter your email
    <input type="text" id="email" name="email"/><br>

    Please enter your password
    <input type="text" id="password" name="password"/>

    <input type="button" id="submitBtn" value="login"/>
    <input style="color: #007bff" id="result" value="result"/>

</form>
</body>
</html>
