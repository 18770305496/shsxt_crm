function formateState(val) {
    if(val==0){
        return "未支付"
    }
    if(val==1){
        return "已支付"
    }
}

function formateOp(val, row) {
    var orderId = row.id;
    var href = "javascript:openOrderDeatilDialog(" + orderId + ")";
    return "<a href=" + href + ">查看详情</a>";
}

function openOrderDeatilDialog(orderId) {
    var rows = $('#dg').datagrid("getSelections");
    // console.log(rows);
    // 打开窗口
    $('#dlg').dialog('open');
    // 回显表单数据
    $('#fm').form('load',rows[0]);

    // 回显订单详情
    $('#dg2').datagrid({
        url: ctx + '/orderDetails/queryOrderDetailsByParams?orderId='+rows[0].id
    })

}