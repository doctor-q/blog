$("#btn-submit-comment").click(function () {
    $.ajax({
        url: '/comment/add',
        data: {
            commentType: 1,
            commentRefId: $("[name='id']").val(),
            comment: $("[name='comment']").val()
        },
        success: function (res) {
            console.log(res);
            window.location.reload();
        }
    })
});