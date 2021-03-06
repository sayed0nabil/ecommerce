

$(function(){
    console.log("Get In Ready State")
    $("#searchInput").on("keyup", function () {
        const keyword = $(this).val().toLowerCase();
        search(keyword);
    }).on("blur", function () {
        setTimeout(function () {
            $("#myList").empty();
        }, 200)
    }).on("focus", function () {
        const keyword = $(this).val().toLowerCase();
        search(keyword);
    })

    function search(keyword) {
        $("#myList").empty();
        $("#myList").empty();
        $("#myList").empty();
        $("#myList").empty();
        if(keyword.trim().length > 0){
            $.get("http://localhost:9090/ecommerce_war/search?keyword=" + keyword + "&limit=10", function (data) {
                console.log(data);
                const result = JSON.parse(data);
                for(const item of result){
                    const link = $("<a></a>").attr("href", "http://localhost:9090/ecommerce_war/productprofile?productId=" + item.id).text(item.name);
                    const li = $("<li></li>").addClass("list-group-item").append(link);
                    $("#myList").append(li);
                }
            });
        }
    }
})