$(document).ready(function () {
    $(document).on("click", "#changeAccBalance", function () {
        $.ajax({
            method: "POST",
            url: $("#chargeBalanceUrl").val(),
            data: {
                amount:$("#amount").val(),
                accountNumber:$("#accountNumber").val(),
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