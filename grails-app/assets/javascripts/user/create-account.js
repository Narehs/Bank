$(document).ready(function () {
    $(document).on("click", "#createAccount", function () {
        $.ajax({
            method: "POST",
            url: $("#createAccountUrl").val(),
            data: {
                id:$("#userId").val(),
            },
            success: function () {
                window.location.reload();
            },
            error: function (response) {
                console.log(response)
            },

        })
    })
});