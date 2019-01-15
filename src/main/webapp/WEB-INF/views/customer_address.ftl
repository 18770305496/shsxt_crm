<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/customer.address.js?version=3.0"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
       pagination="true" rownumbers="true"
       url="${ctx}/customerAddress/queryCustomersByParams" fit="true" toolbar="#tb">
    <thead frozen="true">
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center" hidden="true">编号</th>
        <th field="customerId" width="80" align="center">客户主键</th>
        <th field="name" width="70" align="center">客户姓名</th>
        <th field="mobile" width="80" align="center">客户电话</th>
        <th field="address" width="100" align="center">客户地址</th>
        <th field="zipCode" width="60" align="center">邮政编码</th>
        <th field="remark" width="100" align="center">备注</th>
        <th field="street" width="100" align="center">街道</th>
        <th field="areaRegion" width="60" align="center">区域</th>
    </tr>
    </thead>
    <thead >
    <tr>
        <th field="phone" width="100" align="center">手机号码</th>
        <th field="yn" width="50" align="center">是否有效</th>
        <th field="ts" width="100" align="center">时间节点</th>
        <th field="createTime" width="100" align="center">创建时间</th>
        <th field="createPin" width="100" align="center">创建人</th>
        <th field="updatePin" width="100" align="center">更新人</th>
        <th field="versions" width="50" align="center">版本号</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <a href="javascript:openAddCustomerDialog()"
       class="easyui-linkbutton" iconCls="icon-add" plain="true">创建</a>
    <a href="javascript:openModifyCustomerDialog()"
       class="easyui-linkbutton" iconCls="icon-edit" plain="true">更新</a>
    <a href="javascript:deleteCustomer()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
    <br/>
    客户姓名:<input type="text" id="name"/>
    客户电话:<input type="text" id="mobile">
    手机号码: <input type="text" id="phone"/>
    <a href="javascript:queryCustomersByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>


<div id="dlg" class="easyui-dialog"
     style="width:700px;height:350px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <input type="hidden" id="id" name="id" />
        <table cellspacing="8px">
            <tr>
                <td>客户姓名： </td>
                <td>
                    <input type="text" class="easyui-validatebox"
                            id="name" name="name" required="true"/>
                    &nbsp;<font color="red">*</font>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>客户电话： </td>
                <td>
                    <input class="easyui-validatebox" id="mobile" name="mobile"
                           required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>客户主键： </td>
                <td><input type="text" id="customerId" name="customerId"
                class="easyui-validatebox" />&nbsp;
                    <font color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>手机号码： </td>
                <td>
                    <input class="easyui-validatebox"
                           id="phone" name="phone" required="true">
                    &nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>街道: </td>
                <td>
                    <input class="easyui-validatebox" id="street" name="street"
                           required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>区域: </td>
                <td>
                    <input class="easyui-validatebox" id="areaRegion" name="areaRegion"
                           required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>邮政编码： </td>
                <td><input type="text" id="zipCode" name="zipCode"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>备注： </td>
                <td><input type="text" id="comments" name="comments" class="easyui-validatebox" /></td>
            </tr>
            <tr>
                <td>客户地址: </td>
                <td colspan="4">
                    <input type="text" id="address" name="address"
                           style="width: 400px" class="easyui-validatebox"
                           required="true"/>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>创建人： </td>
                <td><input type="text" id="createPin" name="createPin"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>更新人： </td>
                <td><input type="text" id="updatePin" name="updatePin"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
            </tr>
            <tr>
                <td>版本号： </td>
                <td><input type="text" id="versions" name="versions"
                           class="easyui-validatebox" />&nbsp;<font color="red">*</font></td>
            </tr>
        </table>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:saveOrUpdateCustomer()"
       class="easyui-linkbutton" iconCls="icon-ok">保存</a>
    <a href="javascript:closeCustomerDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>


</body>
</html>
