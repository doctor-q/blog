$("#btn-contact").click(function () {
    $.ajax({
        url: '/updateContacts',
        type: 'post',
        data: formValues($("#contact")),
        success: function (res) {
            if (res.success) {
                console.log(res);
            }
            console.log(res);
        }
    })
});