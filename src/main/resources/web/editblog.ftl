<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑博客</title>
</head>
<body>
<#include 'nav.ftl'>

<div class="main-container">
    <div class="main-content">
        <div class="page-content">
            <div class="page-header">
                <h1>编辑博客</h1>
            </div>
            <div class="col-xs-12">
                <div class="row">
                    <div class="col-xs-12">
                        <span class="header blue">标题</span>
                        <input class="form-control">
                    </div>
                    <div class="col-sm-12">
                        <span class="header blue">内容</span>

                        <div class="widget-box widget-color-green">
                            <div class="widget-header widget-header-small"></div>

                            <div class="widget-body">
                                <div class="widget-main no-padding">
                                    <div class="wysiwyg-editor" id="editor1"></div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="col-xs-12">
                        <span class="header blue">分类</span>
                        <div>
                            <label class="col-xs-3">
                                <input name="form-field-checkbox" type="checkbox">Java
                            </label>
                            <label class="col-xs-3">
                                <input name="form-field-checkbox" type="checkbox">Mysql
                            </label>
                            <label class="col-xs-3">
                                <input name="form-field-checkbox" type="checkbox">操作系统
                            </label>
                            <label class="col-xs-3">
                                <input name="form-field-checkbox" type="checkbox">算法
                            </label>
                        </div>
                    </div>

                    <div class="col-xs-12">
                        <div class="btn-group pull-right">
                            <button class="btn btn-lg btn-info btn-round">
                                <i class="ace-icon fa fa-floppy-o bigger-125"></i>
                                保存草稿
                            </button>

                            <button class="btn btn-lg btn-primary btn-round">
                                <i class="ace-icon fa fa-globe bigger-125"></i>
                                发布
                                <i class="ace-icon fa fa-arrow-right icon-on-right bigger-125"></i>
                            </button>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<script src="/assets/js/jquery.hotkeys.index.min.js"></script>
<script src="/assets/js/bootstrap-wysiwyg.min.js"></script>
<script>
    $('#editor1').ace_wysiwyg({
        toolbar: [
            'font',
            null,
            'fontSize',
            null,
            {name: 'bold', className: 'btn-info'},
            {name: 'italic', className: 'btn-info'},
            {name: 'strikethrough', className: 'btn-info'},
            {name: 'underline', className: 'btn-info'},
            null,
            {name: 'insertunorderedlist', className: 'btn-success'},
            {name: 'insertorderedlist', className: 'btn-success'},
            {name: 'outdent', className: 'btn-purple'},
            {name: 'indent', className: 'btn-purple'},
            null,
            {name: 'justifyleft', className: 'btn-primary'},
            {name: 'justifycenter', className: 'btn-primary'},
            {name: 'justifyright', className: 'btn-primary'},
            {name: 'justifyfull', className: 'btn-inverse'},
            null,
            {name: 'createLink', className: 'btn-pink'},
            {name: 'unlink', className: 'btn-pink'},
            null,
            {name: 'insertImage', className: 'btn-success'},
            null,
            'foreColor',
            null,
            {name: 'undo', className: 'btn-grey'},
            {name: 'redo', className: 'btn-grey'}
        ],
        'wysiwyg': {
            'height': 500,
            fileUploadError: showErrorAlert
        }
    }).prev().addClass('wysiwyg-style2');

    function showErrorAlert(reason, detail) {
        var msg = '';
        if (reason === 'unsupported-file-type') {
            msg = "Unsupported format " + detail;
        }
        else {
            //console.log("error uploading file", reason, detail);
        }
        $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
    }
</script>
</body>
</html>