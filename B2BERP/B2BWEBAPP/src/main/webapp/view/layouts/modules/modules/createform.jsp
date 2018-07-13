<%-- 
    Document   : edit
    Created on : Jan 28, 2018, 9:26:10 AM
    Author     : Milap Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">Module Create Form</div>
<form id="newModuleCreationform" action="domain/modules/create" method="post" novalidate style="margin:0;padding:20px 20px">
    
    <table id='newModuleCreationformTable' style="width: 100%">
        <tr>
            <td style="width: 15%">Module Name : </td>
            <td style="width: 35%"><input name="moduleName" class="easyui-textbox" data-options="label:'Module Name'" required="true" style="width:100%;height: 30px;"></td>
            <td style="width: 15%">Module Title : </td>
            <td style="width: 35%"><input name="moduleTitle" class="easyui-textbox" data-options="label:'Module Title'" required="true" style="width:100%;height: 30px;"></td>
        </tr>
        <tr>
            <td>Module Description : </td>
            <td><input name="moduleDesc" class="easyui-textbox" data-options="label:'Module Description'" required="true" style="width:100%;height: 30px;"></td>
            <td>Module Image : </td>
            <td><input name="moduleImage" class="easyui-textbox" data-options="label:'Module Image'" required="true" style="width:100%;height: 30px;"></td>
        </tr>
        <tr>
            <td>Module Type : </td>
            <td><input name="moduleType" class="easyui-textbox" data-options="label:'Module Type'" required="true" style="width:100%;height: 30px;"></td>
            <td>Module URL : </td>
            <td><input name="moduleUrl" class="easyui-textbox" data-options="label:'Module URL'" required="true" style="width:100%;height: 30px;"></td>
        </tr>
        <tr> 
            <td>Module CSS : </td>
            <td><input name="moduleCss" class="easyui-textbox" data-options="label:'Module CSS'" required="true" style="width:100%;height: 30px;"></td>
            <td>Module ICON CLASS : </td>
            <td><input name="moduleIconClass" class="easyui-textbox" data-options="label:'Module CLASS'" required="true" style="width:100%;height: 30px;"></td>
        </tr>
        <tr> 
            <td>Module IS PARENT : </td>
            <td>
                <input name="hasChildrenSwitch" class="easyui-switchbutton" data-options="onText:'Yes',offText:'No',onChange: function(checked){
                       console.log(checked);$('#newModuleCreationform input[name=hasChildren]').val(checked?1:0);
                       }" required="true" style="width:100%;height: 30px;">
                <input type="hidden" name="hasChildren" value="0">
            </td>
            <td>Module IS Active : </td>
            <td><input name="activeSwitch" class="easyui-switchbutton" data-options="onText:'Yes',offText:'No',onChange: function(checked){
                       console.log(checked);$('#newModuleCreationform input[name=active]').val(checked?1:0);
                       }" required="true" style="width:100%;height: 30px;">
                <input type="hidden" name="active" id='active' value="0">
            </td>
        </tr>
        <tr> 
            <td>Module Priority : </td>
            <td><input name="priorityIndex" class="easyui-numberbox" data-options="min:0,precision:0" required="true" style="width:100%;height: 30px;"></td>
            <td>Module Parent : </td>
            <td>
                <input name="parent" class="easyui-combotree" data-options="url:'domain/modules/modulestreecombo',method:'get',label:'Select Parent',labelPosition:'top'"required="true" style="width:100%;height: 30px;">
            </td>
        </tr>
    </table>
</form>

<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="Setting.prototype.createNewModules();" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton"  iconCls="icon-cancel" onclick="$('#modulesCreateForm').window({closed: true});" style="width:90px">Cancel</a>
</div>
<style>
    #newModuleCreationformTable tr td{
        padding: 10px;
    }
</style>
