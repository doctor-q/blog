function formValues($form) {
    var formValues = {};
    iterNameValue($form.find('input'));
    iterNameValue($form.find('select'));
    return formValues;
}

function iterNameValue($elements, formValues) {
    $.each($elements, function (i, item) {
        var name = $(item).attr('name');
        if (name != null) {
            formValues[name] = $(item).val();
        }
    });
}

function setFormValues($form, obj) {
    for (var key in obj) {
        var value = obj[key];

        $form.find("[name='" + key + "'],[name='" + key + "[]']").each(function () {
            var tagName = $(this)[0].tagName;
            var type = $(this).attr('type');
            if (tagName === 'INPUT') {
                if (type === 'radio') {
                    $(this).attr('checked', $(this).val() === value);
                } else if (type === 'checkbox') {
                    var arr = value.split(',');
                    for (var i = 0; i < arr.length; i++) {
                        if ($(this).val() === arr[i]) {
                            $(this).attr('checked', true);
                            break;
                        }
                    }
                } else {
                    $(this).val(value);
                }
            } else if (tagName === 'SELECT' || tagName === 'TEXTAREA') {
                $(this).val(value);
            }
        });
    }
}