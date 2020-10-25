$(document).ready(function () {
    $(document).on("click", "#transfer", function () {
        let checked = $("input[type=radio][name=accountID]:checked").val()
        debugger
        console.log(checked)
        $.ajax({
            method: "POST",
            url: $("#createTransactionUrl").val(),
            data: {
                reciver: checked,
                accountNumber:$("#hiddenAccountNumber").val(),
                amount: $("#amount").val(),
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

    $(document).on("click", "#searchAccount", function () {
        $.ajax({
            method: "GET",
            url: $("#SearchUserByAccount").val(),
            data: {
                accountNumber: $("#accountNumber").val(),
                userId: $("#userId").val(),
            },
            success: function (response) {
                $("#content").html(response)
            },
            error: function (response) {
                console.log(response)
            },

        })
    })

});