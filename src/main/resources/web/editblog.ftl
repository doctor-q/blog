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
                <div class="col-xs-2"></div>
                <div class="col-xs-8">
                    <div class="col-xs-12">
                        <div class="header blue">标题</div>
                        <input class="form-control" <#if blogDetail??>value="{{blogDetail.title}}"</#if>>
                    </div>
                    <div class="col-sm-12">
                        <div class="header blue">内容</div>

                        <div class="widget-box">
                            <div class="widget-body">
                                <div class="widget-main no-padding">
                                    <div class="wysiwyg-editor" id="editor1"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-xs-12">
                        <div class="header blue">分类</div>
                        <div>
                            <label class="col-xs-3">
                                <input name="category" type="radio">Java
                            </label>
                            <label class="col-xs-3">
                                <input name="category" type="radio">Mysql
                            </label>
                            <label class="col-xs-3">
                                <input name="category" type="radio">操作系统
                            </label>
                            <label class="col-xs-3">
                                <input name="category" type="radio">算法
                            </label>
                        </div>
                    </div>

                    <div class="col-xs-12">
                        <div class="header blue">
                            标签
                        </div>
                        <div>
                            <input type="text" class="form-control" name="tags" id="form-field-tags"
                                   placeholder="添加标签"/>
                        </div>
                    </div>

                    <div class="col-xs-12">
                        <div class="btn-group pull-right">
                            <button class="btn btn-sm btn-round">
                                <i class="ace-icon fa fa-floppy-o bigger-125"></i>
                                保存草稿
                            </button>

                            <button class="btn btn-sm btn-default btn-round">
                                <i class="ace-icon fa fa-globe bigger-125"></i>
                                发布
                                <i class="ace-icon fa fa-arrow-right icon-on-right bigger-125"></i>
                            </button>
                        </div>
                    </div>

                </div>
                <div class="col-xs-2"></div>
            </div>
        </div>
    </div>
</div>
<script src="/assets/js/jquery.hotkeys.index.min.js"></script>
<script src="/assets/js/bootstrap-wysiwyg.min.js"></script>
<script src="/assets/js/bootstrap-tag.min.js"></script>
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

    var tag_input = $('#form-field-tags');

    tag_input.tag(
            {
                placeholder: tag_input.attr('placeholder'),
                //enable typeahead by specifying the source array
                source: ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
                /**
                 //or fetch data from database, fetch those that match "query"
                 source: function(query, process) {
						  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
						  .done(function(result_items){
							process(result_items);
						  });
						}
                 */
            }
    );

    //programmatically add/remove a tag
    var $tag_obj = tag_input.data('tag');
    // $tag_obj.add('Programmatically Added');

    var index = $tag_obj.inValues('some tag');
    $tag_obj.remove(index);

</script>
</body>
</html>