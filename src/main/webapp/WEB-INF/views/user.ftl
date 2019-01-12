<html>
<head>
<#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/user.js"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/user/queryUsersByParams" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="userName" width="100" align="center" >用户名</th>
        <th field="trueName" width="100" align="center" >真实名称</th>
        <th field="email" width="100" align="center" >邮箱</th>
        <th field="phone" width="100" align="center" >手机号</th>
        <th field="createDate" width="100" align="center" >创建时间</th>
        <th field="updateDate" width="100" align="center" >更新时间</th>
        <th field="roleName" width="100" align="center">所属角色</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <a href="javascript:openAddUserDailog()" class="easyui-linkbutton" iconCls="icon-save" plain="true">添加</a>
    <a href="javascript:openModifyUserDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">更新</a>
    <a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    <br/>
    用户名:<input type="text" id="userName"/>
    邮箱:<input type="text" id="email"/>
    手机号:<input type="text" id="phone"/>
    <a href="javascript:queryUsersByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>


<div id="dlg" class="easyui-dialog" title="添加营销记录" closed="true"
     style="width: 500px;height:300px" buttons="#bt">
    <form  id="fm" method="post">
        用户名:<input type="text"  class="easyui-validatebox"  required="required" id="userName02" name="userName"/><br/><br/>
        真实名称:<input type="text" id="trueName" class="easyui-validatebox" name="trueName"  required="required"/><br/><br/>
        邮箱:<input type="text" id="email02" name="email"  class="easyui-validatebox" required="required"/><br/><br/>
        手机号:<input type="text" name="phone"  id="phone02" class="easyui-validatebox" required="required"/><br/><br/>
        角色:<input class="easyui-combobox" id="roleIds" name="roleIds"
                   valueField="id" textField="roleName"
                   url="${ctx}/role/queryAllRoles" panelHeight="auto" multiple="true"  /><br/><br/>
        <input name="id" id="id" type="hidden"/>
    </form>
</div>

<div id="bt">
    <a href="javascript:saveOrUpdateUser()" class="easyui-linkbutton" plain="true" iconCls="icon-save">保存</a>
    <a href="javascript:closeDlg()" class="easyui-linkbutton" plain="true" iconCls="icon-cancel">取消</a>
</div>


</body>
</html>
