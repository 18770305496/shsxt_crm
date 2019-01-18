//查询
function queryCustomersByParams() {
    $('#dg').datagrid('load',{
        title:$("#title").val(),
        createBy: $('#createBy').val(),
        userAgent:$("#userAgent").val()
    });
}
//添加
function openAddCustomerDialog() {

    $('#fm')[0].reset();//默认为空

    $("#id").val("");// 设置地址之后进行查询
    openAddOrUpdateDlg('dlg','添加用户管理')
}

function saveOrUpdateCustomer() {
    saveOrUpdateData('fm',ctx + '/sysLog/saveOrUpdateSysLog','dlg',queryCustomersByParams);
}

//修改
function openModifyCustomerDialog() {
    openModifyDialog('dg','fm','dlg','更改用户管理')
}

//删除
function deleteCustomer() {
    deleteData('dg',ctx+'/sysLog/deleteCustomerBatch',queryCustomersByParams);
}
