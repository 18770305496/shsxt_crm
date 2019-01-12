<html>
<head>
<#include "common.ftl" >
<script type="text/javascript" src="${ctx}/js/module.js"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
        pagination="true" rownumbers="true"
       url="${ctx}/module/queryModulesByParams" fit="true" toolbar="#tb" singleSelect="true">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="moduleName" width="100" align="center" >模块名称</th>
        <th field="parentId" width="100" align="center" >上级id</th>
        <th field="grade" width="100" align="center"  formatter="formateGrade">层级</th>
        <th field="optValue" width="100" align="center" >权限码</th>
        <th field="orders" width="100" align="center" >排序</th>
        <th field="createDate" width="100" align="center" >创建时间</th>
        <th field="updateDate" width="100" align="center" >更新时间</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <a href="javascript:openAddModuleDailog()" class="easyui-linkbutton" iconCls="icon-save" plain="true">添加</a>
    <a href="javascript:openModifyModuleDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">更新</a>
    <a href="javascript:deleteModule()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
    <br/>
    模块名:<input type="text" id="moduleName"/>
    上级菜单id:<input type="text" id="pid"/>
    层级:
    <select id="grade" class="easyui-combobox" name="grade"  panelHeight="auto">
        <option value="">全部</option>
        <option value="0">根级菜单</option>
        <option value="1">一级菜单</option>
        <option value="2">二级菜单</option>
    </select>
    权限码:<input type="text" id="optValue"/>
    <a href="javascript:queryModulesByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
</div>


<div id="dlg" class="easyui-dialog" title="添加模块" closed="true"
     style="width: 500px;height:300px" buttons="#bt">
    <form  id="fm" method="post">
        模块名称:<input type="text"  class="easyui-validatebox"  required="required" id="moduleName02" name="moduleName"/><br/><br/>
        权限码:<input type="text" id="optValue02" class="easyui-validatebox" name="optValue"  required="required"/><br/><br/>
        菜单层级:
        <select id="grade02" class="easyui-combobox" name="grade"  panelHeight="auto">
        <option value="0">根级菜单</option>
        <option value="1">一级菜单</option>
        <option value="2">二级菜单</option>
    </select><br/><br/>
        <div id="parentMenu">
            上级菜单:<input id="parentId02" class="easyui-combobox" name="parentId" panelHeight="auto" />  <br/><br/>
        </div>

        序号:<input id="orders" name="orders"/>  <br/><br/>
        <input name="id" id="id" type="hidden"/>
    </form>
</div>

<div id="bt">
    <a href="javascript:saveOrUpdateModule()" class="easyui-linkbutton" plain="true" iconCls="icon-save">保存</a>
    <a href="javascript:closeDlg()" class="easyui-linkbutton" plain="true" iconCls="icon-cancel">取消</a>
</div>


</body>
</html>
