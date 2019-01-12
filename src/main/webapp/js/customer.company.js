//查询
function queryCustomersByParams() {
    $('#dg').datagrid('load',{
        phone: $('#phone').val(),
        mobile:$("#mobile").val(),
        companyCode:$("#companyCode").val(),
        companyNameCn:$("#companyNameCn").val()
    });
}
//添加
function openAddCustomerDialog() {

    $('#fm')[0].reset();//默认为空

    $("#id").val("");// 设置地址之后进行查询
    openAddOrUpdateDlg('dlg','添加公司名称')
}

function saveOrUpdateCustomer() {
    saveOrUpdateData('fm',ctx + '/customerCompany/saveOrUpdateCompanyCustomer','dlg',queryCustomersByParams);
}

//修改
function openModifyCustomerDialog() {
    openModifyDialog('dg','fm','dlg','修改公司信息')
}

//删除
function deleteCustomer() {
    deleteData('dg',ctx+'/customerCompany/deleteCustomerBatch',queryCustomersByParams);
}

function openCustomerOtherInfo(name, type) {
    var rows = $('#dg').datagrid("getSelections");
    if (rows.length == 0) {
        $.messager.alert('来自Crm', "请选择一条数据");
        return;
    }
    if (rows.length > 1) {
        $.messager.alert('来自Crm', "只能选择一条数据");
        return;
    }

    var cusId = rows[0].id;
    if(type==3){
        window.parent.openTab(name+'_'+cusId,ctx+"/customerOrder/index?cusId="+cusId);
    }
}