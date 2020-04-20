



function addCreditCard(contextpath){
    const code = $("#code").val();
    const limit = $("#limit").val();
    console.log("Code: " + code);
    console.log("Limit: " + limit);
    if(code.trim().length == 0){
        $("#code-error").text("Code field Is required");
        $("#limit-error").text("");
    }
    else if(limit.trim().length == 0){
        $("#code-error").text("");
        $("#limit-error").text("Limit field Is required");
    }
    else{
        $("#code-error").text("");
        $("#limit-error").text("");
        $.post(contextpath + "/admin/addcredit", {
            code: code,
            limit: limit
        }, function (responseTxt, statusTxt) {
            if(statusTxt == "success"){
                if(responseTxt == "success"){
                    $("#code-error").text("");
                    $("#limit-error").text("");
                    const newRow = $("<tr class='table-primary'></tr>");
                    const codeCol = $("<td></td>").text(code);
                    const limitcol = $("<td colspan='2'></td>").text(limit);
                    newRow.append(codeCol).append(limitcol)
                    $("#credits-body").append(newRow);
                }else{
                    $("#code-error").text(responseTxt);
                }
            }
        })
    }
}