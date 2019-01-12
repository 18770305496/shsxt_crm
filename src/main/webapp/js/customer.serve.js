//添加服务
function saveCustomerServe() {
    $('#fm').form('submit', {
        url: ctx + '/customerServe/saveOrUpdateCustomerServe',
        onSubmit: function () {
            return $(this).form('validate');
        },
        success: function (data) {
            data = JSON.parse(data);
            if (data.code == 200) {
                $.messager.alert('来自Crm', data.msg, 'info', function () {
                    // 清空数据
                    $('#fm').form('clear');
                });
            } else {
                $.messager.alert('来自Crm', data.msg, 'error');
            }
        }
    });
}

//弹窗
function openCustomerServeAssignDialog() {
    var rows = $('#dg').datagrid("getSelections");
    if (rows.length == 0) {
        $.messager.alert('来自Crm', "请选择一条数据");
        return;
    }
    if (rows.length > 1) {
        $.messager.alert('来自Crm', "只能选择一条数据");
        return;
    }
    $('#fm').form('load',rows[0]);
    openAddOrUpdateDlg('dlg','操作')
}

function addCustomerServeAssign() {
    saveOrUpdateData('fm',ctx + '/customerServe/saveOrUpdateCustomerServe','dlg',function () {
        $('#dg').datagrid('load');
    })
}

function openCustomerServeProceDialog() {
    openCustomerServeAssignDialog();
}

function addCustomerServeProce() {
    addCustomerServeAssign();
}

function openCustomerServeFeedBackDialog() {
    openCustomerServeAssignDialog();
}
function addCustomerServeFeedBack() {
    addCustomerServeAssign();
}
function queryCustomerServesByParams() {
    $('#dg').datagrid('load',{
        customer: $('#cusName').val(),
        myd: $('#myd').combobox('getValue'),
        createDate: $('#time').datebox('getValue')
    })
}

















