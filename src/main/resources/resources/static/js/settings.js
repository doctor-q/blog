$("#btn-contact").click(function () {
    $.ajax({
        url: '/updateContacts',
        type: 'post',
        data: formValues($("#contact")),
        success: function (res) {
            console.log(res);
        }
    })
});