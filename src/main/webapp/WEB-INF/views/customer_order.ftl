<html>
<head>
<#include "common.ftl" >
 <script type="text/javascript" src="${ctx}/js/customer.order.js"></script>
</head>
<body style="margin: 15px">
<!--
  通过面板展示营销机会详情数据
-->
<!--客户信息-->
<input type="hidden" id="cusId" name="cusId"  value="${customer.id}"/>
<div id="p" class="easyui-panel" title="客户信息" style="width:700px;height:200px">
    <table cellspacing="8px">
        <tr>
            <td>客户编号： </td>
            <td><input type="text" id="khno" name="khno"
                       readonly="readonly" value="${(customer.khno)!""}" /></td>

            <td>客户名称</td>
            <td><input type="text" id="name" name="name"
                       readonly="readonly" value="${(customer.name)!""}"/></td>
        </tr>
    </table>
</div>
<br/>
<br/>

        <table id="dg" class="easyui-datagrid" title="客户订单记录"
               style="width:700px;height:300px"
               pagination="true" rownumbers="true"
               url="${ctx}/customerOrder/queryCustomerOrdersByParams?cusId=${customer.id}" singleSelect="true">
            <thead>
            <tr>
                <th field="id" width="50">编号</th>
                <th field="orderNo" name="orderNo" width="50" >订单号</th>
                <th field="orderDate" name="orderDate" width="100" >订单日期</th>
                <th field="address" name="address" width="100" >地址</th>
                <th field="state" name="address" width="100" formatter="formateState">状态</th>
                <th field="op" name="address" width="100" formatter="formateOp">操作</th>
            </tr>
            </thead>
        </table>

<!--客户订单详情信息-->
<div id="dlg" class="easyui-dialog"
     style="width:700px;height:450px;padding: 10px 20px"
     closed="true" title="订单详情查看" buttons="#dlg-buttons">
    <div id="p" class="easyui-panel" title="订单信息" style="width:700px;height: 150px;padding: 10px">
        <form id="fm">
            <table cellspacing="8px">
                <tr>
                    <td>订单编号：</td>
                    <td><input type="text" id="orderNo" name="orderNo" readonly="readonly" /></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>订购日期</td>
                    <td><input type="text" id="orderDate"
                               name="orderDate" readonly="readonly" value="aa"/></td>
                </tr>
                <tr>
                    <td>送货地址：</td>
                    <td><input type="text" id="address" name="address"
                               readonly="readonly" /></td>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td>状态</td>
                    <td><input type="text" id="status" name="state"
                               readonly="readonly" /></td>
                </tr>
                <tr>
                    <td>总金额：</td>
                    <td><input type="text" id="sum" name="sum"  readonly="readonly" /></td>
                </tr>
            </table>
        </form>
    </div>
    <br/>
    <table id="dg2" class="easyui-datagrid" title="客户订单详情"
           style="width:700px;height:250px"
           pagination="true" rownumbers="true"
           fit="true" fitColumns="true" >
        <thead>
        <tr>
            <th field="orderId" width="50">编号</th>
            <th field="goodsName" name="goodsName" width="50" >商品
                名称</th>
            <th field="goodsNum" name="goodsNum" width="100" >订购数
                量</th>
            <th field="unit" name="unit" width="100" >单位</th>
            <th field="price" name="price" width="100" >单价</th>
            <th field="sum" name="sum" width="100" >金额</th>
        </tr>
        </thead>
    </table>
</div>
<div id="dlg-buttons">
    <a href="javascript:closeOrderDetailDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>






</body>