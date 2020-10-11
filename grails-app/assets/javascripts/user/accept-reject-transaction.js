
$(document).ready(function () {
    $(document).on("click", "#accept", function () {
        $.ajax({
            method: "POST",
            url: $("#acceptUrl").val(),
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
    $(document).on("click", "#reject", function () {
        $.ajax({
            method: "POST",
            url: $("#rejectUrl").val(),
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