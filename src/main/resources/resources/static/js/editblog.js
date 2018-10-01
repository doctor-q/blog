var url = window.location.href.split('/');
var id = url[url.length - 1];
console.log('request blog ' + id);
$.ajax({
    url: '/blog/detail/' + id,
    success: function (res) {

    }
});