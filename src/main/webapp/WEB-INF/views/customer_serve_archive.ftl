<html>
<head>
<#include "common.ftl" >
<script type="text/javascript" src="${ctx}/js/customer.serve.js"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/customerServe/queryCustomerServesByParams?state=4" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="customer" width="50" align="center">客户名称</th>
        <th field="overview" width="50" align="center" >概要</th>
        <th field="serveType" width="50" align="center">服务类型</th>
        <th field="createPeople" width="50" align="center">服务创建人</th>
        <th field="createDate" width="50" align="center">创建时间</th>
        <th field="assigner" width="50" align="center">分配人</th>
        <th field="assignTime" width="50" align="center" >分配时间</th>
        <th field="serviceProcePeople" width="50" align="center" >服务处理人</th>
        <th field="serviceProceTime" width="50" align="center" >服务处理时间</th>
        <th field="serviceProceResult" width="50" align="center" >处理结果</th>
        <th field="myd" width="50" align="center" >满意度</th>
    </tr>
    </thead>
</table>
<div id="tb">
    客户名称:<input type="text" id="cusName"/>

   满意度:
    <select id="myd" class="easyui-combobox" name="myd"
            style="width:200px;" editable="false" panelHeight="auto">
        <option value="">请选择</option>
        <option value="☆">☆</option>
        <option value="☆☆">☆☆</option>
        <option value="☆☆☆">☆☆☆</option>
        <option value="☆☆☆☆">☆☆☆☆</option>
        <option value="☆☆☆☆☆">☆☆☆☆☆</option>
    </select>

    创建时间:<input id="time" type="text" class="easyui-datebox" ></input>
    <a href="javascript:queryCustomerServesByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>





</body>
</html>
