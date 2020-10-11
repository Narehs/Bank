(function ($) {
    $('.login-page-content, .validate-page-content').on('click', '.icon-eye', function (e) {
        e.stopPropagation();

        var input = $(this).parents('.input-field-wrap').find('input');

        $(this).toggleClass('active');

        if($(this).hasClass('active')) {
            input.attr('type', 'text');
        }else {
            input.attr('type', 'password');
        }
    });
})(jQuery);