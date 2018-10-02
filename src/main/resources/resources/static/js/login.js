$("#btn-login").click(function () {
    $.ajax({
        url: '/doLogin',
        data: formValues($("#form-login")),
        success: function (res) {
            if (res.success) {
                $.cookie('accessToken', res.data);
                window.location.href = '/';
            } else {
                console.log(res);
            }
        }
    });
});

$("#btn-register").click(function () {
    $.ajax({
        url: '/signUp',
        data: formValues($("#form-register")),
        success: function (res) {
            if (res.success) {
                window.location.href = '/login';
            }
        }
    });
});