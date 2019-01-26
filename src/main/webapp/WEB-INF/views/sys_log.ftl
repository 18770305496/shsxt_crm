<html>
<head>
    <#include "common.ftl" >
    <script type="text/javascript" src="${ctx}/js/sys.log.js?version=2.0"></script>
</head>
<body style="margin: 1px">
<table id="dg"  class="easyui-datagrid"
       pagination="true" rownumbers="true"
       url="${ctx}/sysLog/queryCustomersByParams" fit="true" toolbar="#tb">
    <thead frozen="true">
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center" hidden="true">编号</th>
        <th field="type" width="80" align="center">日志类型</th>
        <th field="title" width="70" align="center">日志标题</th>
        <th field="createBy" width="80" align="center">创建者</th>
        <th field="remoteAddr" width="60" align="center">操作IP地址</th>
        <th field="userAgent" width="100" align="center">用户代理</th>
        <th field="requestUri" width="100" align="center">请求URI</th>
        <th field="method" width="60" align="center">操作方式</th>
    </tr>
    </thead>
    <thead >
    <tr>
        <th field="params" width="100" align="center">操作提交的数据</th>
        <th field="exception" width="50" align="center">异常信息</th>
        <th field="createDate" width="100" align="center">创建时间</th>
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
    日志标题:<input type="text" id="title">
    创建者: <input type="text" id="createBy"/>
    用户代理:<input type="text" id="userAgent"/>
    <div>
        <label>日期范围：&nbsp;</label><input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
            value="<fmt:formatDate value="${log.beginDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
        <label>&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
            value="<fmt:formatDate value="${log.endDate}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
    </div>
    <a href="javascript:queryCustomersByParams()" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
</div>


<div id="dlg" class="easyui-dialog"
     style="width:700px;height:350px;padding: 10px 20px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post">
        <input type="hidden" id="id" name="id" />
        <table cellspacing="8px">
            <tr>
                <td>创建者： </td>
                <td>
                    <input type="text" class="easyui-validatebox"
                            id="createBy" name="createBy" required="true"/>
                    &nbsp;<font color="red">*</font>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>日志类型： </td>
                <td>
                    <input class="easyui-validatebox" id="type" name="type"
                           required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>日志标题： </td>
                <td><input type="text" id="title" name="title"
                class="easyui-validatebox" />&nbsp;
                    <font color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>操作IP地址： </td>
                <td>
                    <input class="easyui-validatebox"
                           id="remoteAddr" name="remoteAddr" required="true">
                    &nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>用户代理: </td>
                <td>
                    <input class="easyui-validatebox" id="userAgent" name="userAgent"
                           required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td>请求URI: </td>
                <td>
                    <input class="easyui-validatebox" id="requestUri" name="requestUri"
                           required="true"/>&nbsp;
                    <font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>操作方式： </td>
                <td><input type="text" id="method" name="method"
                           class="easyui-validatebox" required="true"/>&nbsp;<font
                        color="red">*</font></td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
            <tr>
                <td>操作提交的数据: </td>
                <td colspan="4">
                    <input type="text" id="params" name="params"
                           style="width: 400px" class="easyui-validatebox"
                           />&nbsp;<font color="red">*</font>
                </td>
            </tr>
            <tr>
                <td>异常信息: </td>
                <td colspan="4">
                    <input type="text" id="exception" name="exception"
                           style="width: 400px" />&nbsp;<font color="red">*</font>
                </td>
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
