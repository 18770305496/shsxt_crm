function formatterDevResult(value, row, index) {
    if (0 == value) {
        return "未开发";
    } else if (1 == value) {
        return "开发中";
    } else if (2 == value) {
        return "开发成功";
    } else if (3 == value) {
        return "开发失败";
    }
}
function formatterOp(value, row, index) {
    // var devResult = row.devResult;
    // // 0 未开发 1 开发中
    // if(devResult==0 || devResult==1){
    //     return '<a href="javascript:;">开发</a>';
    // }else{
    //     return '<a href="javascript:;">查看详情</a>';
    // }
    var devResult=row.devResult;
    if(devResult==0||devResult==1){
        var href="javascript:openSaleChanceInfoDialog("+'"开发机会数据"'+","+row.id+")";
        return "<a href='"+href+"'>开发</a>";
    }
    if(devResult==2||devResult==3){
        var href="javascript:openSaleChanceInfoDialog("+'"详情机会数据"'+","+row.id+")";
        return "<a href='"+href+"'>查看详情</a>";
    }
}

// 查询方法
function querySaleChancesByParams() {
    $('#dg').datagrid('load', {
        customerName: $('#customerName').val(),
        devResult: $('#devResult').combobox('getValue'),
        createDate: $('#time').datebox('getValue')
    });
}

function openSaleChanceInfoDialog(title,id) {
    /**
     * 打开新的选项卡
     */
    window.parent.openTab(title+"_"+id,ctx+"/cusDevPlan/index?sid="+id);
}