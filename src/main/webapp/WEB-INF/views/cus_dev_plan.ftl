<html>
<head>
<#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/cus.dev.plan.js"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/saleChance/querySaleChancesByParams?state=1" fit="true" toolbar="#tb" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50" align="center">编号</th>
        <th field="chanceSource" width="200" align="center" >机会来源</th>
        <th field="customerName" width="50" align="center">客户名称</th>
        <th field="cgjl" width="50" align="center" >成功几率</th>
        <th field="overview" width="200" align="center">概要</th>
        <th field="linkMan" width="100" align="center">联系人</th>
        <th field="linkPhone" width="100" align="center">联系电话</th>
        <th field="trueName" width="200" align="center" >指派人</th>
        <th field="assignTime" width="200" align="center" >指派时间</th>
        <th field="devResult" width="200" align="center" formatter="formatterDevResult">客户开发状态</th>
        <th field="op" width="200" align="center" formatter="formatterOp" >操作</th>
    </tr>
    </thead>
</table>
<div id="tb">
    客户名称:<input type="text" id="customerName"/>
    开发结果:
    <select  class="easyui-combobox"  id="devResult"  panelHeight="auto">
        <option value="">全部</option>
        <option value="0">未开发</option>
        <option value="1">开发中</option>
        <option value="2">开发成功</option>
        <option value="3">开发失败</option>
    </select>
    创建时间:<input id="time" type="text" class="easyui-datebox" ></input>
    <a href="javascript:querySaleChancesByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>


</body>
</html>
