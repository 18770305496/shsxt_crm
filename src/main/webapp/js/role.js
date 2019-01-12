// 查询
function queryRolesByParams() {
    $('#dg').datagrid('load',{
        roleName: $('#roleName').val(),
        createDate: $('#time').datebox('getValue')
    })
}

//添加
function openAddRoleDailog() {
    openAddOrUpdateDlg('dlg','添加角色')
}
function saveOrUpdateRole() {
    saveOrUpdateData('fm', ctx + '/role/saveOrUpdateRole','dlg',queryRolesByParams)
}
function openModifyRoleDialog() {
    openModifyDialog('dg','fm','dlg','更新角色')
}

// 授权
function openRelationPermissionDialog() {
    var rows = $('#dg').datagrid("getSelections");
    if (rows.length == 0) {
        $.messager.alert('来自Crm', "请选择一条数据进行授权");
        return;
    }
    if (rows.length > 1) {
        $.messager.alert('来自Crm', "只能选择一条数据进行授权");
        return;
    }
    // 打开弹窗
    $('#permissionDlg').dialog("open");
    // 设置 roleId
    $('#roleId').val(rows[0].id);
    // 加载树
    loadTree(rows[0].id);// roleId
}
var zTreeObj;


function loadTree(roleId) {
    var setting = {
        check: {
            enable: true,
            chkboxType :{ "Y" : "ps", "N" : "ps" }
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onCheck: zTreeOnCheck
        }
    };
    $.ajax({
        url: ctx + '/module/queryAllModuleByRoleId?roleId='+roleId,
        success:function (data) {

            var zNodes = data;
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);

            zTreeOnCheck();// 初始化moduleIds
        }
    });
}

function zTreeOnCheck() {
    var nodes = zTreeObj.getCheckedNodes(true);
    //console.log(nodes);
    var moduleIds="";
    for (var i=0; i<nodes.length; i++){
        moduleIds +="moduleIds="+nodes[i].id+"&"
    }
    //console.log(moduleIds);
    $('#moduleIds').val(moduleIds);

}

function doGrant() {
    var roleId = $('#roleId').val();
    var moduleIds = $('#moduleIds').val();
    $.ajax({
        url: ctx + '/role/doGrant?roleId='+roleId+'&'+moduleIds,
        success:function (data) {
            if (data.code == 200) {
                $.messager.alert('来自Crm', data.msg, 'info', function () {
                    // 关闭弹窗
                    $('#permissionDlg').dialog('close');
                    // // 刷新数据表格
                    // $('#dg').datagrid('load');
                });
            } else {
                $.messager.alert('来自Crm', data.msg, 'error');
            }
        }
    })
}

// 删除
function deleteRole() {
    deleteData('dg',ctx + '/role/deleteRoleBatch',queryRolesByParams);
}









