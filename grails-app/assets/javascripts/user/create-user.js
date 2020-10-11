$(document).ready(function () {
    $(document).on("click", "#create", function () {
        $.ajax({
            method: "POST",
            url: $("#createUserUrl").val(),
            data: {
                email:$("#email").val(),
                password:$("#password").val(),
            },
            success: function () {
                window.location.href = '/admin/index';
            },
            error: function (response) {
                console.log(response)
            },

        })
    })
});