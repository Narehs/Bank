$(document).ready(function () {
    $(document).on("click", "#send", function () {
        $.ajax({
            method: "POST",
            url: $("#createTransactionUrl").val(),
            data: {
                email: $("#users option:selected").val(),
                amount: $("#amount").val()
            },
            success: function () {
                window.location.reload();
            },
            error: function (response) {
                console.log(response)
            },

        })
    })

    $(document).on("click", "#withdraw", function () {
        $.ajax({
            method: "POST",
            url: $("#withdrawTransactionUrl").val(),
            data: {
                id: $(this).parent('td').attr('data-id'),
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