<html>
<head>
<#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${ctx}/js/customer.loss.reprieve.js"></script>
    </head>
<body style="margin: 15px">
    <!--
      通过面板展示营销机会详情数据
    -->
    <div id="p" class="easyui-panel" title="销售机会信息" style="width: 700px;height: 400px;padding: 10px">
        <table cellspacing="8px">
           <#-- <input type="hidden" id="saleChanceId" name="saleChanceId" value="${saleChance.id}"/>
            <input type="hidden" id="devResult"  value="${saleChance.devResult}"/>-->
               <input type="hidden" id="lossId" name="saleChanceId" value="${customerLoss.id}"/>
               <input type="hidden" id="state" name="state" value="${customerLoss.state}"/>
            <tr>
                <td>客户名称：</td>
                <td><input type="text"  readonly="readonly" value="${(customerLoss.cusName)!""}" /></td>
                <td>   </td>
                <td>客户编号</td>
                <td><input type="text"  readonly="readonly" value="${(customerLoss.cusNo)!""}"/></td>
            </tr>
        </table>
    </div>
    <br/>
    <#--开发计划详情记录-->
    <table id="dg" title="开发计划项" style="width:700px;height: 300px;"
           toolbar="#toolbar" idField="id" pagination="true" rownumbers="true"   >
        <thead>
        <tr>
            <th field="id" width="50">编号</th>
            <th field="measure" width="100" editor="{type:'validatebox',options:{required:true}}">处理措施</th>
        </tr>
        </thead>
    </table>

    <div id="toolbar">
        <a href="javascript:addRow()" class="easyui-linkbutton" iconCls="icon-add"  plain="true" >添加暂缓处理</a>
        <a href="javascript:delCusDevPlan()" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >删除暂缓</a>
        <a href="javascript:saveOrUpdateCusDevPlan()" class="easyui-linkbutton" iconCls="icon-save" plain="true" >保存暂缓措施</a>
        <a href="javascript:$('#dg').edatagrid('cancelRow')" class="easyui-linkbutton" iconCls="icon-undo" plain="true" >撤销行</a>
        <a href="javascript:confirmLoss()" class="easyui-linkbutton" iconCls="icon-kfcg" plain="true" >确认流失</a>
    </div>


</body>