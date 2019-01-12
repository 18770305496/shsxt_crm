// 格式化层级
function formateGrade(val) {
    if(val==0){
        return '根级节点';
    }else if(val==1){
        return '一级节点';
    }else if(val==2){
        return '二级节点';
    }
}

$(function () {
    $('#dlg').dialog({
        "onClose": function () {
            // 触发表单清空
            $('#fm').form('clear');
        }
    })

    // 判断是够显示第二个下拉
    $('#parentMenu').hide();
    
    $('#grade02').combobox({
        onSelect: function (val) {
            var grade = val.value;
            if(grade==0){
                $('#parentMenu').hide();
            }else{
                $('#parentMenu').show();
                $('#parentId02').combobox({
                    url:ctx + '/module/queryModulesByGrade?grade='+(grade-1),// 找上级
                    valueField:'id',
                    textField:'moduleName'
                });
            }


        }
    })
});

// 查询
function queryModulesByParams() {
    $('#dg').datagrid('load',{
        moduleName: $('#moduleName').val(),
        parentId: $('#pid').val(),
        grade: $('#grade').combobox('getValue'),
        optValue: $('#optValue').val()
    })
}

// 添加
function openAddModuleDailog() {
    openAddOrUpdateDlg('dlg','模块添加')
}
function saveOrUpdateModule() {
    saveOrUpdateData('fm',ctx + '/module/saveOrUpdateModule','dlg',queryModulesByParams);
}

// 删除
function deleteModule() {
    deleteData('dg',ctx + '/module/deleteModule', queryModulesByParams);
}