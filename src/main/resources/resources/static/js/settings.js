$("#btn-blogger-info").click(function () {
    $.ajax({
        url: '/updateBloggerInfo',
        type: 'post',
        data: formValues($("#form-blogger-info")),
        success: function (res) {
            if (res.success) {
                console.log(res);
            }
            console.log(res);
        }
    });
});

$("#btn-contact").click(function () {
    $.ajax({
        url: '/updateContacts',
        type: 'post',
        data: formValues($("#form-contact")),
        success: function (res) {
            if (res.success) {
                console.log(res);
            }
            console.log(res);
        }
    });
});

function attention(bloggerId, blogger) {
    $.ajax({
        url: '/attention',
        type: 'post',
        data: {
            bloggerId: bloggerId,
            blogger: blogger
        },
        success: function (res) {
            if (res.success) {
                console.log(res);
            }
            console.log(res);
        }
    });
}

function unAttention(bloggerId, blogger) {
    $.ajax({
        url: '/unAttention',
        type: 'post',
        data: {
            bloggerId: bloggerId,
            blogger: blogger
        },
        success: function (res) {
            if (res.success) {
                console.log(res);
            }
            console.log(res);
        }
    });
}