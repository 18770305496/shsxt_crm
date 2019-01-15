//查询
function queryCustomersByParams() {
    $('#dg').datagrid('load',{
        name: $('#name').val(),
        mobile:$("#mobile").val(),
        phone:$("#phone").val()
    });
}
//添加
function openAddCustomerDialog() {

    $('#fm')[0].reset();//默认为空

    $("#id").val("");// 设置地址之后进行查询
    openAddOrUpdateDlg('dlg','新建公司地址管理')
}

function saveOrUpdateCustomer() {
    saveOrUpdateData('fm',ctx + '/customerAddress/saveOrUpdateCompanyAddress','dlg',queryCustomersByParams);
}

//更新
function openModifyCustomerDialog() {
    openModifyDialog('dg','fm','dlg','更新公司信息')
}

//删除
function deleteCustomer() {
    deleteData('dg',ctx+'/customerAddress/deleteAddressBatch',queryCustomersByParams);
}
