<%-- 
    Document   : search
    Created on : Jan 28, 2018, 9:25:38 AM
    Author     : Milap Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<input class="easyui-searchbox modulesSearch" data-options="prompt:'Search for modules'" style="width:200px;padding: 20px;">
<a href="javascript:void(0)" onclick="Setting.prototype.createNewModuleForm('modules')" class="easyui-linkbutton" data-options="iconCls:'icon-add'">Add New Module</a>
<a href="javascript:void(0)" onclick="Setting.prototype.deleteModuleSelected('modules')"class="easyui-linkbutton" data-options="iconCls:'icon-remove'">Remove Selection</a>
<script>
    $('.modulesSearch').searchbox({
        searcher: function (value, name) {
            alert(value + "," + name);
        },
        prompt: 'Please Input Value'
    });
</script>
