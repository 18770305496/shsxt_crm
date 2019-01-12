<html>
<head>
<#include "common.ftl" >
<script type="text/javascript" src="${ctx}/js/customer.loss.js"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/customerLoss/queryCustomerLossByParams" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="cusName" width="200" align="center" >客户名称</th>
        <th field="cusNo" width="50" align="center">客户编号</th>
        <th field="cusManager" width="50" align="center">客户经理</th>
        <th field="lastOrderTime" width="50" align="center">上次下单时间</th>
        <th field="confirmLossTime" width="50" align="center">确认流失时间</th>
        <th field="state" width="50" align="center" formatter="formateState">状态</th>
        <th field="lossReason" width="50" align="center">流失原因</th>
        <th field="createDate" width="50" align="center">创建时间</th>
        <th field="updateDate" width="50" align="center">更新时间</th>
        <th field="op" width="50" align="center" formatter="formateOp">操作</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <br/>
    客户名称:<input type="text" id="cusName"/>
    客户编号:<input type="text" id="cusNo"/>
    创建时间:<input id="time" type="text" class="easyui-datebox" ></input>
    <a href="javascript:queryCustomerLossByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>


</body>
</html>
