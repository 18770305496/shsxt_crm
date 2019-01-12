<html>
<head>
<#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/customer.serve.js"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/customerServe/queryCustomerServesByParams?state=1" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="customer" width="50" align="center">客户名称</th>
        <th field="overview" width="50" align="center" >概要</th>
        <th field="serveType" width="50" align="center">服务类型</th>
        <th field="createPeople" width="50" align="center">服务创建人</th>
        <th field="createDate" width="50" align="center">创建时间</th>
        <th field="assigner" width="50" align="center" hidden="true">分配人</th>
        <th field="assignTime" width="50" align="center" hidden="true">分配时间</th>
        <th field="serviceProcePeople" width="50" align="center" hidden="true">服务处理人</th>
        <th field="serviceProceTime" width="50" align="center" hidden="true">服务处理时间</th>
    </tr>
    </thead>
</table>
<div id="tb">
<a href="javascript:openCustomerServeAssignDialog()" class="easyui-linkbutton" iconCls="icon-save" plain="true">分配</a>
</div>


<!--分配信息 对话框-->
<div id="dlg" class="easyui-dialog" title="服务分配" closed="true" style="width:600px;height:350px;"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <input type="hidden" id="id" name="id" />
        <input type="hidden" id="state" name="state" />
        <table >
            <tr>
                <td>服务类型：</td>
                <td>
                    <input type="text" id="serveType" readonly="readonly" name="serveType" />
                </td>

                <td>客户：</td>
                <td><input type="text" id="customer" readonly="readonly" name="customer" />
            </tr>
            <tr>
                <td>概要：</td>
                <td colspan="4">
                    <input type="text" id="overview" readonly="readonly" name="overview"
                           style="width: 419px" />
                </td>
            </tr>
            <tr>
                <td>服务请求：</td>
                <td colspan="4">
 <textarea id="serviceRequest" readonly="readonly" name="serviceRequest"
           rows="5" cols="49" ></textarea>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>创建人：</td>
                <td >
                    <input id="createPeople"
                           name="createPeople" readonly="readonly"></input>
                </td>

                <td>创建时间：</td>
                <td >
                    <input id="createDate" name="createDate"  readonly="readonly"></input>
                </td>
            </tr>
            <tr>
                <td>分配给：</td>
                <td>
                    <select name="assigner" class="easyui-combobox"
                            url="${ctx}/saleChance/queryAllCustomerManager" valueField="id"
                            textField="trueName" style="width:200px;" editable="false"
                            panelHeight="auto">
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:addCustomerServeAssign()"
       class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeCustomerServeDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>



</body>
</html>
