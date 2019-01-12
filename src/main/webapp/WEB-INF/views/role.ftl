<html>
<head>
<#include "common.ftl" >
<link rel="stylesheet" href="${ctx}/zTree_v3-3.5.32/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/zTree_v3-3.5.32/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${ctx}/zTree_v3-3.5.32/js/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript" src="${ctx}/js/role.js"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/role/queryRolesByParams" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="roleName" width="100" align="center" >角色名</th>
        <th field="roleRemark" width="100" align="center" >备注</th>
        <th field="createDate" width="100" align="center" >创建时间</th>
        <th field="updateDate" width="100" align="center" >更新时间</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <a href="javascript:openAddRoleDailog()" class="easyui-linkbutton" iconCls="icon-save" plain="true">添加</a>
    <a href="javascript:openModifyRoleDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">更新</a>
    <a href="javascript:deleteRole()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    <a href="javascript:openRelationPermissionDialog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">关联权限</a>
    <br/>
    角色名:<input type="text" id="roleName"/>
    时间:<input id="time" type="text" class="easyui-datebox" ></input>
    <a href="javascript:queryRolesByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>


<div id="dlg" class="easyui-dialog" title="添加角色" closed="true"
     style="width: 500px;height:300px" buttons="#bt">
    <form  id="fm" method="post">
        角色名:<input type="text"  class="easyui-validatebox"  required="required" id="roleName02" name="roleName"/><br/><br/>
        备注:<input type="text" id="roleRemark"  name="roleRemark" /><br/><br/>
        <input name="id" id="id" type="hidden"/>
    </form>
</div>

<div id="bt">
    <a href="javascript:saveOrUpdateRole()" class="easyui-linkbutton" plain="true" iconCls="icon-save">保存</a>
    <a href="javascript:closeDlg()" class="easyui-linkbutton" plain="true" iconCls="icon-cancel">取消</a>
</div>



<div id="permissionDlg" class="easyui-dialog" title="权限分配" closed="true"
     style="width: 500px;height:300px" buttons="#bt02">
    <ul id="treeDemo" class="ztree"></ul>
    <input type="hidden" id="roleId" name="roleId"/>
    <input type="hidden" id="moduleIds" name="moduleIds" />
</div>

<div id="bt02">
    <a href="javascript:doGrant()" class="easyui-linkbutton" plain="true" iconCls="icon-save">授权</a>
    <a href="javascript:closePermissionDlg()" class="easyui-linkbutton" plain="true" iconCls="icon-cancel">取消</a>
</div>



</body>
</html>
