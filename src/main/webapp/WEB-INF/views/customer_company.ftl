<html>
<head>
<#include "common.ftl" >
<script type="text/javascript" src="${ctx}/js/customer.company.js?version=2.0"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/customerCompany/queryCustomersByParams" fit="true" toolbar="#tb">
    <thead frozen="true">
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center" hidden="true">编号</th>
        <th field="companyCode" width="120" align="center">公司编码</th>
        <th field="companyNameCn" width="80" align="center">公司中文名称</th>
        <th field="companyShortName" width="50" align="center">简称</th>
        <th field="companyType" width="50" align="center">公司类型</th>
        <th field="country" width="50" align="center">国家</th>
        <th field="contact" width="70" align="center">联系人</th>
        <th field="mobile" width="50" align="center">电话</th>
        <th field="phone" width="60" align="center">手机</th>
    </tr>
    </thead>
    <thead >
    <tr>
        <th field="companyClass" width="60" align="center">公司类别</th>
        <th field="parentSysNo" width="60" align="center">商家主键</th>
        <th field="city" width="70" align="center">城市</th>
        <th field="address" width="120" align="center">地址</th>
        <th field="fax" width="60" align="center">传真</th>
        <th field="email" width="100" align="center">邮箱</th>
        <th field="comments" width="100" align="center">备注</th>
        <th field="yn" width="60" align="center">是否有效</th>
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
       class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
    <a href="javascript:deleteCustomer()" class="easyui-linkbutton"
       iconCls="icon-remove" plain="true">删除</a>
    <br/>
    手机号码:<input type="text" id="phone"/>
    电话号码:<input type="text" id="mobile">
    公司编码: <input type="text" id="companyCode"/>
    公司中文名称: <input type="text" id="companyNameCn"/>
    <a href="javascript:queryCustomersByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>


<div id="dlg" class="easyui-dialog"
     style="width:700px;height:450px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <input type="hidden" id="id" name="id" />
        <table cellspacing="8px">
            <tr>
                <td>公司中文名称： </td>
                <td><input type="text" id="companyNameCn" name="companyNameCn"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>公司类型： </td>
                <td>
                    <select class="easyui-validatebox" style="width: 154px"
                            id="companyType" name="companyType" editable="false" panelHeight="auto">
                        <option value="01">自营</option>
                        <option value="03">第三方</option>
                    </select>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>公司简称： </td>
                <td>
                    <input class="easyui-validatebox" id="companyShortName" name="companyShortName"
                            required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>公司类别： </td>
                <td>
                    <select class="easyui-validatebox" style="width: 154px"
                            id="companyClass" name="companyClass" editable="false" panelHeight="auto">
                        <option value="01">商家</option>
                        <option value="03">店铺</option>
                    </select>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>国家: </td>
                <td>
                    <input class="easyui-validatebox" id="country" name="country"
                           required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>城市: </td>
                <td>
                    <input class="easyui-validatebox" id="city" name="city"
                           required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>联系人： </td>
                <td><input type="text" id="contact" name="contact"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>电话： </td>
                <td><input type="text" id="mobile" name="mobile"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
            </tr>
            <tr>
                <td>传真： </td>
                <td><input type="text" id="fax" name="fax"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>邮箱： </td>
                <td><input type="text" id="email" name="email"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
            </tr>
            <tr>
                <td>地址</td>
                <td colspan="4">
                    <input type="text" id="address" name="address"
                           style="width: 400px" class="easyui-validatebox"
                           required="true"/>&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>备注： </td>
                <td><input type="text" id="comments" name="comments" /></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>手机： </td>
                <td><input type="text" id="phone" name="phone"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>

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
                  class="easyui-validatebox" required="true" />&nbsp;<font color="red">*</font></td>
                <td>&nbsp;&nbsp;</td>
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
