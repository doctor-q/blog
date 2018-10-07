$("#btn-save").click(function () {
    postBlog(0);
});

$("#btn-publish").click(function () {
    postBlog(1);
});

function postBlog(status) {
    var data = formValues($("#form-blog"));
    data['status'] = status;
    data['content'] = $("#blog-content").html();
    $.ajax({
        url: '/blog/post',
        type: 'post',
        data: data,
        success: function (res) {

        }
    });
}

$(document).ready(function(){
    var href = window.location.href;
    var reg = /\d$/;
    if (reg.test(href)) {
        var id = reg.exec(href);
        $.ajax({
            url: '/blog/detail/' + id,
            success: function (res) {
                if (res.success) {
                    var data = res.data;
                    setFormValues($("#form-blog"), data);
                    $("#blog-content").html(data.content)
                }
            }
        });
    }
});